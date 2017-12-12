package net.codejava.model.Employee;

import java.util.Comparator;

public class Employee 
{
    private int id;
    private String firstname;
    private String lastname;
    private int phone;
    private String groupphone;
    public Employee(int id, String firstname, String lastname,int phone, String groupphone)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.groupphone = groupphone;
    }
 
    public int getId()
    {
        return id;
    }
 
    public void setId(int id)
    {
        this.id = id;
    }
 
    public String getFirstname()
    {
        return firstname;
    }
 
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }
 
    public String getLastname()
    {
        return lastname;
    }
 
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
 
    public int getPhone()
    {
        return phone;
    }
 
    public void setPhone(int phone)
    {
        this.phone = phone;
    }
    public String getGroupphone()
    {
        return groupphone;
    }
 
    public void setGroupphone(String groupphone)
    {
        this.groupphone = groupphone;
    }
   
    public static final Comparator<Employee> COMPARE_BY_Firstname = new Comparator<Employee>() {
   
    	public int compare(Employee p1, Employee p2)
        {
           
           if(p1.getFirstname().equals(p2.getFirstname()))
           {
               return p1. getLastname().compareTo(p2. getLastname());
           }
           return p1.getFirstname().compareTo(p2.getFirstname());
        }
    };
    public static final Comparator<Employee> COMPARE_BY_Lastname = new Comparator<Employee>() {
    	   
    	public int compare(Employee p1, Employee p2)
        {
           
           return p1.getLastname().compareTo(p2.getLastname());
        }
    };
    
   
 
}