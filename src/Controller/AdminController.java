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
		table.add(new TableSlot("Salý",9));
		table.add(new TableSlot("Salý",10));
		table.add(new TableSlot("Salý",11));
		table.add(new TableSlot("Salý",12));
		table.add(new TableSlot("Salý",13));
		table.add(new TableSlot("Salý",14));
		table.add(new TableSlot("Salý",15));
		table.add(new TableSlot("Salý",16));
		table.add(new TableSlot("Salý",17));
		table.add(new TableSlot("Çarþamba",9));
		table.add(new TableSlot("Çarþamba",10));
		table.add(new TableSlot("Çarþamba",11));
		table.add(new TableSlot("Çarþamba",12));
		table.add(new TableSlot("Çarþamba",13));
		table.add(new TableSlot("Çarþamba",14));
		table.add(new TableSlot("Çarþamba",15));
		table.add(new TableSlot("Çarþamba",16));
		table.add(new TableSlot("Çarþamba",17));
		table.add(new TableSlot("Perþembe",9));
		table.add(new TableSlot("Perþembe",10));
		table.add(new TableSlot("Perþembe",11));
		table.add(new TableSlot("Perþembe",12));
		table.add(new TableSlot("Perþembe",13));
		table.add(new TableSlot("Perþembe",14));
		table.add(new TableSlot("Perþembe",15));
		table.add(new TableSlot("Perþembe",16));
		table.add(new TableSlot("Perþembe",17));
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
