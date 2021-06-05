package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillRepository;
import kodlamaio.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillRepository skillRepository;
	
	@Autowired
	public SkillManager(SkillRepository skillRepository) {
		super();
		this.skillRepository = skillRepository;
	}

	@Override
	public Result add(Skill skill) {
		this.skillRepository.save(skill);
		return new SuccessResult("Yeni yetenek eklendi");
	}

	@Override
	public DataResult<List<Skill>> getByCvId(int cvId) {
		return new SuccessDataResult<List<Skill>>(this.skillRepository.getByCv_CvId(cvId), "Yetenekler listelendi.");
	}

}
