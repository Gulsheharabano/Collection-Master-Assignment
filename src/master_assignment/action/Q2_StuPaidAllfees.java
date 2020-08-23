package master_assignment.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;
import master_assignment.bean.Transaction;

public class Q2_StuPaidAllfees {

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
		sl3.add(new Student(34, "mohna", "9734587643", "gul123@gmail.com"));

		Academy.studentMap.put(3, sl3);

		List<Transaction> al1 = new ArrayList<>();
		al1.add(new Transaction(5000, 11, new Date(2019 - 04 - 13)));
		al1.add(new Transaction(10000, 12, new Date(2019 - 04 - 10)));
		al1.add(new Transaction(10000, 13, new Date(2019 - 04 - 14)));
		al1.add(new Transaction(5000, 11, new Date(2019 - 04 - 1)));
		al1.add(new Transaction(5000, 14, new Date(2019 - 04 - 13)));

		Academy.transactionMap.put(1, al1);

		List<Transaction> al2 = new ArrayList<>();
		al2.add(new Transaction(10000, 21, new Date(2019 - 04 - 13)));
		al2.add(new Transaction(5000, 22, new Date(2019 - 04 - 10)));
		al2.add(new Transaction(5000, 23, new Date(2019 - 04 - 10)));
		al2.add(new Transaction(10000, 24, new Date(2019 - 04 - 15)));
		al2.add(new Transaction(5000, 23, new Date(2019 - 05 - 20)));

		Academy.transactionMap.put(2, al2);

		List<Transaction> al3 = new ArrayList<>();
		al3.add(new Transaction(10000, 31, new Date(2019 - 04 - 20)));
		al3.add(new Transaction(15000, 32, new Date(2019 - 04 - 15)));
		al3.add(new Transaction(5000, 33, new Date(2019 - 04 - 11)));
		al3.add(new Transaction(15000, 34, new Date(2019 - 04 - 15)));

		Academy.transactionMap.put(3, al3);

		LinkedHashMap<Integer, ArrayList<Student>> paidstud=new LinkedHashMap<>();
		
		Set<Entry<Integer, List<Transaction>>> t = Academy.transactionMap.entrySet();
		Set<Entry<Integer, List<Student>>> s1 = Academy.studentMap.entrySet();
		ArrayList<Course> c1 = Academy.courseList;

		Iterator itr1 = s1.iterator();
		Iterator itr = t.iterator();
		Iterator itr2 = c1.iterator();

		while (itr.hasNext() && itr1.hasNext() && itr2.hasNext()) {
			Map.Entry m1 = (Entry) itr1.next();
			Integer cid = (Integer) m1.getKey();
			ArrayList<Student> stu = (ArrayList<Student>) m1.getValue();

			// LinkedHashMap<K, V> lhm=new LinkedHashMap<>();

			ArrayList<Student> allpaid = new ArrayList<>();

			Map.Entry m = (Entry) itr.next();
			Integer id1 = (Integer) m.getKey();
			ArrayList<Transaction> al = (ArrayList<Transaction>) m.getValue();

			Course m2 = (Course) itr2.next();

			int cfees = m2.courseFees;;
			int tsid=0;
			int sid = 0;
			String sname = null;
			
			for (int j = 0; j < stu.size(); j++) 
			{
				sname = stu.get(j).getstudent_name();
				sid = stu.get(j).getStudent_id();
				int tfees = 0;
				
				for (int i = 0; i < al.size(); i++) 
				{
					tsid = al.get(i).studId;
					tfees = al.get(i).paidfees;
					for (int s = i + 1; s < al.size(); s++) 
					{
						if (al.get(i).studId == al1.get(s).studId) 
						{
							tfees = tfees + al.get(s).paidfees;
							
						}

					}
					if (tsid == sid) 
					{
						if (cfees == tfees) 
						{
							allpaid.add(stu.get(j));
						}
					}

				}

				
			}
			paidstud.put(cid, allpaid);
			
		}
		System.out.println(paidstud);
	}

}
