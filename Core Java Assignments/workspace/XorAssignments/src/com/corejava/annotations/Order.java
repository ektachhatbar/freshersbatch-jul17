package com.corejava.annotations;

public class Order {

	Status orderStatus;
	int orderId;
	String orderName;
	int quantity;
	int price;
	
	public Order(Status orderStatus, int orderId, String orderName, int quantity, int price) {
		super();
		this.orderStatus = orderStatus;
		this.orderId = orderId;
		this.orderName = orderName;
		this.quantity = quantity;
		this.price = price;
	}

	public static void main(String[] args) {
		
		Order orderList[] = new Order[4];
		int i;
		
		orderList[0] = new Order(Status.NEW,21,"Candy",1,15);
		orderList[1] = new Order(Status.REJECTED,22,"Cookie",5,150);
		orderList[2] = new Order(Status.COMPLETED,23,"IceCream",11,30);
		orderList[3] = new Order(Status.ACCEPTED,24,"Chocolate",2,20);

		for(i=0;i<orderList.length;i++){
			System.out.println("Order Status no: "+orderList[i].orderStatus.getStatusNo()+", OrderId: "+orderList[i].orderId+", Order Name: "+orderList[i].orderName+", Order Quantity: "+orderList[i].quantity+", Order Price: "+orderList[i].price);
		}
	}

}
