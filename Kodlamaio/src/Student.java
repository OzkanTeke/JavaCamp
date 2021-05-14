
public class Student extends User {
	
public Student() {
		
	}
	
	public Student(int id, String userName, String eMail, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.eMail = eMail;
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

	public String geteMail() {
		return eMail;
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
		return false;
	}
	

}
