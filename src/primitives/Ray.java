package primitives;

import java.util.List;

import geometries.Plane;

import geometries.Intersectable.GeoPoint;

/**
 * Class Ray is the basic class representing a Ray of Euclidean Geometry in Cartesian
 * 3-Dimensional coordinate system
 * @author Tali Cohen and Meira Grafstein and Yaakovah Bacharach 
 */
public class Ray {
	
	final Point p0;
	final Vector dir; //
	
	
	/** Constructor to initialize Ray object with a Point and a Vector
	 * 
	 * @param point coordinate value start of ray
	 * @param vector direction of ray (normalised)
	 * @throws Exception 
	 */
	public Ray(Point point, Vector vector) throws Exception {
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
	
	public Point getP0() {
		return this.p0;
	}
	
	public Vector getDir() {
		return this.dir;
	}
	
	public Point getPoint(double t) throws Exception {
		// P=P_0+t∙v
		return p0.add(dir.scale(t));
	}
	
	/** 
	 * 
	 * @param points - list of points
	 * @return closest point to the ray’s head
	 * @throws Exception 
	 */
	public Point findClosestPoint(List<Point> points) throws Exception {
	    return points == null || points.isEmpty() ? null
	           : findClosestGeoPoint(points.stream().map(p -> new GeoPoint(null, p)).toList()).point;
	} 

	/** 
	 * 
	 * @param points - list of Geopoints
	 * @return closest GeoPoint to the ray’s head
	 * @throws Exception 
	 */
	public GeoPoint findClosestGeoPoint(List<GeoPoint> points) throws Exception{
		
		double smallestDistance = Double.MAX_VALUE;
		GeoPoint closestGeoPoint = new GeoPoint(new Plane(new Point(0,0,0), new Vector(1,1,1)), new Point(1, 1, 1));
		
		for(GeoPoint p : points) {
			double tempDistance = this.p0.distance(p.point);
			if(tempDistance < smallestDistance) {
				smallestDistance = tempDistance;
				closestGeoPoint = p;
			}
		}
		
		return closestGeoPoint;
	}
	
}
