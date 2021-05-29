package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobRepository;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{
	
	private JobRepository jobRepository;

	@Autowired
	public JobManager(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobRepository.findAll(), "Meslekler listelendi.");
	}

	@Override
	public Result add(Job job) {
		if (this.jobRepository.existsJobByPosition(job.getPosition())) {
			return new ErrorResult("This job position already exists.");
		}
		this.jobRepository.save(job);
		return new SuccessResult("Successfully added a new job position.");
	}

}
