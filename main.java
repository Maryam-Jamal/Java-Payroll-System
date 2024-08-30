public abstract class Employe {
    private String firstName;
    private String lastName;
    private String IdNumber;
    private String sex;
    private String birthdate;
    public Employe(String fn, String ln, String id,String s,String bd){
        firstName=fn;
        lastName=ln;
        IdNumber=id;
        sex=s;
        birthdate=bd;
        
    }
    public void setfirstName(String fn){
        FirstName=fn;
    }
    public String getfirstName(){
        return firstName;
    }
    public void setlastName(String ln){
        LastName=ln;
    }
    public String getlastName(){
        return lastName;
    }
    public void setIdNumber(String id){
        IdNumber=id;
    }
    public String getIdNumber(){
        return IdNumber;
    }
    public void setSex(String s){
        sex=s;
    }
    public String getSex(){
        return sex;
    }
    public void setBirthDate(String bd){
        birthDate=bd;
    }
    public String getBirthDate(){
        return birthDate;
    }
    
    public abstract double monthlySalary();
        

    @Override
    public String toString(){
        return String.format("ID number:%s \nEmployee name:%s %s\nBirth Date:%s",getIDNumber(),getFirstName(),getLastName(),getBirthDate());
        
    }
}

public class Staff extends Employe{ 
    private double hourlyRate;
    public Staff(String fn, String ln, String id, String s, String date, double Hourlyrate) {
        super(fn, ln, id, s, bd);
        setRate(Hourlyrate);
        
    }
    public  void setRate(double Hourlyrate){
        
          if(Hourlyrate >=0.0)  
            hourlyRate=Hourlyrate;
        
        else
            throw new IllegalArgumentException("Hourly wage must be greater than or equal to 0");
    }
    public double getRate(){
        return hourlyRate;
    }

     public double earnings(){
            return monthlySalary();
    }

    public double monthlySalary() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

public class Parttime extends Staff{
    private double hoursWorkedPerWeek;
   public Parttime(String fn, String ln, String id,String s,String bd,double  Hourlyrate,double hoursWorked) {
        super(fn, ln, id,s,bd,Hourlyrate);
        setWork(hoursWorked);
   }
   public  void setWork(double hoursWorked){
       
            hoursWorkedPerWeek=hoursWorked;
       
    }
    public double getWork(){
        return hoursWorkedPerWeek;
    }
    public double earnings(){
            return getRate()*getWork();
    }
    public double MonthlySalary(){
        return earnings()*4;
    
}
    @Override
    public String toString(){ 
        return String.format("%s\n%s: %,.2f",super.toString(),"Hours Worked Per Week",getRate(),"Monthly Salary",MonthlySalary()); 
}

    public double getRate() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }  
}

import java.util.Scanner;
public class test {
public static void main(String[] args) {
        
        Scanner i= new Scanner(System.in);
        System.out.print("First name: ");
        String firstName=i.next();
        System.out.print("Last Name: ");
        String lastName=i.next();
        System.out.print("ID NUMBER: ");
        String IDNumber=i.next();
        System.out.print("Sex(Male or Female): ");
        String Sex=i.next();
        System.out.print("Birth Date: ");
        String birthDate=i.next();
        System.out.print("Worked Hours Per Week: ");
        double Hourlyrate =i.nextDouble();
        System.out.print("Hourly Rate: ");
        double hoursWorked=i.nextDouble();
        
        Parttime hourlyEmployee = new Parttime(firstName,lastName,IDNumber,Sex,birthDate,Hourlyrate,hoursWorked);
    
        System.out.println("\nEmployee details\n");
        System.out.println(hourlyEmployee+"\nMonthly Salary:"+hourlyEmployee.MonthlySalary( ) );
}

}
