package net.codejava.model.Employee;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class EmployeeTableModel implements TableModel{
	
  private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
   private List<Employee> employeeList = new ArrayList<Employee>();;
   private  ConnectionDb connect ;  
   private final String[] columnNames = new String[] {
           "id", "firstname", "lastname", "phone", "groupphone"
   };
   private final Class[] columnClass = new Class[] {
       Integer.class, String.class, String.class,Integer.class,String.class
   };
 
   public void addTableModelListener(TableModelListener listener) {
       listeners.add(listener);
   }
   public EmployeeTableModel(ConnectionDb connect)
   {this.connect = connect;
	  
   }
    
   public String getColumnName(int column)
   {
       return columnNames[column];
   }

  
   public Class<?> getColumnClass(int columnIndex)
   {
       return columnClass[columnIndex];
   }

  
   public int getColumnCount()
   {
       return columnNames.length;
   }

   public int getRowCount()
   {
       return employeeList.size();
   }


   public Object getValueAt(int rowIndex, int columnIndex)
   {
       Employee row = employeeList.get(rowIndex);
       if(0 == columnIndex) {
    	  
           return row.getId();
       }
       else if(1 == columnIndex) {
    	  
           return row.getFirstname();
       }
       else if(2 == columnIndex) {
    	  
           return row.getLastname();
       }
       if(3 == columnIndex) {
    	
           return row.getPhone();
       }
       if(4 == columnIndex) {
    	  
           return row.getGroupphone();
       }

       return null;
   }

  @Override
   public boolean isCellEditable(int rowIndex, int columnIndex)
   {  // simple1.setVisible(true);
       return true;
   }

 
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {
       Employee row = employeeList.get(rowIndex);
       /*if(0 == columnIndex) {
           row.setId((Integer) aValue);
           
       }
       else */if(1 == columnIndex) {
           row.setFirstname((String) aValue);
      
   
          connect.updateQuery("UPDATE abonentu SET firstname  = '"+ aValue +"' where id = '"+ row.getId()+"';" );
          
         
          
       }
       else if(2 == columnIndex) {
           row.setLastname((String) aValue);
           connect.updateQuery("UPDATE abonentu SET lastname  = '"+ aValue +"' where id = '"+ row.getId()+"';" );
       }
       else if(3 == columnIndex) {
           row.setPhone((Integer) aValue);
           connect.updateQuery("UPDATE abonentu SET phone  = '"+ aValue +"' where id = '"+ row.getId()+"';" );
       }
       else if(4 == columnIndex) {
           row.setGroupphone((String) aValue);
           connect.updateQuery("UPDATE abonentu SET groupphone  = '"+ aValue +"' where id = '"+ row.getId()+"';" );
       }
       
      
   }
   
   public void addData(ConnectionDb  connect) {
		ResultSet result =  connect.resultSetQuery("Select * from abonentu;");
		employeeList.clear();
		try {
			while(result.next()) {
				
				
				
				Employee row1 = new Employee(result.getInt("id"), result.getString("firstname"), result.getString("lastname"),result.getInt("phone"),result.getString("groupphone"));
				employeeList.add(row1);	
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
   }
		
   public void addPrint(ConnectionDb  connect,String str,int s) {
		ResultSet result =  connect.resultSetQuery("Select * from abonentu;");
		employeeList.clear();
		try {
			while(result.next()) {
				
				if(result.getString("firstname").equals(str) && (s==1)) {
				Employee row1 = new Employee(result.getInt("id"), result.getString("firstname"), result.getString("lastname"),result.getInt("phone"),result.getString("groupphone"));
				employeeList.add(row1);	
				}
				if(result.getString("lastname").equals(str)&& (s==0)) {
					Employee row1 = new Employee(result.getInt("id"), result.getString("firstname"), result.getString("lastname"),result.getInt("phone"),result.getString("groupphone"));
					employeeList.add(row1);	
					}
				if(result.getString("groupphone").equals(str)&& (s==3)) {
					Employee row1 = new Employee(result.getInt("id"), result.getString("firstname"), result.getString("lastname"),result.getInt("phone"),result.getString("groupphone"));
					employeeList.add(row1);	
					}
			}
			//result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
  
   public void addDataa(ConnectionDb  connect, String i, String f, int n, String g ) {
		
		 connect.updateQuery("INSERT INTO abonentu(firstname , lastname, phone,groupphone) VALUES('"+ i +"', '"+ f +"', '"+ n +"', '"+ g +"'  );");
		
		}

   public void Delet(ConnectionDb  connect, int n ) {
		
		 connect.updateQuery("delete  from abonentu where id ='"+ n +"'; ");
		
		}
   

@Override
public void removeTableModelListener(TableModelListener listener) {
	listeners.add(listener);
	
} 

		
		
	
	
	
	






}