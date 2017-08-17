class StackedArray {
	private int []arr=new int[5];
	private int index=-1;
	public StackedArray(){}
	public void push(int data) { 
		if(index>=arr.length-1){
			System.out.println("Stack Full");
		}else{
			arr[++index]=data;
			System.out.println("Pushed Element : "+arr[index]);
		}
	}
	public void pop(){
		if(index<0){
			System.out.println("Empty Stack");
		}else{
			arr[index--]=0;
		}
	}
	public void print(){
		for(int i=0;i<arr.length&&arr[i]!=0;i++){
			System.out.println(arr[i]);
		}
	}
	
}
class StackedArrayTest{
	public static void main(String args[]){
		StackedArray stackedArray=new StackedArray();
		stackedArray.push(1);
		stackedArray.push(2);
		stackedArray.push(3);
		stackedArray.push(4);
		stackedArray.push(5);
		stackedArray.push(5);

		stackedArray.pop();
		stackedArray.pop();
		stackedArray.print();
	}
}

