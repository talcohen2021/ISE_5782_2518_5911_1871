package primitives;
//to do - function add/subtract, constructor, documentation, 
//questions - still need distance and distance squared?
import java.lang.Math;

public class Point {
	
	final Double3 xyz;

	/** Constructor to initialize Point based object with its Double3
	 * 
	 * @param double3 coordinate values
	 */
	protected Point(Double3 double3) {
		this.xyz = double3;
	}
	/**
	 * Constructor to initialize Point based object with its three number values
	 * 
	 * @param d1 first number value
	 * @param d2 second number value
	 * @param d3 third number value
	 */
	protected Point(double d1, double d2, double d3) {
		this.xyz(d1, d2, d3);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		return xyz.equals(obj);
	}
	
	
	@Override
	public String toString() {
		return xyz.toString();	
	}
	
	//@Override
	public Point add(Vector vector) {
		return new Point(this.xyz.add(vector.xyz));
		//to do
	}
	
	//@Override
	public Vector subtract(Point point) {
		return new Vector(this.xyz.subtract(vector.xyz));
		//to do
	}
	
	public double distanceSquared(Point point) {
		//x1-x2,y1-y2,1-z2 is the new double3
		Double3 temp1 = new Double3(this.xyz.subtract(point.xyz));
		//x*x,y*y,z*z using double3 product function
		Double3 temp2 = new Double3(temp1.product(temp1));
		//need to typecast from int to double?
		double temp3 = (double)temp2.hashCode();
		return temp3;
	}
	
	public double distance(Point point) {
		double temp1 = Math.sqrt(distanceSquared(point));
		return temp1;
	}
	
}
