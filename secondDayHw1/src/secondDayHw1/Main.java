package secondDayHw1;

public class Main {

	public static void main(String[] args) {
		
		Filter filter1 = new Filter(1, "Kategori");
		
		Filter filter2 = new Filter();
		filter2.id = 2;
		filter2.name = "E�itmen";
		
		Course course1 = new Course();
		course1.id = 1;
		course1.picture = "#giri� kursu resmi#";
		course1.detail = "Programlamaya Giri� i�in Temel Kurs";
		course1.author = "Engin Demiro�";
		course1.progress = 100;
		
		Course course2 = new Course(2, "#C# kursu resmi#", "Yaz�l�m Geli�tirici Yeti�tirme Kamp� (C# + ANGULAR)", "Engin Demiro�", 28);
		
		Course course3 = new Course(3, "#Java kursu resmi#", "Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA + REACT)", "Engin Demiro�", 32);

		Course[] courses = {course1, course2, course3};
		
		CourseManager courseManager = new CourseManager();
		courseManager.FiltCourse(filter1);
		
		courseManager.ListCourse(courses);
		
	}

}
