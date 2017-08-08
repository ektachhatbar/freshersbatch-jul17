class Singletone{
	private static Singletone singletonObject=new Singletone();
	private Singletone(){}
	public static Singletone getObject(){
		return singletonObject;
	}
	public void print(){
		System.out.println("Singletone");
	}
}
class SingletoneTest{
	public static void main(String args[]){
		//Singletone s=new Singletone();
		Singletone s1=Singletone.getObject();
		s1.print();
	}
}