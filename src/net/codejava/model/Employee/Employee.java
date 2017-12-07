package net.codejava.model.Employee;

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
 
   
 
}