import java.lang.reflect.*;

class ReflectTest{
	public static void main(String args[])throws Exception{
		//Class c=ReflectTest.class;
		Class c=Class.forName(args[0]);
		Field f[]=c.getDeclaredFields();
		Method m[]=c.getDeclaredMethods();
		Constructor con[]=c.getDeclaredConstructors();
		for(int i=0;i<f.length;i++){
			System.out.println(f[i]);
		}
		for(int i=0;i<m.length;i++){
			System.out.println(m[i]);
		}
		for(int i=0;i<con.length;i++){
			System.out.println(con[i]);
		}
	}
}