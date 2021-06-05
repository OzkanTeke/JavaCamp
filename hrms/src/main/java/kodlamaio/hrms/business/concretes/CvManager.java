package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvRepository;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService{
	
	private CvRepository cvRepository;
	private SchoolService schoolService;
	private ExperienceService experienceService;
	private LanguageService languageService;
	private SkillService skillSerivce;

	@Autowired
	public CvManager(CvRepository cvRepository, SchoolService schoolService, ExperienceService experienceService,
			LanguageService languageService, SkillService skillSerivce) {
		super();
		this.cvRepository = cvRepository;
		this.schoolService = schoolService;
		this.experienceService = experienceService;
		this.languageService = languageService;
		this.skillSerivce = skillSerivce;
	}

	@Override
	public Result add(Cv cv) {
		this.cvRepository.save(cv);
		return new SuccessResult("Yeni cv eklendi.");
	}

	@Override
	public DataResult<CvDto> getByJobSeekerId(int jobSeekerId) {
		CvDto cvDto = new CvDto();
		int cvId;
		cvDto.cv = this.cvRepository.getByJobSeekerId(jobSeekerId);
		cvId = this.cvRepository.getByJobSeekerId(jobSeekerId).getCvId();
		cvDto.schools = this.schoolService.getByCvIdOrderByGraduationYearDesc(cvId).getData();
		cvDto.experiences = this.experienceService.getByCvIdOrderByQuitYearDesc(cvId).getData();
		cvDto.languages = this.languageService.getByCvId(cvId).getData();
		cvDto.skills = this.skillSerivce.getByCvId(cvId).getData();
		return new SuccessDataResult<CvDto>(cvDto, "Cv bilgileri listelendi.");
	}
	
}
