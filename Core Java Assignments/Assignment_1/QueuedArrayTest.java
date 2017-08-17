class QueuedArray {
	private int []arr=new int[5];
	private int index=-1;
	public QueuedArray(){}
	public void insert(int data) { 
		if(index>=arr.length-1){
			System.out.println("Queue Full");
		}else{
			arr[++index]=data;
			System.out.println("Inserteded Element : "+arr[index]);
		}
	}
	public void delete(){
		if(index<0){
			System.out.println("Queue Empty");	
		}else{
			arr[(arr.length-1)-index]=0;
			index--;
		}
	}
	public void print(){
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0)
				System.out.println(arr[i]);
		}
	}
	
}
class QueuedArrayTest{
	public static void main(String args[]){
		QueuedArray queuedArray=new QueuedArray();
		queuedArray.insert(1);
		queuedArray.insert(2);
		queuedArray.insert(3);
		queuedArray.insert(4);
		queuedArray.insert(5);
		queuedArray.insert(6);
		
		queuedArray.delete();
		queuedArray.delete();
		
		queuedArray.print();
	}
}

