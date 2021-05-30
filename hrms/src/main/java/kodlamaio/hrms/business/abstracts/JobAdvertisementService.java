package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAllActiveJobAdverts();
	
	DataResult<List<JobAdvertisement>> findAllOrderByReleaseDateDesc();
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployerId(int id);
	
	Result deactivate(int id);

}
