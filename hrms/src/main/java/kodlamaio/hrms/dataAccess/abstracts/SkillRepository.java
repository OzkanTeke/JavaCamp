package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{
	
	List<Skill> getByCv_CvId(int cvId);

}
