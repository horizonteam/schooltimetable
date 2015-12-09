package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Controller.TimeTableController;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	JPanel panel;
	JTable table;
	JList<String> list;
	JComboBox<String> menu;
	TableModel model;
	
	String[] a = {"asd","asdas","qqq","dddd"};
	String[] header = {"Pazartesi","Salý","Çarþamba","Perþembe","Cuma"};
	String[] menuList = {"Class","Teacher","Course"};
	public MainGUI() {
		super("School Time Table");
		setBounds(new Rectangle(900,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final TimeTableController ttc = new TimeTableController();
				
		//Panel oluþturma
		panel = new JPanel();
		panel.setLayout(null);
		
		//Combo Box oluþturma
		menu = new JComboBox<String>(menuList);
		menu.setBounds(20, 20, 210, 30);
		menu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Tablo Yapýsý
		table = new JTable(new AbstractTableModel() {
			
			@Override
			public Object getValueAt(int arg0, int arg1) {return null;}
			
			@Override
			public int getRowCount() {return 9;}
			
			@Override
			public int getColumnCount() {return 5;}
			
			
		});
		table.enable(false);
		table.setBounds(250, 20, 600, 400);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		table.setRowHeight(45);
		
		//Sol liste
		list = new JList<String>(ttc.getClasses());
		list.setBounds(20, 60, 210, 360);
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		panel.add(menu);
		panel.add(table);
		panel.add(list);
		add(panel);
		setVisible(true);
		
		list.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				String[][] data = ttc.getTableForClasses(arg0.getLastIndex());
				
				model = new DefaultTableModel(data,header);
				table.setModel(model);
			}
		});		
		
		
	}
	
	public static void main(String[] args) {
		MainGUI m = new MainGUI();
	}
	
}
