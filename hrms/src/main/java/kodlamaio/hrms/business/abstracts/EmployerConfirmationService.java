package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerConfirmationService {
	
	public boolean CheckIfApproved(Employer employer);

}
