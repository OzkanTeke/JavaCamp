package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_seeker")
@Data
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "job_seeker_id")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User{
	
	@Column(name = "nationality_id")
	private String nationalityId;
	
	@Column(name = "birth_year")
	private int birthYear;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

}
