import java.util.*;

class DessertShop{
	private static List<Candy> candies=new ArrayList<Candy>();
	private static List<Cookie> cookies=new ArrayList<Cookie>();
	private static List<IceCream> iceCreams=new ArrayList<IceCream>();
	public static void addCandy(){
		candies.add(new Candy());
	}
	public static void addCookie(){
		cookies.add(new Cookie());
	}
	public static void addIceCream(){
		iceCreams.add(new IceCream());
	}
	public static void removeCandy(int count){
		if(candies.isEmpty()){
			System.out.println("Not Available");
		}else if(candies.size()>count){
			System.out.println("Not Sufficient Amount Available");
		}else{
			for(int i=1;i<=count;i++){
			candies.remove(candies.size()-1);
			}
		}
	}
	public static void removeCookie(){
		candies.remove(cookies.size()-1);
	}
	public static void removeIceCream(){
		candies.remove(iceCreams.size()-1);
	}
	
}
abstract class DessertItem{
	abstract double getCost(int count);
	double tax=0.0;
}
class Candy extends DessertItem{
	public double getCost(int count){
		return count*10*60;
	}
}
class Cookie extends DessertItem{
	public double getCost(int count){
		return count*7*70;
	}
}
class IceCream extends DessertItem{
	public double getCost(int count){
		return count*5;
	}
}
class DessertShopTest{
	public static void main(String args[]){
		System.out.println("Who are you?");
		System.out.println("1. Owner");
		System.out.println("2. Customer");
		Scanner sc=new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
			case 1:
					System.out.println("Select Item that you want to add");
					System.out.println("1. Candy");
					System.out.println("2. Cookie");
					System.out.println("3. IceCream");
					int ownerChoice1=sc.nextInt();
					System.out.println("Enter Count of Item");
					int ownerChoice2=sc.nextInt();
					switch(ownerChoice1){
						case 1:
								for(int i=1;i<=ownerChoice2;i++){
									DessertShop.addCandy();
								}
								break;
						case 2:
								for(int i=1;i<=ownerChoice2;i++){
									DessertShop.addCookie();
								}
								break;
						case 3:
								for(int i=1;i<=ownerChoice2;i++){
									DessertShop.addIceCream();
								}
								break;
						default:
								System.out.println("Invalid Choice");
								break;
					}
					break;
			case 2:
					System.out.println("Select Item that you want to add");
					System.out.println("1. Candy");
					System.out.println("2. Cookie");
					System.out.println("3. IceCream");
					int custChoice1=sc.nextInt();
					System.out.println("Enter Count of Item");
					int custChoice2=sc.nextInt();
					switch(custChoice1){
						case 1:
								
									DessertShop.removeCandy(custChoice2);
								
								break;
						case 2:
								for(int i=1;i<=custChoice2;i++){
									DessertShop.removeCookie();
								}
								break;
						case 3:
								for(int i=1;i<=custChoice2;i++){
									DessertShop.removeIceCream();
								}
								break;
						default:
								System.out.println("Invalid Choice");
								break;
					}
					break;
			
			default:
					System.out.println("Invalid Choice");
					break;
		}
	}
	
}