package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("From JobAdvertisement where isActive = true")
	List<JobAdvertisement> getAllActiveJobAdverts();
	
	@Query("From JobAdvertisement where isActive = true Order By releaseDate Desc")
	List<JobAdvertisement> findAllOrderByReleaseDateDesc();
	
	//@Query("FromJobAdvertisement where isActive = true and employer.employer_id= :id")
	List<JobAdvertisement> findByIsActiveTrueAndEmployerId(int id);
	
	JobAdvertisement findById(int id);

}
