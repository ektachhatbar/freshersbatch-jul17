class ComplexNumber{
	public int real;
	public int imaginary;
	public int temp;
	ComplexNumber(){
	}
	public ComplexNumber(int real,int imaginary){
		this.real=real;
		this.imaginary=imaginary;
	}
	public ComplexNumber addComplexNumber(ComplexNumber cn1,ComplexNumber cn2){
		ComplexNumber sumOfComplexNumber=new ComplexNumber();
		sumOfComplexNumber.real=cn1.real+cn2.real;
		sumOfComplexNumber.imaginary=cn1.imaginary+cn2.imaginary;
		return sumOfComplexNumber;
	}
	public ComplexNumber subtractComplexNumber(ComplexNumber cn1,ComplexNumber cn2){
		ComplexNumber subOfComplexNumber=new ComplexNumber();
		subOfComplexNumber.real=cn1.real-cn2.real;
		subOfComplexNumber.imaginary=cn1.imaginary-cn2.imaginary;
		return subOfComplexNumber;
	}
	public ComplexNumber multiplyComplexNumber(ComplexNumber cn1,ComplexNumber cn2){
		ComplexNumber mulOfComplexNumber=new ComplexNumber();
		mulOfComplexNumber.real=cn1.real*cn2.real;
		mulOfComplexNumber.imaginary=cn1.imaginary*cn2.imaginary;
		return mulOfComplexNumber;
	}
	public void swap(ComplexNumber cn2){
		temp=this.real;
		this.real=cn2.real;
		cn2.real=temp;
		temp=this.imaginary;
		this.imaginary=cn2.imaginary;
		cn2.imaginary=temp;
	}
	public String toString(){
		return this.real+" + i"+this.imaginary;	
	}
}
public class ComplexNumberTest{
	public static void main(String args[]){
		ComplexNumber complexNumber1=new ComplexNumber(2,3);
		ComplexNumber complexNumber2=new ComplexNumber(4,5);
		ComplexNumber complexNumber3=new ComplexNumber();
		complexNumber3=complexNumber3.addComplexNumber(complexNumber1,complexNumber2);
		System.out.print("After Adding ComplexNumber : ");
		System.out.println(complexNumber3);
		complexNumber3=complexNumber3.subtractComplexNumber(complexNumber1,complexNumber2);
		System.out.print("After Subtracting ComplexNumber : ");
		System.out.println(complexNumber3);
		complexNumber3=complexNumber3.multiplyComplexNumber(complexNumber1,complexNumber2);
		System.out.print("After Multiplying ComplexNumber : ");
		System.out.println(complexNumber3);
		System.out.println("Before Swapping : complexNumber1 = "+complexNumber1+" and complexNumber2 = "+complexNumber2);
		complexNumber1.swap(complexNumber2);
		System.out.println("After Swapping : complexNumber1 = "+complexNumber1+" and complexNumber2 = "+complexNumber2);
	}
}