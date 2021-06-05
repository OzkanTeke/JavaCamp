package kodlamaio.hrms.entities.concretes;

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
@Table(name = "language")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int languageId;
	
	@Column(name = "name")
	private String langueageName;
	
	@Column(name = "level")
	private int languageLevel;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

}
