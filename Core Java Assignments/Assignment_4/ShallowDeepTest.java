import java.util.*;

class Employee implements Cloneable{
	public Dob dob;
	Employee(Dob dob){
		this.dob=dob;
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	} 
	public Object deepclone()throws CloneNotSupportedException{  
		Dob d=(Dob)this.dob.clone();
		Employee e=(Employee)super.clone();
		e.dob=d;
		return e;
		
	}
	
}
class Dob implements Cloneable{
	private int day;
	private int month;
	private int year;
	Dob(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}
}
class ShallowDeepTest{
	public static void main(String args[]){
		try{
			Dob d1=new Dob(11,9,1995);
			Employee emp1=new Employee(d1);
			Employee emp2=(Employee)emp1.clone();
			//emp2=(Employee)emp1.deepclone();
			if(emp1.dob==emp2.dob)
				System.out.println("Shallow Copy");
			if(emp1.dob!=emp2.dob)
				System.out.println("Deep Copy");
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
	}
}	