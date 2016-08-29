package uva477;

import java.util.ArrayList;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<shape> shapes = new ArrayList<>();
		String s = scanner.next();
		while(!s.equals("*")){
			if(s.equals("r")){
				shapes.add(new rectangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
			}
			else if(s.equals("c")){
				shapes.add(new circle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
			}
			s = scanner.next();
		}
		double x = scanner.nextDouble();
		double y = scanner.nextDouble();
		int count = 0;
		while( x != 9999.9 || y != 9999.9){
			count++;
			Point point = new Point(x, y);
			boolean flag = false;
			for(int i = 0; i < shapes.size(); i++){
				if(shapes.get(i).inRange(point)){
					flag = true;
					System.out.println("Point " + count + " is contained in figure " + (i + 1));
				}
			}
			if(!flag){
				System.out.println("Point " + count + " is not contained in any figure");
			}
			x = scanner.nextDouble();
			y = scanner.nextDouble();
		}
		scanner.close();
	}

}

class Point{
	public double x;
	public double y;
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
}

class shape{
	boolean inRange(Point point){
		return true;
	}
}

class circle extends shape{
	public Point center;
	public double radius;
	public circle(double x, double y, double r){
		center = new Point(x, y);
		this.radius = r;
	}
	
	boolean inRange(Point point){
		return ((point.x - center.x) * (point.x - center.x) + (point.y - center.y) * (point.y - center.y)) < (radius * radius);
	}
}

class rectangle extends shape{
	public double left;
	public double right;
	public double up;
	public double low;
	public rectangle(double left, double up, double right, double low) {
		super();
		this.left = left;
		this.right = right;
		this.up = up;
		this.low = low;
	}
	
	boolean inRange(Point point){
		return point.x > left && point.x < right && point.y > low && point.y < up;
	}
	
	
}
