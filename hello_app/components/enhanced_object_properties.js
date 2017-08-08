export function testEnhancedObjectProperties(){
    var Order={id:100,title:'Bike Purchase',price:50000,printOrder(){console.log("Order details : ",Order);},getPrice(){console.log("Price : ",this.price);}};
    Order.printOrder();
    Order.getPrice();
    var copy={};
    Object.assign(copy,Order);
    console.log("CopyObject : ",copy);
}