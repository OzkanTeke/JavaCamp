package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "experience")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private int experienceId;
	
	@NotNull
	@NotBlank
	@Column(name = "employer_name")
	private String employerName;
	
	@NotNull
	@NotBlank
	@Column(name = "position")
	private String position;
	
	@NotNull
	@Column(name = "start_year")
	private int startYear;
	
	@Column(name = "quit_year")
	private int quitYear;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

}
