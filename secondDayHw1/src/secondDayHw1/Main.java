package secondDayHw1;

public class Main {

	public static void main(String[] args) {
		
		Filter filter1 = new Filter(1, "Kategori");
		
		Filter filter2 = new Filter();
		filter2.id = 2;
		filter2.name = "Eðitmen";
		
		Course course1 = new Course();
		course1.id = 1;
		course1.picture = "#giriþ kursu resmi#";
		course1.detail = "Programlamaya Giriþ için Temel Kurs";
		course1.author = "Engin Demiroð";
		course1.progress = 100;
		
		Course course2 = new Course(2, "#C# kursu resmi#", "Yazýlým Geliþtirici Yetiþtirme Kampý (C# + ANGULAR)", "Engin Demiroð", 28);
		
		Course course3 = new Course(3, "#Java kursu resmi#", "Yazýlým Geliþtirici Yetiþtirme Kampý (JAVA + REACT)", "Engin Demiroð", 32);

		Course[] courses = {course1, course2, course3};
		
		CourseManager courseManager = new CourseManager();
		courseManager.FiltCourse(filter1);
		
		courseManager.ListCourse(courses);
		
	}

}
