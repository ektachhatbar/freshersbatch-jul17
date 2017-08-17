abstract class Persistence{
	abstract void persist();
}
class FilePersistence extends Persistence{
	public void persist(){
		System.out.println("In FilePersistence");
	}
}
class DataBasePersistence extends Persistence{
	public void persist(){
		System.out.println("In DataBasePersistence");
	}
}
class PersistenceFactory{
	public static DataBasePersistence getPersistence(){
		return new DataBasePersistence();
	}
}
class PersistenceTest{
	public static void main(String args[]){
		Persistence p=PersistenceFactory.getPersistence();
		p.persist();
	}
}