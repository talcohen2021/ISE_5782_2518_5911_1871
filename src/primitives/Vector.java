package primitives;



public class Vector extends Point {
	
	/**
	 * constructor using double3
	 * @throws Exception 
	 */
	public Vector(Double3 number) throws Exception {
		super(number);
		if(number == Double3.ZERO)
			throw new IllegalArgumentException("Cannot have zero vector");
		
		
	}
	
	/**
	 * constructor using three doubles
	 */
	public Vector(double num1, double num2, double num3) throws Exception{
		super(num1, num2, num3);
		if(num1 == 0 && num2 == 0 && num3 == 0)
			throw new IllegalArgumentException("Cannot have zero vector");
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Vector))
			return false;
		Vector other = (Vector) obj;
		return super.equals(other);
	
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
		return (Vector) super.add(vector);
	}
	
	/**
	 * multiply this vector by a scalar using the scale function of double3
	 * @param num is the number were scaling our vector by
	 * @throws Exception 
	 */
	public Vector scale(double num) throws Exception {
		return new Vector(this.xyz.scale(num));
		
	}
	
	/**
	 * do the cross product of two vectors
	 * @param vector is the vector that we're multiplying this with
	 * @throws Exception 
	 */
	public Vector crossProduct(Vector vector) throws Exception {
		Double3 A = this.xyz;
		Double3 B = vector.xyz;
		double num1 = A.d2 * B.d3 - A.d3 * B.d2;
		double num2 = A.d3 * B.d1 - A.d1 * B.d3;
		double num3 = A.d1 * B.d2 - A.d2 * B.d1;
		return new Vector(num1, num2, num3);
		
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
	 * @throws Exception 
	 */
	public Vector normalize() throws Exception {
		//Point p = new Point(this.xyz);
		double len = this.length();
		if(len == 1)
			return this;
		Vector v = new Vector(this.xyz.reduce(len));
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
