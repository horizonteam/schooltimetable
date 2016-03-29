package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.AdminController;

@SuppressWarnings("serial")
public class AdminMainUI extends JPanel {

	
	JTable table;
	JList<String> list,hours,days;
	JComboBox<String> menu;
	TableModel model;
	
	int mode = 1; //0->initial , 1 ->Class , 2->Teacher , 3->Course
	
	String[] times = {"9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"};
	String[] header = {"Pazartesi","Salý","Çarþamba","Perþembe","Cuma"};
	String[] menuList = {"Class","Teacher","Course"};
	
	public AdminMainUI(AdminController ttc) {
		setBounds(new Rectangle(1270,480));
				
		//Panel oluþturma
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.getHSBColor(210, 255, 190));
		
		//Combo Box oluþturma
		menu = new JComboBox<String>(menuList);
		menu.setBounds(20, 20, 210, 30);
		menu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		days = new JList<>(header);
		days.setBounds(330, 20, 900, 36);
		days.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		days.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		days.setVisibleRowCount(1);
		days.setFixedCellWidth(180);
		days.setFixedCellHeight(35);
		days.setFocusable(false);
		
		hours = new JList<>(times);
		hours.setBounds(250, 60, 75, 360);
		hours.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		hours.setFixedCellHeight(45);
		hours.setFocusable(false);
		
		//Tablo Yapýsý
		table = new JTable(new AbstractTableModel() {
			@Override
			public Object getValueAt(int arg0, int arg1) {return null;}
			@Override
			public int getRowCount() {return 9;}
			@Override
			public int getColumnCount() {return 5;}
		});
		
		DefaultListCellRenderer centered1 = (DefaultListCellRenderer)hours.getCellRenderer();
		centered1.setHorizontalAlignment(JLabel.CENTER);
		
		centered1 = (DefaultListCellRenderer)days.getCellRenderer();
		centered1.setHorizontalAlignment(JLabel.CENTER);
		
		DefaultTableCellRenderer centered = new DefaultTableCellRenderer();
		centered.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.enableInputMethods(false);
		table.setBounds(330, 60, 900, 360);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		table.setRowHeight(45);
		
		//Sol liste
		list = new JList<String>(ttc.getClassNames());
		list.setBounds(20, 60, 210, 360);
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		add(menu);
		add(table);
		add(list,BorderLayout.CENTER);
		add(days);
		add(hours);
		setVisible(true);
		
		list.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				String[][] data ;
								
				switch (mode) {
				case 1:
					data = ttc.getTableForClasses(arg0.getLastIndex());
					model = new DefaultTableModel(data,header);
					break;
				case 2:
					data = ttc.getTableForTeacher(arg0.getLastIndex());
					model = new DefaultTableModel(data,header);
					break;
				case 3:
					data = ttc.getTableForCourse(arg0.getLastIndex());
					model = new DefaultTableModel(data,header);
					break;
				default:
					model = new DefaultTableModel();
					break;
				}
								
				table.setModel(model);
				table.getColumnModel().getColumn(0).setCellRenderer(centered);
				table.getColumnModel().getColumn(1).setCellRenderer(centered);
				table.getColumnModel().getColumn(2).setCellRenderer(centered);
				table.getColumnModel().getColumn(3).setCellRenderer(centered);
				table.getColumnModel().getColumn(4).setCellRenderer(centered);
			}
		});		
		
		menu.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				System.out.println(arg0.getNewValue());
				
			}
		});
		
		menu.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				if(arg0.getItem().toString().endsWith("Class")){
					list.setListData(ttc.getClassNames());
					table.setModel(new DefaultTableModel());
					mode = 1;
				}else if(arg0.getItem().toString().endsWith("Teacher")){
					list.setListData(ttc.getTeacherNames());
					table.setModel(new DefaultTableModel());
					mode = 2;
				}else if(arg0.getItem().toString().endsWith("Course")){
					list.setListData(ttc.getCourseNames());
					table.setModel(new DefaultTableModel());
					mode = 3;
				}
								
			}
		});
		
		
	}
		
}
