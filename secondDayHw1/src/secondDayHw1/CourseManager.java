package secondDayHw1;

public class CourseManager {

	public void FiltCourse(Filter filter) {
		System.out.println("Kurslara filtre uygulandý.");
	}

	public void ListCourse(Course courses[]) {

		for (Course course : courses) {
			System.out.println(course.picture +" "+ course.detail +" "+ course.author +" "+ course.progress + "% tamamlandý.");
		}

	}

}