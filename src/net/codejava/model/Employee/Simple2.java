package net.codejava.model.Employee;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Simple2 extends JFrame implements ActionListener {
	private ConnectionDb connect  ;
	private JPanel Poc= new JPanel(new GridLayout(10,1));
	private  String i,f,n1,g;
	private  int n;
	private JTextField FNT1 = new JTextField(10);
	private JTextField LNT1 = new JTextField(10);
	private JTextField PNT1 = new JTextField(10);
	private JTextField GNT1 = new JTextField(10);
    private EmployeeTableModel model = new EmployeeTableModel(connect);
    private EditableTableExample b = new EditableTableExample(connect);
	public Simple2(ConnectionDb connect) {
		this.connect = connect;
		setTitle("Добавити Абонента");
		setSize(550,300);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(Poc,BorderLayout.CENTER);
		Label DL = new Label("                 Вкажіть Данні");
		DL.setBackground(Color.blue);
		DL.setForeground(Color.WHITE);
		Poc.add(DL);
		Poc.add(new Label("                         Ім'я                          "));
        Poc.add(FNT1 );
		Poc.add(new Label("                      Прізвище     "));
		Poc.add(LNT1 );
		Poc.add(new Label("                     Телефон    "));				
		Poc.add(PNT1 );
		Poc.add(new Label("                        Група    "));		
		Poc.add(GNT1 );
		JButton b1 = new JButton("Добавити");
		Poc.add(b1 );
		
		 
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
			 //	model.addData(connect);
			
					
			}
        	 
         });
		setLocationRelativeTo(null);
		pack();
		setResizable(false);  
	}

	public void actionPerformed(ActionEvent e) {
		
		
	}

}
