public class WrapperClassTest{
	public static void main(String args[]){
		int temp;
		int arg[]=new int[5];
		for(int i=0;i<args.length;i++){
			arg[i]=Integer.parseInt(args[i]);
		}
		for(int i=0;i<arg.length-1;i++){
			for(int j=i+1;j<arg.length;j++){
				if(arg[i]>arg[j]){
					temp=arg[i];
					arg[i]=arg[j];
					arg[j]=temp;
				}
			}
		}
		for(int i=0;i<arg.length;i++){
			System.out.println(arg[i]);
		}
	}
}