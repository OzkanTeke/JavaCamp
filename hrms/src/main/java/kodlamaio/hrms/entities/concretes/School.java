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
@Table(name = "school")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int schoolId;
	
	@NotNull
	@NotBlank
	@Column(name = "school_name")
	private String schoolName;

	@NotNull
	@NotBlank
	@Column(name = "department")
	private String department;
	
	@NotNull
	@Column(name = "start_year")
	private int startYear;
	
	@Column(name = "graduation_year")
	private int graduationYear;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;
}
