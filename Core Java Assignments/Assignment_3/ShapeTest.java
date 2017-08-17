abstract class Shape{
	abstract void draw();
}
class Point extends Shape{
	public void draw(){
		System.out.println("In Point");
	}
}
class Circle extends Point{
	public void draw(){
		System.out.println("In Circle");
	}
}
class Cylinder extends Circle{
	public void draw(){
		System.out.println("In Cylinder");
	}
}


class Line extends Shape{
	public void draw(){
		System.out.println("In Line");
	}
}
class Rectangle extends Line{
	public void draw(){
		System.out.println("In Rectangle");
	}
}
class Cube extends Rectangle{
	public void draw(){
		System.out.println("In Cube");
	}
}
class ShapeTest{
	public static void main(String args[]){
		Shape []shape=new Shape[6];
		shape[0]=new Point();
		shape[1]=new Circle();
		shape[2]=new Cylinder();
		shape[3]=new Line();
		shape[4]=new Rectangle();
		shape[5]=new Cube();
		for(int i=0;i<shape.length;i++){
			shape[i].draw();
		}
	}
}