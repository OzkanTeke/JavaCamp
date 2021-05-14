
public class Instructor extends User {
	
	public double salary;

	public Instructor() {
		
	}
	
	public Instructor(int id, String userName, String password, double salary) {
		super();
		this.id = id;
		this.userName = userName;
		this.salary = salary;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getSalary() {
		return salary;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getIsAdmin() {
		return true;
	}

}
