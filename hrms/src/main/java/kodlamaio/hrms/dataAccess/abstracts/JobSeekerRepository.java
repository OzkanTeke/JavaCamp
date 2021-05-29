package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer>{
	
	boolean existsJobSeekerByEmail(String email);
	
	boolean existsJobSeekerByNationalityId(String nationalityId);

}
