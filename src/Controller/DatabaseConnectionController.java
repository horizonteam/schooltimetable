package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Model.Course;
import Model.Teacher;

public class DatabaseConnectionController {

	private static Connection baglan()
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
            con=DriverManager.getConnection("jdbc:sqlite:timetable.db"); // varsa baðlanýyor yoksa üzerine ekliyor
            return con;
        }
        catch(Exception e)
        {
            System.err.print("hata :"+e);
        }
 
        return null;
    }
	
	public static void getTable(String tableName)
    {
        try {
            Statement st = null;
            ResultSet rs = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
		    st.execute("select * from "+tableName);
		 
		    rs=st.getResultSet();
		     
		while(rs.next()){
		 
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+
					" "+rs.getString("surname")); 
		}
			rs.close();
			st.close();
			con.close();
		 
		        } catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		        }
	}
	
	public void insertTeacher(Teacher item)
    {
        try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
            st.execute("insert into teacher values(null,'"+item.getName()+"','"+item.getLastname()+"')");
			
        	st.close();
			con.close();
		 
		        } catch (SQLException ex) {
		            System.out.print("hata : "+ex);
		        }
	}
	
	public static void insertCourse(Course item)
    {
		try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
            st.executeUpdate("insert into course values(null,'"+item.toString()+"','"+null+"')");
			
        	st.close();
			con.close();
		 
		    } catch (SQLException ex) {
		           System.out.print("hata : "+ex);
		    }
	}
	
	public static void insertClass(Model.Class item)
    {
		try {
            Statement st = null;
            Connection con = baglan(); // baðlantý fonksiyonumuzla baðlantý kuruldu...
            st = con.createStatement();
            
            st.executeUpdate("insert into class values(null,'"+item.toString()+"','"+null+"')");
			
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
