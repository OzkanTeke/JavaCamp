package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementRepository;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementRepository jobAdvertisementRepository;
	
	@Autowired
	public JobAdvertisementManager(
			kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementRepository jobAdvertisementRepository) {
		super();
		this.jobAdvertisementRepository = jobAdvertisementRepository;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getJob() == null || jobAdvertisement.getDescription().isEmpty() ||
				jobAdvertisement.getCity() == null || jobAdvertisement.getEmployer() == null ||
				jobAdvertisement.getPositionTotal() == 0 || jobAdvertisement.getReleaseDate() == null
				|| jobAdvertisement.getExpiryDate() == null){
			return new ErrorResult("Tüm zorunlu alanlar girilmelidir.");
		}
		jobAdvertisement.setActive(true);
		this.jobAdvertisementRepository.save(jobAdvertisement);
		return new SuccessResult("Yeni iş ilanı eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdverts() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementRepository.getAllActiveJobAdverts(), "Aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllOrderByReleaseDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementRepository.findAllOrderByReleaseDateDesc(), "Aktif iş ilanları tarihe göre listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementRepository.findByIsActiveTrueAndEmployerId(id), "İşverenin aktif iş ilanları listelendi.");
	}

	@Override
	public Result deactivate(int id) {
		if(this.jobAdvertisementRepository.findById(id) == null) {
			return new ErrorResult("Bu iş ilanı bulunamamaktadır!");
		}else if(this.jobAdvertisementRepository.findById(id).isActive() == false) {
			return new ErrorResult("Bu iş ilanı zaten kapalıdır!");
		}
		this.jobAdvertisementRepository.findById(id).setActive(false);
		return new SuccessResult("İş ilanı kapatılmıştır.");
	}

}
