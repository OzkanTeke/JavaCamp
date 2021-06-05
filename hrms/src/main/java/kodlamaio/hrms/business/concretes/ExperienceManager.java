package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceRepository;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{
	
	private ExperienceRepository experienceRepository;

	@Autowired
	public ExperienceManager(ExperienceRepository experienceRepository) {
		super();
		this.experienceRepository = experienceRepository;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceRepository.save(experience);
		return new SuccessResult("Yeni tecrübe eklendi.");
	}

	@Override
	public DataResult<List<Experience>> getByCvIdOrderByQuitYearDesc(int cvId) {
		return new SuccessDataResult<List<Experience>>
		(this.experienceRepository.getByCv_CvIdOrderByQuitYearDesc(cvId), "Tecrübeler listelendi.");
	}

}
