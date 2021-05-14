package secondDayHw1;

public class Course {
	
	public Course() {  //constructor
	}
	
	public Course(int id, String picture, String detail, String author, int progress) {
		this();     
		this.id = id;
		this.picture = picture;
		this.detail = detail;
		this.author = author;
		this.progress = progress;
	}
	
	int id;
	String picture;
	String detail;
	String author;
	int progress;
	
}
