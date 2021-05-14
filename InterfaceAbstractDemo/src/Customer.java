public class Customer {
	int id;
	String firstname;
	String lastname;
	int dateOfBirth;
	String nationalityId;

	public Customer() {

	}

	public Customer(int id, String firstname, String lastname, int dateOfBirth, String nationalityId) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationalityId;
	}

	public void setNationality(String nationalityId) {
		this.nationalityId = nationalityId;
	}

}
