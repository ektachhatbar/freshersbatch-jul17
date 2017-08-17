abstract class Abstract{
	abstract void print();
	void show(){}
}
class SubAbstract extends Abstract{
	void print(){}
	void show(){}
}
class AbstractTest{
	//Abstract a=new Abstract();
	SubAbstract sub=new SubAbstract();
}