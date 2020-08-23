package master_assignment.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;

public class TestAcademy {
	public static void main(String[] args) {
		
		Academy.courseList.add(new Course(1, "BCA", new Date(2019-9-29), "java c++", 36000, "3 year"));
		Academy.courseList.add(new Course(2, "Mca", new Date(2019-9-29), "java c++", 36000, "3 year"));
		Academy.courseList.add(new Course(3, "MBA", new Date(2019-9-29), "java c++", 36000, "3 year"));
		Academy.courseList.add(new Course(4, "Bsc", new Date(2019-9-29), "java c++", 36000, "3 year"));
		
		List<Student> al1=new ArrayList<>();
		al1.add(new Student(11, "gul", "9734587643", "gul123@gmail.com"));
		al1.add(new Student(12, "neah", "9734587643", "gul123@gmail.com"));
		al1.add(new Student(13, "rahul", "9734587643", "gul123@gmail.com"));
		al1.add(new Student(14, "raz", "9734587643", "gul123@gmail.com"));
		
		Academy.studentMap.put(1,al1 );
		
		List<Student> al2=new ArrayList<>();
		al2.add(new Student(21, "raja", "9734587643", "gul123@gmail.com"));
		al2.add(new Student(22, "rasika", "9734587643", "gul123@gmail.com"));
		al2.add(new Student(23, "rohan", "9734587643", "gul123@gmail.com"));
		
		Academy.studentMap.put(2,al2 );
		
		List<Student> al3=new ArrayList<>();
		al3.add(new Student(31, "raja", "9734587643", "gul123@gmail.com"));
		al3.add(new Student(32, "rasika", "9734587643", "gul123@gmail.com"));
		al3.add(new Student(33, "rohan", "9734587643", "gul123@gmail.com"));
		al3.add(new Student(34, "rasika", "9734587643", "gul123@gmail.com"));
		al3.add(new Student(35, "rohan", "9734587643", "gul123@gmail.com"));
		
		Academy.studentMap.put(3,al3 );
		
		int max=0;
		int course=0;
		
		Set<Entry<Integer, List<Student>>> s=Academy.studentMap.entrySet();
		
		Iterator itr=s.iterator();
		
		while(itr.hasNext()) {
			
			Map.Entry m1=(Entry) itr.next();
			Integer sid=(Integer) m1.getKey();
			ArrayList<Student> al=(ArrayList<Student>) m1.getValue();
			
			if(al.size()>max) {
				max=al.size();
				course=sid;
			}
		}
		
		System.out.println(course);
	}
}
