package master_assignment.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;

/*
 * show poor performing students (marks <40%) across all tests for a course id.
 */
public class Q3_Poor_Performing_Stud {

	public static void main(String[] args) {
		
		Academy.courseList.add(new Course(1, "BCA", new Date(2019-4-29), "java c++", 36000, "3 year"));
		Academy.courseList.add(new Course(2, "Mca", new Date(2019-4-29), "java c++", 36000, "3 year"));
		Academy.courseList.add(new Course(3, "MBA", new Date(2019-4-29), "java c++", 36000, "3 year"));
		Academy.courseList.add(new Course(4, "Bsc", new Date(2019-4-29), "java c++", 36000, "3 year"));
		
		List<Student> sl1=new ArrayList<>();
		sl1.add(new Student(11, "gul", "9734587643", "gul123@gmail.com"));
		sl1.add(new Student(12, "neah", "9734587643", "gul123@gmail.com"));
		sl1.add(new Student(13, "rahul", "9734587643", "gul123@gmail.com"));
		sl1.add(new Student(14, "raz", "9734587643", "gul123@gmail.com"));
		
		Academy.studentMap.put(1,sl1 );
		
		List<Student> sl2=new ArrayList<>();
		sl2.add(new Student(21, "raja", "9734587643", "gul123@gmail.com"));
		sl2.add(new Student(22, "rasika", "9734587643", "gul123@gmail.com"));
		sl2.add(new Student(23, "rohan", "9734587643", "gul123@gmail.com"));
		sl2.add(new Student(24, "rakesh", "9734587643", "gul123@gmail.com"));
		Academy.studentMap.put(2,sl2 );
		
		List<Student> sl3=new ArrayList<>();
		sl3.add(new Student(31, "raja", "9734587643", "gul123@gmail.com"));
		sl3.add(new Student(32, "raju", "9734587643", "gul123@gmail.com"));
		sl3.add(new Student(33, "rohan", "9734587643", "gul123@gmail.com"));
		sl3.add(new Student(34, "rasika", "9734587643", "gul123@gmail.com"));
		
		
		Academy.studentMap.put(3,sl3 );
		
		List<TestResult> al1=new ArrayList<>();
		al1.add(new TestResult(new Date(2019-5-20) , 101, 11, 39, 100));
		al1.add(new TestResult(new Date(2019-5-20) , 102, 12, 60, 100));
		al1.add(new TestResult(new Date(2019-5-20) , 103, 13, 70, 100));
		al1.add(new TestResult(new Date(2019-5-20) , 104, 14, 40, 100));
		
		
		Academy.test_map.put(1, al1);
		List<TestResult> al2=new ArrayList<>();
		al2.add(new TestResult(new Date(2019-6-5) , 201, 21, 57, 100));
		al2.add(new TestResult(new Date(2019-6-5) , 202, 22, 35, 100));
		al2.add(new TestResult(new Date(2019-6-5) , 203, 23, 70, 100));
		al2.add(new TestResult(new Date(2019-6-5) , 204, 24, 40, 100));
		
		
		Academy.test_map.put(2, al2);
		
		List<TestResult> al3=new ArrayList<>();
		al3.add(new TestResult(new Date(2019-5-20) , 101, 31, 40, 100));
		al3.add(new TestResult(new Date(2019-5-20) , 102, 32, 39, 100));
		al3.add(new TestResult(new Date(2019-5-20) , 103, 33, 70, 100));
		al3.add(new TestResult(new Date(2019-5-20) , 104, 34, 40, 100));
		
		Academy.test_map.put(3, al3);
		
		HashMap<Integer, HashMap<Integer, String>> ans=new HashMap<>();
		
		Set<Entry<Integer, List<TestResult>>> t=Academy.test_map.entrySet();
		Set<Entry<Integer, List<Student>>> s1=Academy.studentMap.entrySet();
		
		Iterator itr1 = s1.iterator();
		Iterator itr = t.iterator();

		while (itr.hasNext() && itr1.hasNext()) 
		{
			Map.Entry m1 = (Entry) itr1.next();
			Integer cid = (Integer) m1.getKey();
			ArrayList<Student> stu = (ArrayList<Student>) m1.getValue();

			HashMap<Integer, String> poorStud = new HashMap<>();

			Map.Entry m = (Entry) itr.next();
			Integer id1 = (Integer) m.getKey();
			ArrayList<TestResult> al = (ArrayList<TestResult>) m.getValue();
			String sname = null;
			int sid1 = 0;
			if (cid == id1) {
				for (int j = 0; j < stu.size(); j++) {
					sname = stu.get(j).getstudent_name();
					sid1 = stu.get(j).getStudent_id();

					for (int i = 0; i < al.size(); i++) {
						int sid = al.get(i).studentId;
						int mark = al.get(i).marks;

						if (mark <= 40 && sid==sid1) {

							poorStud.put(sid, sname);
						}
					}
				}
			}
			//System.out.println(id1);
			//System.out.println(poorStud);
			ans.put(id1, poorStud);
		}
		System.out.println("");
		System.out.println(ans);
	}

}
