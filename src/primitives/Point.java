package primitives;
//to do - function add/subtract, constructor, documentation, 
//questions - still need distance and distance squared?


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
}
