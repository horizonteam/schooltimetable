package View;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controller.AdminController;
import Controller.DatabaseController;

@SuppressWarnings("serial")
public class AdminUI extends JFrame {

	JTabbedPane root;
	
	public AdminUI() {
		super("School Time Table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(1300,500));
		setResizable(false);
		setMenuBar(null);
		
		final AdminController ttc = new AdminController();
		final DatabaseController db = new DatabaseController();
		
		root = new JTabbedPane();
		root.setBackground(Color.WHITE);
		root.addTab("Main", new AdminMainUI(ttc));
		root.addTab("Teacher", new TeacherUI(ttc,db));
		root.addTab("Course", new CourseUI(ttc,db));
		root.addTab("Class", new ClassUI(ttc,db));
		root.addTab("Schedule", new ScheduleUI(ttc));
		add(root);	
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new AdminUI();
	}
}
