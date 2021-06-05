package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Skill;

public class CvDto {
	
	public Cv cv;
	public List<School> schools;
	public List<Experience> experiences;
	public List<Language> languages;
	public List<Skill> skills;

}
