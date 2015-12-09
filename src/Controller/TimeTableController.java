package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.Course;
import Model.Table;
import Model.Teacher;

public class TimeTableController {

	ArrayList<Model.Class> classes = new ArrayList<Model.Class>();
	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	ArrayList<Table> table = new ArrayList<Table>();
	
	public TimeTableController() {
		fillLocalValues();
		matchTeacherToCourse();
		matchClassToCourse();
		matchTable();
	}
		
	public String[] getClasses() {
		String[] s = new String[classes.size()];
		
		for (int i = 0; i < s.length; i++) {
			s[i] = classes.get(i).toString();
		}
		
		return s;
	}
	
	public String[] getTeachers() {
		String[] s = new String[teachers.size()];
		
		for (int i = 0; i < s.length; i++) {
			s[i] = teachers.get(i).toString();
		}
		
		return s;
	}
	
	public String[] getCourses() {
		String[] s = new String[teachers.size()];
		
		for (int i = 0; i < s.length; i++) {
			s[i] = teachers.get(i).toString();
		}
		
		return s;
	}
	
	public String[][] getTableForClasses(int index) {
		String[][] s = new String[9][5];
		int a=0,b=0;
		
		for (int i = 0; i < table.size(); i++) {
				
				if (table.get(i).getmClass()==classes.get(index)) {
					s[b][a] = table.get(i).toString2();
				}else {
					s[b][a] = "Empty";
				}
				
				if(b%8==0 && b!=0){
					a=1+a;
					b=-1;
				}
				b++;				
		}
		
		return s;
	}
		
	public void matchTable() {
		Random rd = new Random();
		int b;
		
		for (int i = 0; i < courses.size(); i++) {
						
			b = rd.nextInt(table.size()-3);
			
			try {
				switch (courses.get(i).getHour()) {
				case 2:
					table.get(b).setmCourse(courses.get(i));
					table.get(b).setmTeacher(courses.get(i).getTeacher());
					table.get(b).setmClass(courses.get(i).getClassroom());
					
					table.get(b+1).setmCourse(courses.get(i));
					table.get(b+1).setmTeacher(courses.get(i).getTeacher());
					table.get(b+1).setmClass(courses.get(i).getClassroom());
					break;
				case 3:
					table.get(b).setmCourse(courses.get(i));
					table.get(b).setmTeacher(courses.get(i).getTeacher());
					table.get(b).setmClass(courses.get(i).getClassroom());
					
					table.get(b+1).setmCourse(courses.get(i));
					table.get(b+1).setmTeacher(courses.get(i).getTeacher());
					table.get(b+1).setmClass(courses.get(i).getClassroom());

					table.get(b+2).setmCourse(courses.get(i));
					table.get(b+2).setmTeacher(courses.get(i).getTeacher());
					table.get(b+2).setmClass(courses.get(i).getClassroom());
					break;
				case 4:
					
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) { }
						
		}
		
		
	}
	
	public void matchTeacherToCourse() {
		Random tRandom = new Random();

		for (Course c : courses) {
			int tRand = tRandom.nextInt(teachers.size());
			
			c.setTeacher(teachers.get(tRand));
		}
	}
	
	public void matchClassToCourse() {
		Random tRandom = new Random();

		for (Course c : courses) {
			int tRand = tRandom.nextInt(classes.size());
			
			c.setClassroom(classes.get(tRand));
		}
	}
	
	
	public void fillLocalValues() {
		
		for (int i = 0; i < 12 ; i++) {
			classes.add(new Model.Class("DZ",101+i));
		}
		
		courses.add(new Course("COM",111,3));
		courses.add(new Course("COM",101,3));
		courses.add(new Course("MATH",101,3));
		courses.add(new Course("PHY",101,3));
		courses.add(new Course("ENGL",101,3));
		courses.add(new Course("ATA",101,2));
		courses.add(new Course("TDL",101,2));
		courses.add(new Course("COM",201,3));
		courses.add(new Course("COM",205,3));
		courses.add(new Course("COM",251,3));
		courses.add(new Course("COM",221,3));
		courses.add(new Course("MATH",201,3));
				
		teachers.add(new Teacher("Haluk","G�m��kaya"));
		teachers.add(new Teacher("H�revren","K�l��"));
		teachers.add(new Teacher("Md.Haidar","Sherif"));
		teachers.add(new Teacher("Yavuz","�nce"));
		teachers.add(new Teacher("G�khan","Akyol"));
		teachers.add(new Teacher("Necati Ercan","�zgencil"));
		teachers.add(new Teacher("Tae-Cheon","Yang"));
		
		table.add(new Table("Pazartesi",9));
		table.add(new Table("Pazartesi",10));
		table.add(new Table("Pazartesi",11));
		table.add(new Table("Pazartesi",12));
		table.add(new Table("Pazartesi",13));
		table.add(new Table("Pazartesi",14));
		table.add(new Table("Pazartesi",15));
		table.add(new Table("Pazartesi",16));
		table.add(new Table("Pazartesi",17));
		table.add(new Table("Sal�",9));
		table.add(new Table("Sal�",10));
		table.add(new Table("Sal�",11));
		table.add(new Table("Sal�",12));
		table.add(new Table("Sal�",13));
		table.add(new Table("Sal�",14));
		table.add(new Table("Sal�",15));
		table.add(new Table("Sal�",16));
		table.add(new Table("Sal�",17));
		table.add(new Table("�ar�amba",9));
		table.add(new Table("�ar�amba",10));
		table.add(new Table("�ar�amba",11));
		table.add(new Table("�ar�amba",12));
		table.add(new Table("�ar�amba",13));
		table.add(new Table("�ar�amba",14));
		table.add(new Table("�ar�amba",15));
		table.add(new Table("�ar�amba",16));
		table.add(new Table("�ar�amba",17));
		table.add(new Table("Per�embe",9));
		table.add(new Table("Per�embe",10));
		table.add(new Table("Per�embe",11));
		table.add(new Table("Per�embe",12));
		table.add(new Table("Per�embe",13));
		table.add(new Table("Per�embe",14));
		table.add(new Table("Per�embe",15));
		table.add(new Table("Per�embe",16));
		table.add(new Table("Per�embe",17));
		table.add(new Table("Cuma",9));
		table.add(new Table("Cuma",10));
		table.add(new Table("Cuma",11));
		table.add(new Table("Cuma",12));
		table.add(new Table("Cuma",13));
		table.add(new Table("Cuma",14));
		table.add(new Table("Cuma",15));
		table.add(new Table("Cuma",16));
		table.add(new Table("Cuma",17));
	}
}
