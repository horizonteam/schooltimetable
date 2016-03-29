package View;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.AdminController;
import Controller.DatabaseConnectionController;
import Model.Teacher;

@SuppressWarnings("serial")
public class TeacherUI extends JPanel {

	JLayeredPane panel;
	JLabel l1,l2,l3,l4;
	JTextField tx1,tx2,tx3,t4;
	JButton submit,add,reset,remove;
	JList<String> list;
	
	String full;
	Teacher teacher;
	public TeacherUI(AdminController ttc,DatabaseConnectionController db) {
		setBounds(new Rectangle(1270,480));
				
		//Panel oluþturma
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.getHSBColor(210, 255, 190));
		
		teacher = new Teacher(null, null);
		
		panel = new JLayeredPane();
		panel.setBorder(BorderFactory.createTitledBorder("Teacher"));
		panel.setLayout(null);
		setBorder(new EmptyBorder(20, 250, 20, 250));
		
		list = new JList<String>(ttc.getTeacherNames());
		list.setBounds(20, 20, 210, 360);
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l1 = new JLabel("  Name");
		l1.setBounds(270, 20, 150, 30);
		l1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		l2 = new JLabel("  Surname");
		l2.setBounds(270, 60, 150, 30);
		l2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));		
		
		tx1 = new JTextField();
		tx1.setBounds(440, 20, 250, 30);
		tx2 = new JTextField();
		tx2.setBounds(440, 60, 250, 30);
		
		submit = new JButton("Save");
		submit.setBounds(270, 255, 200, 30);
		reset = new JButton("Clear");
		reset.setBounds(490, 255, 200, 30);
		remove = new JButton("Remove this Teacher!");
		remove.setBounds(270, 350, 420, 30);
		add = new JButton("Add new Teacher");
		add.setBounds(270, 300, 420, 30);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				full = list.getSelectedValue();
				teacher.setName(full.split(" ")[0]);
				teacher.setLastname(full.split(" ")[1]);
				
				tx1.setText(teacher.getName());
				tx2.setText(teacher.getLastname());
			}
		});
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tx1.setText("");
				tx2.setText("");
			}
		});
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				db.insertTeacher(teacher);
			}
		});
		
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO remove teacher
				
			}
		});
		
		panel.add(list);
		panel.add(l1);
		panel.add(tx1);
		panel.add(l2);
		panel.add(tx2);
		panel.add(submit);
		panel.add(reset);
		panel.add(remove);
		panel.add(add);
		add(panel);
		
		setVisible(true);
	}
	
	
}
