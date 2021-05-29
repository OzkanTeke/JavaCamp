package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerMernisValidationService;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerMernisValidationManager implements JobSeekerMernisValidationService{

	@Override
	public boolean CheckIfRealPerson(JobSeeker jobSeeker) {
		if(jobSeeker.getNationalityId().length() == 11) { // fake validity check
			return true;
		}
		return false;
	}
}
