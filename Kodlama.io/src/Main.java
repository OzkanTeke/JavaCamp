
public class Main {

	public static void main(String[] args) {
		Instructor instructor = new Instructor(1, "Engin Demiroğ", "111111111", 10000);
		
		Student student = new Student();
		student.id = 4542;
		student.userName = "Özkan Teke";
		student.eMail = "oz57kan@gmail.com";
		student.password = "123456789";
		
		UserManager userManager = new UserManager();
		userManager.login(instructor);
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.addHomework(instructor);
		instructorManager.addCourse(instructor);
		
		userManager.logout();
		System.out.println("----------------------");
		
		userManager.login(student);
		
		StudentManager studentManager = new StudentManager();
		
		studentManager.submitComment(student);
		studentManager.joinCourse(student);
		
		userManager.logout();
	}

}
