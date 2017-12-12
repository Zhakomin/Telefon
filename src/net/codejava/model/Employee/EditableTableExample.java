package net.codejava.model.Employee;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.log.Log;

 
public class EditableTableExample extends JPanel implements ActionListener {
	private String[] messageStrings = {"По Прізвищу","По Імуню"};
	private ConnectionDb connect;
	private EmployeeTableModel model ;
	private JTable table;
	private JScrollPane bookTableScroolPage;
	private String str;
	private JTextField FNT = new JTextField(10);
	private JPanel p = new JPanel(new GridLayout());
	private JPanel p2 = new JPanel(new GridLayout(17,1));
	private JButton Print = new JButton("Список Абонентов");
	private  String i,f,n1,g;
	private  int n;
	private JTextField FNT1 = new JTextField(10);
	private JTextField LNT1 = new JTextField(10);
	private JTextField PNT1 = new JTextField(10);
	private JTextField GNT1 = new JTextField(10);
	private JButton addButton = new JButton("Деталі");
	private JButton DelButton = new JButton("Видалити Абоента");
	private JButton setupButton = new JButton("Пошук");
	private JRadioButton IButton = new JRadioButton("Ім'я");
	private JRadioButton GButton = new JRadioButton("Група");
	private JRadioButton PButton = new JRadioButton("Прізвище");
	private JButton sort = new JButton("Сортувати");
	
	private ButtonGroup bG = new ButtonGroup();
	
    public EditableTableExample(ConnectionDb connect)
    {
    		this.connect = connect;
    		List<Employee> employeeList = new ArrayList<Employee>();
    		model =  new EmployeeTableModel(connect,employeeList); 
    		setLayout(new BorderLayout());
    	     table = new JTable(model);  	
    	   	 bookTableScroolPage = new JScrollPane(table);
    	     bookTableScroolPage.setPreferredSize(new Dimension(400,400));
    	     Simple  simple = new Simple(connect, model);
    	     model.Print(connect);
    	     add(p,BorderLayout.SOUTH);
    	     table.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mouseClicked(MouseEvent e) {
    			        if(e.getClickCount()==1) {
    			        	int viewIndex = table.getSelectedRow();
    			        	simple.setId((Integer) model.getValueAt(viewIndex, 0));
    			            simple.setFirstname( (String) model.getValueAt(viewIndex, 1));
    			            simple.setLastname((String) model.getValueAt(viewIndex, 2));
    			            simple.setPhone((Integer) model.getValueAt(viewIndex, 3));
    			            simple.setGroupphone((String) model.getValueAt(viewIndex, 4));                 	
    			        }			
    				}
    			});
    	         
    	         
    	         Print.addActionListener(new ActionListener() {

    	 			@Override
    	 			public void actionPerformed(ActionEvent e) {
    	 				
    	 				model.Print(connect);
    	 				
    	 			}
    	 			
    	          } );
    	         setupButton.addActionListener(new ActionListener() {

    	 			@Override
    	 			public void actionPerformed(ActionEvent e) {
    	 				
    	 				if (IButton.isSelected() ) {
    	 					str = FNT.getText();
    	 					int str1 =1;
    	 	 				model.Search(connect,str,str1);
    	 	 				
    	 		        }
    	 				if (PButton.isSelected() ) {			
    	 					str = FNT.getText();
    	 					int str2 =0;
    	 	 				model.Search(connect,str,str2);
    	 				}
    	 				if (GButton.isSelected() ) {			
    	 					str = FNT.getText();
    	 					int str2 =3;
    	 	 				model.Search(connect,str,str2);
    	 				}
    	 				
    	 			}
    	 			
    	          } );
    	        Label DL = new Label("         Добавити Абонента      ");
    	 		DL.setBackground(Color.blue);
    	 		DL.setForeground(Color.WHITE);
    	 		bG.add(IButton);
    	 		bG.add(GButton);
    	 		bG.add(PButton);
    	 		IButton.setSelected(true);
    	 		p2.add(DL);
    	 		p2.add(new Label("                      Ім'я               "));
    	         p2.add(FNT1 );
    	 		p2.add(new Label("                  Прізвище          "));
    	 		p2.add(LNT1 );
    	 		p2.add(new Label("                   Телефон       "));				
    	 		p2.add(PNT1 );
    	 		p2.add(new Label("                    Група        "));		
    	 		p2.add(GNT1 );
    	 		JButton b1 = new JButton("Добавити");
    	 		p2.add(b1 );
    	 		p2.add(addButton);
    	 		p2.add(DelButton);
    	         add(p2,BorderLayout.WEST);
    	 		p.add(FNT);
    	 		p2.add(Print);
    	 		p.add(setupButton);
    	 		p.add(IButton);
    	 		p.add(PButton);
    	 		p.add(GButton);
    	 		p2.add(sort);
    	 		sort.addActionListener(new ActionListener() {

     	 			@Override
     	 			public void actionPerformed(ActionEvent e) {
     	 				
     	 				if (IButton.isSelected() ) {
     	 					model.PrinF();
    	 	 				
    	 		        }
    	 				if (PButton.isSelected() ) {			
    	 					model.PrinL();
    	 				}
     	 				
     	 				
     	 			}
     	 			
     	          } );
    	 		add(bookTableScroolPage,BorderLayout.EAST);
    	 		DelButton .addActionListener(new ActionListener() {

    				@Override
    				public void actionPerformed(ActionEvent e) {
    					model.Delet(connect, simple.getFIID());
    					model.Print(connect);
    					
    				}
    		});
    	 		 
    			b1.addActionListener(new ActionListener() {

    				@Override
    				public void actionPerformed(ActionEvent ea) {
    					i = FNT1.getText();
    					g = GNT1.getText();
    					f = LNT1.getText();
    					n1 = PNT1.getText();
    					
    					try {
    						n=Integer.parseInt(n1);
    						
    					} catch (Exception e) {
    						
    					} 
    				         model.addData(connect,i,f,n,g);
    				         model.Print(connect);
    				         FNT1.setText("");
    				    	 GNT1.setText("");
    						 LNT1.setText("");
    						 PNT1.setText("");		
    					
    				}
    	        	 
    	         });
    			addButton.addActionListener(new ActionListener() {

        			
    				@Override
    				public void actionPerformed(ActionEvent ea) {
    					 simple.setVisible(true);		    
    					
    				}
    	         });
    			    }

		@Override
		public void actionPerformed(ActionEvent e) {

		}
		

}