package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.business.abstracts.JobSeekerMernisValidationService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerRepository;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerRepository jobSeekerRepository;
	private JobSeekerMernisValidationService jobSeekerMernisValidationService;
	private EmailActivationService emailActivationService;

	@Autowired
	public JobSeekerManager(JobSeekerRepository jobSeekerRepository,
			JobSeekerMernisValidationService jobSeekerMernisValidationService,
			EmailActivationService emailActivationService) {
		super();
		this.jobSeekerRepository = jobSeekerRepository;
		this.jobSeekerMernisValidationService = jobSeekerMernisValidationService;
		this.emailActivationService = emailActivationService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerRepository.findAll(), 
				"İş arayanlar listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker, String repeatPassword) {
		if (jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() || jobSeeker.getEmail().isEmpty() || jobSeeker.getNationalityId().isEmpty() || jobSeeker.getPassword().isEmpty()) {
			return new ErrorResult("Kayıt başarısız. Eksik alan mevcuttur!");
		}
		else if(!jobSeeker.getPassword().equals(repeatPassword)) {
			return new ErrorResult("Şifre tekrarı hatalı!");
		}
		else if(!emailCheck(jobSeeker.getEmail())) {
			return new ErrorResult("Geçersiz email adresi!");
		}
		else if(this.jobSeekerRepository.existsJobSeekerByEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Bu email ile kayıtlı kullanıcı mevcuttur!");
		}
		else if(this.jobSeekerRepository.existsJobSeekerByNationalityId(jobSeeker.getNationalityId())) {
			return new ErrorResult("Bu kimlik numarası ile kayıtlı kullanıcı mevcuttur!");
		}
		else if(!this.jobSeekerMernisValidationService.CheckIfRealPerson(jobSeeker)) {
			return new ErrorResult("Kayıt için gerçek kişi zorunluluğu vardır!");
		}
		else if(!this.emailActivationService.CheckIfActivated(jobSeeker.getEmail())) {
			return new ErrorResult("Email aktivasyonu tamamlanmadı!");
		}
		else {
			this.jobSeekerRepository.save(jobSeeker);
			return new SuccessResult("Yeni iş arayan eklendi.");
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
	
}
