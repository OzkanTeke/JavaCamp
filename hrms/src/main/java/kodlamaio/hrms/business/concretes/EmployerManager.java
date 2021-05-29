package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.EmployerConfirmationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerRepository;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerRepository employerRepository;
	private EmailActivationService emailActivationService;
	private EmployerConfirmationService employerConfirmationService;

	@Autowired
	public EmployerManager(EmployerRepository employerRepository, EmailActivationService emailActivationService, EmployerConfirmationService employerConfirmationService) {
		super();
		this.employerRepository = employerRepository;
		this.emailActivationService = emailActivationService;
		this.employerConfirmationService = employerConfirmationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerRepository.findAll(), "İşverenler listelendi.");
	}

	@Override
	public Result add(Employer employer, String repeatPassword) {
		
		if (employer.getCompanyName().isEmpty() || employer.getWebsite().isEmpty() || employer.getEmail().isEmpty() || employer.getPhoneNumber().isEmpty() || employer.getPassword().isEmpty()) {
			return new ErrorResult("Kayıt başarısız. Eksik alan mevcuttur!");
		}
		else if(!employer.getPassword().equals(repeatPassword)) {
			return new ErrorResult("Şifre tekrarı hatalı!");
		}
		else if(!emailCheck(employer.getEmail())) {
			return new ErrorResult("Geçersiz email adresi!");
		}
		else if(this.employerRepository.existsEmployerByEmail(employer.getEmail())) {
			return new ErrorResult("Bu email ile kayıtlı kullanıcı mevcuttur!");
		}
		else if(!emailDomainCheck(employer.getWebsite(), employer.getEmail())) {
			return new ErrorResult("Email adresi websitesi ile aynı domaine sahip olmalıdır!");
		}
		else if(!this.emailActivationService.CheckIfActivated(employer.getEmail())) {
			return new ErrorResult("Email aktivasyonu tamamlanmadı!");
		}
		else if(!this.employerConfirmationService.CheckIfApproved(employer)) {
			return new ErrorResult("Sistem tarafından onaylanmadı!");
		}
		else {
			this.employerRepository.save(employer);
			return new SuccessResult("Yeni işveren eklendi.");
		}
	}
	
	private boolean emailCheck(String email) {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()) {
            return true;
        }else {
            return false;
        }
	}

	private boolean emailDomainCheck(String website, String email) {
		String REGEX = "@";
		String INPUT = email;
		Pattern pattern = Pattern.compile(REGEX);

		String[] result = pattern.split(INPUT);
		String domain = result[1];
		if(website.contains(domain)) {
			return true;
		}
		return false;
	}
}
