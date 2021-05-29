package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;

@Service
public class EmailActivationManager implements EmailActivationService{

	@Override
	public boolean CheckIfActivated(String email) {
		return true; // fake email activation
	}
}
