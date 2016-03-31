package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AdminController;

public class ScheduleUI extends JPanel {

	JLayeredPane panel;
	JLabel l1,l2,l3,l4;
	JButton submit;
	
	String full,block,number;
	public ScheduleUI(AdminController ttc) {
		setBounds(new Rectangle(1270,480));
		
		//Panel oluþturma
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.getHSBColor(210, 255, 190));
		
		panel = new JLayeredPane();
		panel.setBorder(BorderFactory.createTitledBorder("Schedule"));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		setBorder(new EmptyBorder(100, 250, 100, 250));
		
		l1 = new JLabel("Number of Teacher : "+ttc.getTeacherNames().length);
		l2 = new JLabel("Number of Course : "+ttc.getCourseNames().length);	
		l3 = new JLabel("Number of Class : "+ttc.getClassNames().length);
		l4 = new JLabel("Check new Table in Main Tab after Schedule!");
		submit = new JButton("Schedule");
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ttc.matchTable();
			}
		});
		
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(submit);
		panel.add(l4, FlowLayout.TRAILING);
		add(panel);
		
		setVisible(true);
	}
}
