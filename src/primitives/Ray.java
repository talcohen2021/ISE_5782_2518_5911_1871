package primitives;


/**
 * Class Ray is the basic class representing a Ray of Euclidean Geometry in Cartesian
 * 3-Dimensional coordinate system
 * @author Tali Cohen and Meira Grafstein and Yaakovah Bacharach
 */
public class Ray {
	
	final Point p0;
	final Vector dir;
	
	
	/** Constructor to initialize Ray object with a Point and a Vector
	 * 
	 * @param point coordinate value start of ray
	 * @param vector direction of ray (normalised)
	 */
	public Ray(Point point, Vector vector) {
		this.p0 = point;
		this.dir = vector.normalize();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Ray))
			return false;
		Ray other = (Ray) obj;
		return this.p0.equals(other.p0) && this.dir.equals(other.dir); 
	}
	
	@Override
	public String toString() {
		return p0.toString() + dir.toString();
	}

}
