public class StringBufferBuilderTest{
	public static void main(String args[]){
		String s="Hello";
		s.concat("world");
		System.out.println("String "+s);
		
		StringBuilder sb=new StringBuilder("Hello");
		sb.append("World");
		System.out.println("StringBuilder "+sb);
	}
}