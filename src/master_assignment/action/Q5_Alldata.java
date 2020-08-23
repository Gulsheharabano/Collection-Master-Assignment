package master_assignment.action;

import java.util.ArrayList;
import java.util.Collections;
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
import master_assignment.bean.Transaction;

/*
 * Show one table which has course name , course start date and total students, 
 * total revenue till date, total left fees, total projected revenue, percentage collection till date
 */
public class Q5_Alldata {

	public static void main(String[] args) {
		Academy.courseList.add(new Course(1, "BCA", new Date(2019 - 4 - 01), "java c++", 10000, "3 year"));
		Academy.courseList.add(new Course(2, "Mca", new Date(2019 - 4 - 01), "java c++", 10000, "3 year"));
		Academy.courseList.add(new Course(3, "MBA", new Date(2019 - 4 - 01), "java c++", 15000, "3 year"));
		Academy.courseList.add(new Course(4, "Bsc", new Date(2019 - 4 - 01), "java c++", 10000, "3 year"));

		List<Student> sl1 = new ArrayList<>();
		sl1.add(new Student(11, "gul", "9734587643", "gul123@gmail.com"));
		sl1.add(new Student(12, "sneha", "9734587643", "gul123@gmail.com"));
		sl1.add(new Student(13, "raja", "9734587643", "gul123@gmail.com"));
		sl1.add(new Student(14, "neha", "9734587643", "gul123@gmail.com"));

		Academy.studentMap.put(1, sl1);

		List<Student> sl2 = new ArrayList<>();
		sl2.add(new Student(21, "shilpa", "9734587643", "gul123@gmail.com"));
		sl2.add(new Student(22, "rasika", "9734587643", "gul123@gmail.com"));
		sl2.add(new Student(23, "lata", "9734587643", "gul123@gmail.com"));
		sl2.add(new Student(24, "salman", "9734587643", "gul123@gmail.com"));
		Academy.studentMap.put(2, sl2);

		List<Student> sl3 = new ArrayList<>();
		sl3.add(new Student(31, "kumar", "9734587643", "gul123@gmail.com"));
		sl3.add(new Student(32, "raju", "9734587643", "gul123@gmail.com"));
		sl3.add(new Student(33, "mohammad", "9734587643", "gul123@gmail.com"));
		sl3.add(new Student(34, "rasika", "9734587643", "gul123@gmail.com"));

		Academy.studentMap.put(3, sl3);

		List<Transaction> al1 = new ArrayList<>();
		al1.add(new Transaction(5000, 11, new Date(2019 - 04 - 13)));
		al1.add(new Transaction(10000, 12, new Date(2019 - 04 - 10)));
		al1.add(new Transaction(7000, 13, new Date(2019 - 04 - 14)));
		al1.add(new Transaction(5000, 11, new Date(2019 - 04 - 1)));
		al1.add(new Transaction(5000, 14, new Date(2019 - 04 - 13)));

		Academy.transactionMap.put(1, al1);

		List<Transaction> al2 = new ArrayList<>();
		al2.add(new Transaction(10000, 21, new Date(2019 - 04 - 13)));
		al2.add(new Transaction(5000, 22, new Date(2019 - 04 - 10)));
		al2.add(new Transaction(5000, 23, new Date(2019 - 04 - 10)));
		al2.add(new Transaction(5000, 24, new Date(2019 - 04 - 15)));
		al2.add(new Transaction(5000, 23, new Date(2019 - 05 - 20)));

		Academy.transactionMap.put(2, al2);

		List<Transaction> al3 = new ArrayList<>();
		al3.add(new Transaction(10000, 31, new Date(2019 - 04 - 20)));
		al3.add(new Transaction(15000, 32, new Date(2019 - 04 - 15)));
		al3.add(new Transaction(5000, 33, new Date(2019 - 04 - 11)));
		al3.add(new Transaction(15000, 34, new Date(2019 - 04 - 15)));

		Academy.transactionMap.put(3, al3);

		HashMap<Integer, HashMap<ArrayList<Student>, ArrayList<TestResult>>> ans = new HashMap<>();

		Set<Entry<Integer, List<Transaction>>> t = Academy.transactionMap.entrySet();
		Set<Entry<Integer, List<Student>>> s1 = Academy.studentMap.entrySet();
		ArrayList<Course> c1 = Academy.courseList;

		Iterator itr1 = s1.iterator();
		Iterator itr = t.iterator();
		Iterator itr2 = c1.iterator();

		while (itr.hasNext() && itr1.hasNext() && itr2.hasNext()) 
		{
			Map.Entry m1 = (Entry) itr1.next();
			Integer cid = (Integer) m1.getKey();
			ArrayList<Student> stu = (ArrayList<Student>) m1.getValue();

			Map.Entry m = (Entry) itr.next();
			Integer id1 = (Integer) m.getKey();
			ArrayList<Transaction> al = (ArrayList<Transaction>) m.getValue();

			Course m2 = (Course) itr2.next();

			float totalprojectedrevenu = 0;
			float totalrevenu=0;
			float totalleftfees =0;
			float percentageCollection = 0;
			int stdcnt = 0;
			int cfees = 0;
			String cname=null;
			Date cdate = null;
			
			if (cid == id1) {
				for (int k = 0; k < c1.size(); k++) {
					stdcnt = 0;
					totalprojectedrevenu = 0;
					cname = m2.course_name;
					cdate = m2.startDate;
					cfees = m2.courseFees;
					
					for (int j = 0; j < stu.size(); j++) {
						stdcnt++;
						
					}
				}
				for (int i = 0; i < al.size(); i++) {
					int paidfees = al.get(i).paidfees;
					totalprojectedrevenu = totalprojectedrevenu + paidfees;
					totalrevenu=stdcnt*cfees;
					totalleftfees=totalrevenu-totalprojectedrevenu;
					percentageCollection=(totalprojectedrevenu/totalrevenu)*100;
				}
				
			}
			System.out.println("course name : "+cname);
			System.out.println("Course start date : "+cdate);
			System.out.println("total student : "+stdcnt);
			System.out.println("total revenue : "+totalrevenu);
			System.out.println("total left fees : "+ totalleftfees);
			System.out.println("total projected revenue : "+totalprojectedrevenu);
			System.out.println("Percentage of Collection : "+percentageCollection);
			System.out.println("------------------------------------------------");
		}

	}

}
