public class BannerTest{
	public static void main(String args[])throws Exception{
		StringBuilder sb=new StringBuilder(" Welcome to Java");
		while(true){
			char c=sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(c);
			Thread.sleep(500);
			System.out.print("  "+sb+ "\r");
		}
	}
}