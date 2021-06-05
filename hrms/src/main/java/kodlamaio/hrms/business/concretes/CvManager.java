package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvRepository;
import kodlamaio.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService{
	
	private CvRepository cvRepository;
	
	@Autowired
	public CvManager(CvRepository cvRepository) {
		super();
		this.cvRepository = cvRepository;
	}

	@Override
	public Result add(Cv cv) {
		this.cvRepository.save(cv);
		return new SuccessResult("Yeni cv eklendi.");
	}

	
}
