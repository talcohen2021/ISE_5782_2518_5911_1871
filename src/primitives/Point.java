package primitives;

import java.lang.Math;
/**
 * Class Point is the basic class representing a point of Euclidean Geometry in Cartesian
 * 3-Dimensional coordinate system
 * @author Tali Cohen and Meira Grafstein and Yaakovah Bacharach
 */
public class Point {
	
	final Double3 xyz;

	/** Constructor to initialize Point based object with its Double3
	 * 
	 * @param double3 coordinate values
	 */
	public Point(Double3 double3) {
		this.xyz = double3;
	}
	/**
	 * Constructor to initialize Point based object with its three number values
	 * 
	 * @param d1 first number value
	 * @param d2 second number value
	 * @param d3 third number value
	 */
	public Point(double d1, double d2, double d3) {
		this.xyz = new Double3(d1, d2, d3);

	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		return xyz.equals(other.xyz);
	}
	
	
	@Override
	public String toString() {
		return xyz.toString();	
	}
	
	/**
	 * Sum two points into a new point 
	 * 
	 * @param vector right handle side operand for addition
	 * @return result of add
	 */
	public Point add(Vector vector) {
		return new Point(vector.xyz.add(this.xyz));
		
	}
	
	/**
	 * Subtract point from vector into a new vector 
	 * 
	 * @param point right hand side operand for subtraction
	 * @return result of substract
	 */
	public Vector subtract(Point point) {
		return new Vector(this.xyz.subtract(point.xyz));
		//to do
	}
	
	/**
	 * Method to assist in calculating the distance between two points
	 * d = ((x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2)^(1/2) 
	 * temp1 is the x2-x1 portion
	 * temp2 is the ()^2 portion
	 * temp3 is the addition
	 * @param point the point we are finding the distance to
	 */
	public double distanceSquared(Point point) {
		
		Point temp1 = new Point(this.xyz.subtract(point.xyz));
		//x*x,y*y,z*z using double3 product function
		Point temp2 = new Point(temp1.xyz.product(temp1.xyz));
		//need to typecast from int to double?
		//double temp3 = (double)temp2.hashCode();
		return (double) temp2.xyz.hashCode();
	}
	
	/**
	 * Method to calculate the distance between two points
	 * d = ((x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2)^(1/2) 
	 * temp1 is the ()^(1/2) portion
	 * @param point the point we are finding the distance to
	 */
	public double distance(Point point) {
		double temp1 = Math.sqrt(distanceSquared(point));
		return temp1;
	}
	
}
