package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolRepository;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolRepository schoolRepository;
	
	@Autowired
	public SchoolManager(SchoolRepository schoolRepository) {
		super();
		this.schoolRepository = schoolRepository;
	}

	@Override
	public Result add(School school) {
		this.schoolRepository.save(school);
		return new SuccessResult("Yeni okul eklendi.");
	}

	@Override
	public DataResult<List<School>> getByCvIdOrderByGraduationYearDesc(int cvId) {
		return new SuccessDataResult<List<School>>
		(this.schoolRepository.getByCv_CvIdOrderByGraduationYearDesc(cvId), "Okullar listelendi.");
	}

}
