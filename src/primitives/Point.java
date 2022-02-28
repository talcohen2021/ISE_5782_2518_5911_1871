package primitives;
//to do - function add/subtract, constructor, documentation, 
//questions - returning a vector? use of final - must make a new point/double3 when making changes?


public class Point {
	final Double3 xyz;

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
	public String toString() {return xyz.toString();}
	
	//@Override
	public Point add(Vector vector) {
		return null;
		//to do
	}
	
	//@Override
	public Vector subtract(Point point) {
		return null;
		//to do
	}
}
