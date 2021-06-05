package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Cv;

public interface CvRepository extends JpaRepository<Cv, Integer>{
	
	Cv getByJobSeekerId(int id);

}
