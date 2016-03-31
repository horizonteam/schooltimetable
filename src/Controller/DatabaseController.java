package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Course;
import Model.Teacher;

public class DatabaseController {

	private Connection baglan()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e)
        {
            System.out.print("hata : "+e);
        }
 
        try
        {
            Connection con = null;
            con=DriverManager.getConnection("jdbc:sqlite:C:/Users/Computer/git/schooltimetable/DB/timetable.sqlite"); // varsa baðlanýyor yoksa üzerine ekliyor
            return con;
        }
        catch(Exception e)
        {
            System.err.print("hata :"+e);
        }
 
        return null;
    }
	
	public ArrayList<Teacher> getTeacher()
    {
		ArrayList<Teacher> list = new ArrayList<>();
        try {
            Statement st = null;
            ResultSet rs = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
		    st.execute("select * from Teacher");
		 
		    rs=st.getResultSet();
		     
			while(rs.next()){
				list.add(new Teacher(rs.getString("name"), rs.getString("surname")));
				//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("surname")); 
			}
			rs.close();
			st.close();
			con.close();
		 
			return list;
		        } catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		        }
		return null;
	}
	
	public ArrayList<Model.Class> getClasses()
    {
		ArrayList<Model.Class> list = new ArrayList<>();
        try {
            Statement st = null;
            ResultSet rs = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
		    st.execute("select * from Class");
		 
		    rs=st.getResultSet();
		    
			while(rs.next()){
				list.add(new Model.Class(rs.getString("block_code"), rs.getInt("number")));
				//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("surname")); 
			}
			rs.close();
			st.close();
			con.close();
		 
			return list;
		        } catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		        }
		return null;
	}

	public ArrayList<Course> getCourse()
    {
		ArrayList<Course> list = new ArrayList<>();
        try {
            Statement st = null;
            ResultSet rs = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
		    st.execute("select * from Course");
		 
		    rs=st.getResultSet();
		    
			while(rs.next()){
				list.add(new Course(rs.getString("department"), rs.getInt("number"), rs.getInt("hour")));
				//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("surname")); 
			}
			rs.close();
			st.close();
			con.close();
		 
			return list;
		        } catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		        }
		return null;
	}
	
	public void insertTeacher(Teacher item)
    {
        try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
            st.execute("insert into Teacher values(null,'"+item.getName()+"','"+item.getLastname()+"')");
			
        	st.close();
			con.close();
		 
		  	} catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		    }
	}
	
	public void insertCourse(Course item)
    {
		try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
            st.execute("insert into Course values(null,'"+item.getDepartment_code()+"','"
            		+item.getCourseNumber()+"','"+item.getHour()+"')");
			
        	st.close();
			con.close();
		 
		    } catch (SQLException ex) {
		           System.out.print("hata : "+ex);
		    }
	}
	
	public void insertClass(Model.Class item)
    {
		try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
            st.execute("insert into Class values(null,'"+item.getBlock_code()+"','"+item.getClassNumber()+"')");
			
        	st.close();
			con.close();
		 
		    } catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		    }
	}
	
	public void removeTeacher(Teacher item)
    {
        try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
            st.execute("DELETE FROM Teacher WHERE name='"+item.getName()+"' and surname='"+item.getLastname()+"' ;");
			
        	st.close();
			con.close();
		 
		  	} catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		    }
	}
	
	public void removeClass(Model.Class item)
    {
        try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
            st.execute("DELETE FROM Class WHERE block_code='"+item.getBlock_code()+"' and number='"+item.getClassNumber()+"' ;");
			
        	st.close();
			con.close();
		 
		  	} catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		    }
	}
	
	public void removeCourse(Course item)
    {
        try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
           st.execute("DELETE FROM Course WHERE department='"+item.getDepartment_code()+"' and number='"+item.getCourseNumber()+"' ;");
			
        	st.close();
			con.close();
		 
		  	} catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		    }
	}
	
	public static void addRestriction(List<String> days) {
		//not implemented
	}
	
}
