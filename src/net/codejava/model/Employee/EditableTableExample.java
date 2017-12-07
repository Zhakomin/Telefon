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
import java.util.List;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

 
public class EditableTableExample extends JPanel implements Runnable, ActionListener,ItemListener {
	private String[] messageStrings = {"По Прізвищу","По Імуню"};

	private ConnectionDb connect;
	
	private EmployeeTableModel model ;
	JTable table;
	JScrollPane bookTableScroolPage;
	String str;
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
	JRadioButton dogButton1 = new JRadioButton("firstname");
	JRadioButton dogButton2 = new JRadioButton("Group");
	JRadioButton dogButton = new JRadioButton("lastname");
	ButtonGroup bG = new ButtonGroup();
    public EditableTableExample(ConnectionDb connect)
    {
    		this.connect = connect;
    		model =  new EmployeeTableModel(connect);
    		
    }

 public void init() {
	 (new Thread(this)).start(); 
	 setLayout(new BorderLayout());
	     table = new JTable(model);
       	JButton addButton = new JButton("Добавити Абонента");
       	JButton DelButton = new JButton("Видалити Абоента");
        JButton setupButton = new JButton("Пошук");
   	 bookTableScroolPage = new JScrollPane(table);
        bookTableScroolPage.setPreferredSize(new Dimension(400,400));
         Simple1 simple1 = new Simple1(connect, model);
          // model.setValueAt();
           model.addData(connect);
           add(p,BorderLayout.SOUTH);
         table.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
		        if(e.getClickCount()==1) {
		        	int viewIndex = table.getSelectedRow();
		        	simple1.setId((Integer) model.getValueAt(viewIndex, 0));
		            simple1.setFirstname( (String) model.getValueAt(viewIndex, 1));
		            simple1.setLastname((String) model.getValueAt(viewIndex, 2));
		            simple1.setPhone((Integer) model.getValueAt(viewIndex, 3));
		            simple1.setGroupphone((String) model.getValueAt(viewIndex, 4));
		            simple1.setVisible(true);
		        	
		        }
				
			}
		});
       
 		
         ActionListener actionListener = new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 JComboBox box = (JComboBox)e.getSource();
                         String item = (String)box.getSelectedItem();
                        // System.out.println(item);
                         connect.updateQuery("SELECT * FROM abonentu ORDER BY phone asc );");
                         
             }
         };
          
         JComboBox comboBox = new JComboBox(messageStrings);

         comboBox.addActionListener(actionListener);
      
        Simple2 simple2 = new Simple2(connect);
         addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//simple2.setVisible(true);
				//model.addData(connect);
			
				
			}
			
         } );
         Print.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				model.addData(connect);
 				
 			}
 			
          } );
         setupButton.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				if (dogButton1.isSelected() ) {
 					str = FNT.getText();
 					int str1 =1;
 	 				model.addPrint(connect,str,str1);
 	 				
 		        }
 				if (dogButton.isSelected() ) {			
 					str = FNT.getText();
 					int str2 =0;
 	 				model.addPrint(connect,str,str2);
 				}
 				if (dogButton2.isSelected() ) {			
 					str = FNT.getText();
 					int str2 =3;
 	 				model.addPrint(connect,str,str2);
 				}
 				
 			}
 			
          } );
         Label DL = new Label("Добавити Абонента");
 		DL.setBackground(Color.blue);
 		DL.setForeground(Color.WHITE);
 		bG.add(dogButton1);
 		bG.add(dogButton);
 		bG.add(dogButton2);
 		dogButton1.setSelected(true);
 		p2.add(DL);
 		p2.add(new Label("                 Ім'я               "));
         p2.add(FNT1 );
 		p2.add(new Label("               Прізвище          "));
 		p2.add(LNT1 );
 		p2.add(new Label("                Телефон       "));				
 		p2.add(PNT1 );
 		p2.add(new Label("                  Група        "));		
 		p2.add(GNT1 );
 		JButton b1 = new JButton("Добавити");
 		p2.add(b1 );
 		p2.add(DelButton);
         add(p2,BorderLayout.WEST);
         
         //p2.add(ch1);
         //p.add(addButton);
 		p.add(FNT);
 		p2.add(Print);
 		//p.add(p1);
 		p.add(setupButton);
 		p.add(dogButton1);
 		p.add(dogButton);
 		p.add(dogButton2);
 		add(bookTableScroolPage,BorderLayout.EAST);
 		DelButton .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.Delet(connect, simple1.getFIID());
				model.addData(connect);
				
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
		
					model.addDataa(connect,i,f,n,g);
					model.addData(connect);
					FNT1.setText("");
				 GNT1.setText("");
					 LNT1.setText("");
					 PNT1.setText("");
			
					
			}
        	 
         });
	}
		@Override
		public void actionPerformed(ActionEvent e) {

		}

		@Override
		public void run() {
			try {
	    		while(true) {
	    			Thread.sleep(1000);
	    			//model.addData(connect);
	    			repaint();
	    			
				
	    		}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}

     
   
}