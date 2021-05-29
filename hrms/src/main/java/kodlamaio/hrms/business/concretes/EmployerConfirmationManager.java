package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerConfirmationService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerConfirmationManager implements EmployerConfirmationService{

	@Override
	public boolean CheckIfApproved(Employer employer) {
		return true; // fake confirmation
	}

}
