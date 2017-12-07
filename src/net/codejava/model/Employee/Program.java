package net.codejava.model.Employee;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Program  extends JFrame {
	private ConnectionDb connect ;
	private EditableTableExample bookpanel;
	
	
	public  Program () {
		connect = new ConnectionDb();
		connect.init();
		bookpanel = new EditableTableExample(connect);
        bookpanel.init();
		setTitle("Телефонный справочник");
		setSize(new Dimension(600,400));
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       setLocationRelativeTo(null);
	        setLayout(new BorderLayout());
	      
	        add(bookpanel,BorderLayout.CENTER);
	        setVisible(true);
	        pack();
	
	       setResizable(false);                             // запрет изменений размеров окна 
	    	     
	}
	
    public static void main(String[] args)  {
    	
  
       Program p = new  Program();
     
       


        }


		
	}
	


	

    