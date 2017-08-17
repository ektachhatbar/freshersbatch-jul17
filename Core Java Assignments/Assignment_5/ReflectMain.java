import java.lang.reflect.*;

class NameTest{
	//public String getCapitalName(String name){
	//	return name.toUpperCase();
	//}
	public int getAge(int age){
		return age;
	}
	
}
class Middleware{
	
	public static Object invokeMethod(String className,String methodName,Class []paramTypes,Object []params){
		try{
			Class cc=Class.forName(className);
			Object obj=cc.newInstance();
			Method mm=cc.getDeclaredMethod(methodName,paramTypes);
			return mm.invoke(obj,params);
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}	
}
public class ReflectMain{
	public static void main(String args[]){
		Class[] c = new Class[1];
        //c[0] = String.class;
		c[0]=int.class;
		//String capName=(String)Middleware.invokeMethod("NameTest","getCapitalName",c,new Object[]{"Hello"});
		int age=(int)Middleware.invokeMethod("NameTest","getAge",c,new Object[]{53});
		//System.out.println("Capital Name "+capName);
		System.out.println("Age "+age);
	}
}