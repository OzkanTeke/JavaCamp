package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
	
	List<Experience> getByCv_CvIdOrderByQuitYearDesc(int cvId);

}
