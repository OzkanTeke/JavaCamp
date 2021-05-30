package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAllActiveJobAdverts")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdverts(){
		return this.jobAdvertisementService.getAllActiveJobAdverts();
	}
	
	@GetMapping("/findAllOrderByReleaseDateDesc")
	public DataResult<List<JobAdvertisement>> findAllOrderByReleaseDateDesc(){
		return this.jobAdvertisementService.findAllOrderByReleaseDateDesc();
	}
	
	@GetMapping("/getAllActiveJobAdvertsByEmployer")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployerId(@RequestParam int id){
		return this.jobAdvertisementService.findByIsActiveTrueAndEmployerId(id);
	}
	
	@GetMapping("/deactivate")
	public Result deactivate(@RequestParam int id) {
		return this.jobAdvertisementService.deactivate(id);
	}

}
