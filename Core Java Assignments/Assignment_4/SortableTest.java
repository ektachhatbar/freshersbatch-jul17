interface Sortable{
	boolean compare(Sortable ss);
	public int print();
}
class Circle implements Sortable{
	private int radius;
	public Circle(int radius){
		this.radius=radius;
	}
	public boolean compare(Sortable c){
		Circle cc=(Circle)c;
		if(this.radius>cc.radius){
			return true;
		}else{
			return false;
		}
	}
	public int print(){
		return this.radius;
	}
}
class Employee implements Sortable{
	private int empId;
	public Employee(int empId){
		this.empId=empId;
	}
	public boolean compare(Sortable e){
		Employee ee=(Employee)e;
		if(this.empId>ee.empId){
			return true;
		}else{
			return false;
		}
	}
	public int print(){
		return this.empId;
	}
}
class SortableTest{
	public static void sortAll(Sortable s[]){
		Sortable temp;
		for(int i=0;i<s.length-1;i++){
			for(int j=i+1;j<s.length;j++){
				if(s[i].compare(s[j])){
					temp=s[i];
					s[i]=s[j];
					s[j]=temp;
				}
			}
		}
		for(int i=0;i<s.length;i++){
			System.out.println(s[i].print());
		}
	}
	public static void main(String args[]){
		Sortable []s=new Sortable[5];
		s[0]=new Circle(5);
		s[1]=new Circle(1);
		s[2]=new Circle(3);
		s[3]=new Circle(9);
		s[4]=new Circle(0);
		/*
		s[5]=new Employee(500);
		s[6]=new Employee(121);
		s[7]=new Employee(30);
		s[8]=new Employee(93);
		s[9]=new Employee(10);
		//s[1]=new Employee();*/
		SortableTest.sortAll(s);
	}
}