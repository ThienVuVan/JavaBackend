package fa.training.models;

import java.util.Comparator;

public class CourseTitleCompare implements Comparator<Course> {

	@Override
	public int compare(Course o1, Course o2) {
		return o1.getId().compareToIgnoreCase(o2.getId());
		// return -1 if o1 less than o2
		// return 0 if o1 equal to o2
		// return 1 if o1 greater than o2
	}

}

