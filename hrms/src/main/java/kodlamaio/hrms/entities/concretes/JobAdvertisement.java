package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advert_id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Job job;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "position_total")
	private int positionTotal;
	
	@Column(name = "release_date")
	private LocalDate releaseDate;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

}
