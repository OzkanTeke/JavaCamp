package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cv")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;
	
	@OneToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@Column(name = "info")
	private String info;
	
	@Column(name = "github_address")
	private String githubAddress;
	
	@Column(name = "linkedin_address")
	private String linkedinAddress;
	
	@Column(name = "photo_adress")
	private String photoAdress;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<School> schools;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Language> languages;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Skill> skills;
	
}
