class StringTest{
	public static void main(String args[]){
		String str="ABC";
		String s=new String("ABC");
		System.out.println("Comparing References str==s "+(str==s));
		System.out.println("Comparing Contents str.equals(s) "+str.equals(s));		
	}
}