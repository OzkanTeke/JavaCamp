package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{

	List<Language> getByCv_CvId(int cvId);

}
