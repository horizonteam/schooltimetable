package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.Course;
import Model.TableSlot;
import Model.Teacher;

public class AdminController {

	ArrayList<Model.Class> classes = new ArrayList<Model.Class>();
	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	ArrayList<TableSlot> table = new ArrayList<TableSlot>();
	DatabaseController db;
	
	public AdminController() {
		db = new DatabaseController();
		GetTableSlot();
		
	}
		
	public String[] getClassNames() {
		classes = db.getClasses();
		String[] s = new String[classes.size()];
		
		for (int i = 0; i < s.length; i++) {
			s[i] = classes.get(i).toString();
		}
		
		return s;
	}
	
	public String[] getTeacherNames() {
		teachers = db.getTeacher();
		String[] s = new String[teachers.size()];
		
		for (int i = 0; i < s.length; i++) {
			s[i] = teachers.get(i).toString();
		}
		
		return s;
	}
	
	public String[] getCourseNames() {
		courses = db.getCourse();
		String[] s = new String[courses.size()];
		
		for (int i = 0; i < s.length; i++) {
			s[i] = courses.get(i).toString();
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
					s[b][a] = "-";
				}
				
				if(b%8==0 && b!=0){
					a=1+a;
					b=-1;
				}
				b++;				
		}
		
		return s;
	}
	
	public String[][] getTableForTeacher(int index) {
		String[][] s = new String[9][5];
		int a=0,b=0;
		
		for (int i = 0; i < table.size(); i++) {
				
				if (table.get(i).getmTeacher()==teachers.get(index)) {
					s[b][a] = table.get(i).toString2();
				}else {
					s[b][a] = "-";
				}
				
				if(b%8==0 && b!=0){
					a=1+a;
					b=-1;
				}
				b++;				
		}
		
		return s;
	}

	public String[][] getTableForCourse(int index) {
		String[][] s = new String[9][5];
		int a=0,b=0;
		
		for (int i = 0; i < table.size(); i++) {
				
				if (table.get(i).getmCourse()==courses.get(index)) {
					s[b][a] = table.get(i).toString2();
				}else {
					s[b][a] = "-";
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
		matchTeacherToCourse();
		matchClassToCourse();
		
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
	
	
	public void GetTableSlot() {
		
		
		
		table.add(new TableSlot("Pazartesi",9));
		table.add(new TableSlot("Pazartesi",10));
		table.add(new TableSlot("Pazartesi",11));
		table.add(new TableSlot("Pazartesi",12));
		table.add(new TableSlot("Pazartesi",13));
		table.add(new TableSlot("Pazartesi",14));
		table.add(new TableSlot("Pazartesi",15));
		table.add(new TableSlot("Pazartesi",16));
		table.add(new TableSlot("Pazartesi",17));
		table.add(new TableSlot("Sal�",9));
		table.add(new TableSlot("Sal�",10));
		table.add(new TableSlot("Sal�",11));
		table.add(new TableSlot("Sal�",12));
		table.add(new TableSlot("Sal�",13));
		table.add(new TableSlot("Sal�",14));
		table.add(new TableSlot("Sal�",15));
		table.add(new TableSlot("Sal�",16));
		table.add(new TableSlot("Sal�",17));
		table.add(new TableSlot("�ar�amba",9));
		table.add(new TableSlot("�ar�amba",10));
		table.add(new TableSlot("�ar�amba",11));
		table.add(new TableSlot("�ar�amba",12));
		table.add(new TableSlot("�ar�amba",13));
		table.add(new TableSlot("�ar�amba",14));
		table.add(new TableSlot("�ar�amba",15));
		table.add(new TableSlot("�ar�amba",16));
		table.add(new TableSlot("�ar�amba",17));
		table.add(new TableSlot("Per�embe",9));
		table.add(new TableSlot("Per�embe",10));
		table.add(new TableSlot("Per�embe",11));
		table.add(new TableSlot("Per�embe",12));
		table.add(new TableSlot("Per�embe",13));
		table.add(new TableSlot("Per�embe",14));
		table.add(new TableSlot("Per�embe",15));
		table.add(new TableSlot("Per�embe",16));
		table.add(new TableSlot("Per�embe",17));
		table.add(new TableSlot("Cuma",9));
		table.add(new TableSlot("Cuma",10));
		table.add(new TableSlot("Cuma",11));
		table.add(new TableSlot("Cuma",12));
		table.add(new TableSlot("Cuma",13));
		table.add(new TableSlot("Cuma",14));
		table.add(new TableSlot("Cuma",15));
		table.add(new TableSlot("Cuma",16));
		table.add(new TableSlot("Cuma",17));
	}

	
}
