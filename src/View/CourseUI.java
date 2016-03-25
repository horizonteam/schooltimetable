package View;

import java.awt.Color;
import java.awt.Rectangle;

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

public class CourseUI extends JPanel {

	JLayeredPane panel;
	JLabel l1,l2,l3,l4;
	JTextField tx1,tx2,tx3,t4;
	JButton submit,reset,remove;
	JList<String> list;
	String full,department,code;
	
	public CourseUI(AdminController ttc) {
		setBounds(new Rectangle(1270,480));
		
		//Panel oluþturma
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.getHSBColor(210, 255, 190));
		
		panel = new JLayeredPane();
		panel.setBorder(BorderFactory.createTitledBorder("Course"));
		panel.setLayout(null);
		setBorder(new EmptyBorder(20, 250, 20, 250));
		
		list = new JList<String>(ttc.getCourseNames());
		list.setBounds(20, 20, 210, 360);
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				
		l1 = new JLabel("  Department");
		l1.setBounds(250, 20, 150, 30);
		l1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		l2 = new JLabel("  Code");
		l2.setBounds(250, 60, 150, 30);
		l2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));		
		
		tx1 = new JTextField();
		tx1.setBounds(420, 20, 250, 30);
		tx2 = new JTextField();
		tx2.setBounds(420, 60, 250, 30);
		
		submit = new JButton("Save");
		submit.setBounds(250, 100, 100, 30);
		reset = new JButton("Clear");
		reset.setBounds(370, 100, 100, 30);
		remove = new JButton("Remove this Course!");
		remove.setBounds(250, 350, 400, 30);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				full = list.getSelectedValue();
				department = full.split(" ")[0];
				code = full.split(" ")[1];
				
				tx1.setText(department);
				tx2.setText(code);
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
		add(panel);
		
		setVisible(true);
	}
}
