package net.codejava.model.Employee;


import java.awt.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public  class Simple extends JFrame  {
	private JTextField FNT2 = new JTextField(10);
	private JTextField LNT2 = new JTextField(10);
	private JTextField PNT2 = new JTextField(10);
	private JTextField GNT2 = new JTextField(10);
	private EditableTableExample bookpanel;
	private ConnectionDb connect;
	private JPanel Poc= new JPanel(new GridLayout(10,1));	
	private EmployeeTableModel model ;
	private int id;
	public Simple(ConnectionDb connect,EmployeeTableModel model) {
		this.connect = connect;
		this.model = model;
		setTitle("�������");
		setSize(200, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(Poc,BorderLayout.CENTER);
		Label DL = new Label("                   ����� ��� ��������");
		DL.setBackground(Color.blue);
		DL.setForeground(Color.WHITE);
		Poc.add(DL);
		Poc.add(new Label("                           ��'�"));
        Poc.add(FNT2 );
		Poc.add(new Label("                          �������"));
		Poc.add(LNT2 );
		Poc.add(new Label("                          �������"));				
		Poc.add(PNT2 );
		Poc.add(new Label("                           �����"));		
		Poc.add(GNT2 );
		setResizable(false); 	
	}
     public int getFIID(){
	        return id;
	    }
	
	 public void setId(int id){
	        this.id = id;
	    }
	 
     public void setFirstname(String firstname){
	        FNT2.setText(firstname);    
	    }
	 public void setLastname(String lastname) {
	      LNT2.setText(lastname);
	    }
	 public void setPhone(int phone){
	    	String strI = "" + phone;
		      PNT2.setText(strI);
	    }
	 public void setGroupphone(String groupphone){
	        GNT2.setText(groupphone);
	    }
	}