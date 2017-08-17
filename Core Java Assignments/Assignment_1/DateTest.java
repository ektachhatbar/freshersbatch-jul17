class Date{
	private int day;
	private int month;
	private int year;
	int temp;
	public Date(){
		this.day=11;
		this.month=12;
		this.year=1995;
	}
	public Date(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public int getDate(){
		return this.day;
	}
	public void setDate(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public void printDate(){
		System.out.println("Date : "+this.day+"/"+this.month+"/"+this.year);
	}
	public String toString(){
		return this.day+"-"+this.month+"-"+this.year;	
	}
	public static void swapDate(Date dt[]){
		Date temp;
		temp=dt[0];
		dt[0]=dt[1];
		dt[1]=temp;	
	}
}
public class DateTest{
	public static void main(String args[]){
		Date date[]=new Date[2];
		date[0]=new Date();
		date[1]=new Date(6,8,2017);
		System.out.println("date1 day : "+date[0].getDate());
		System.out.println("date2 day : "+date[1].getDate());
		date[0].setDate(4,9,1995);
		System.out.println("date1 after set Date day is "+date[0].getDate());
		System.out.print("date2 ");
		date[1].printDate();
		System.out.println("date1 using toString "+date[0]);
		System.out.println("Before swapping date1 : "+date[0]+" date2 : "+date[1]);
		Date.swapDate(date);
		System.out.println("After swapping date1 : "+date[0]+" date2 : "+date[1]);
	}
}