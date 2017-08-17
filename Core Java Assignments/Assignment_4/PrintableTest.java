interface Printable{
	void print();
}
class Circle implements Printable{
	public void print(){
		System.out.println("Circle");
	}
}
class Employee implements Printable{
	public void print(){
		System.out.println("Employee");
	}
}
class PrintableTest{
	public static void printAll(Printable p[]){
		for(int i=0;i<p.length;i++){
			p[i].print();
		}
	}
	public static void main(String args[]){
		Printable []p=new Printable[2];
		p[0]=new Circle();
		p[1]=new Employee();
		PrintableTest.printAll(p);
	}
}