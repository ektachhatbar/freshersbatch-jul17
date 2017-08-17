import java.lang.reflect.*;

class NameTest{
	public NameTest(String name){
		System.out.println(name);
	}
}
class MiddleWare{
	
	public void invokeMethod(String className,Class []paramTypes,Object []paramsvalues){
		try{
			Class c=Class.forName(className);
			Constructor con=c.getConstructor(paramTypes);
			Object obj=con.newInstance(paramsvalues);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}	
}
public class ConstructorReflectionTest{
	public static void main(String args[]){
		MiddleWare mw=new MiddleWare();
		Class paramtypes[] = new Class[1];
        paramtypes[0] = String.class;
		Object paramvalues[]=new Object[1];
        paramvalues[0]="hello";
		mw.invokeMethod(args[0],paramtypes,paramvalues);	
	}
}
