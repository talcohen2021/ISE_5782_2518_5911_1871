package primitives;



public class Vector extends Point {
	
	/**
	 * constructor using double3
	 */
	public Vector(Double3 number) {
		super(number);
	}
	
	/**
	 * constructor using three doubles
	 */
	public Vector(double num1, double num2, double num3) {
		super(num1, num2, num3);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Vector))
			return false;
		Vector other = (Vector) obj;
		return this.equals(obj);
	
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	/**
	 * add two vectors
	 * @param vector is the vector we're adding to this
	 */
	@Override
	public Vector add(Vector vector) {
		return super.add(vector);
	}
	
	/**
	 * multiply this vector by a scalar using the scale function of double3
	 * @param num is the number were scaling our vector by
	 */
	public Vector scale(double num) {
		return this.xyz.scale(num);
		
	}
	
	/**
	 * do the cross product of two vectors
	 * @param vector is the vector that we're multiplying this with
	 */
	public Vector crossProduct(Vector vector) {
		return vector;
		//to do
	}

	
	/**
	 * returns the length squared of a vector, using the distance squared method of point
	 * and plugging in the origin
	 */
	public double lengthSquared() {
		return super.distanceSquared(new Point(0,0,0));
	}
	
	
	/**
	 * returns the length of a vector using the distance method in point
	 * and plugging in the origin
	 */
	public double length() {
		return super.distance(new Point(0,0,0));
	}
	
	/**
	 * method to normalize a vector
	 */
	public Vector normalize() {
		Vector v = new Vector();
		len = this.length();
		if(len == 1)
			return this;
		v.xyz = v.xyz.reduce(len);
		return v;
		
	}
	
	/**
	 * method to calculate the dot product of two vectors
	 * @param vector is the vector we're multiplying this with
	 * using methods from double3
	 */
	public double dotProduct(Vector vector) {
		Point temp = new Point( this.xyz.product(vector.xyz));
		return (double) temp.xyz.hashCode();
		
	}
	
}
