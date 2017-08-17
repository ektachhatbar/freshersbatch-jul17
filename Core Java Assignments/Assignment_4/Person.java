import java.util.*;

public class Person implements Comparable<Person>{
	
	int height;
	int weight;
	String name;
	
	Person(int height, int weight, String name) {
			this.height = height;
			this.weight = weight;
			this.name = name;
	}
	public int compareTo(Person p2){  
		if(this.weight==p2.weight)  
			return 0;  
		else if(this.weight>p2.weight)  
			return 1;  
		else  
			return -1;  
	}  
	public void print() {
		System.out.println("Height "+this.height+" weight "+this.weight+" name "+this.name);
	}
	static void printAll(Person p[]) {
		for(int i=0; i< p.length; i++) {
			p[i].print();
		}
	}
	public static void main(String args[]) {
			Person p[]=new Person[2];
			p[0] = new Person(13, 70, "Tom");
			p[1] = new Person(4, 150, "Sia");
			System.out.println("Given Data : ");
			printAll(p);
			System.out.println();
			System.out.println("Name Sort using Comparator : ");
			Arrays.sort(p, new NameComparator());
			printAll(p);
			System.out.println();
			System.out.println("Height Sort using Comparator : ");
			Arrays.sort(p, new HeightComparator());
			printAll(p);
			System.out.println();
			System.out.println("Weight Sort using Comparable: ");
			Arrays.sort(p);
			printAll(p);
	}
	
}
class HeightComparator implements Comparator<Person> {
	public int compare(Person o1, Person o2) {
		if(o1.height== o2.height)
			return 0;
		else if(o1.height > o2.height)
			return 1;
		else
			return -1;
	}
}
class NameComparator implements Comparator<Person> {
	public int compare(Person o1, Person o2) {
		if(o1.name.compareTo(o2.name)==0)
			return 0;
		else if(o1.name.compareTo(o2.name)>0)
			return 1;
		else
			return -1;
	}
}
