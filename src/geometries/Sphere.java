package geometries;

import java.util.LinkedList;

import java.util.List;

import primitives.*;

public class Sphere extends Geometry {
	final Point centre;
	final double radius;
	
	public Sphere(Point p, double r) {
		this.centre = p;
		this.radius = r;
	}
	
	@Override
	public Vector getNormal(Point point) throws Exception {
		Vector v ;
		v = point.subtract(centre);
		return v.normalize();
		   
	}
	
	public Point getCentre() {
		return this.centre;
	}

	public double getRadius() {
		return this.radius;
	}

	/**
	 * @brief this function finds the intersections between a ray and a sphere
	 * per the slides from last semester
	 * @param the ray that is intersecting the sphere 
	 * @returns the list of intersections bw the ray and sphere if there are any
	 */
	@Override
	public List<Point> findIntersections(Ray ray) throws Exception {
		
		//u = O - P0
		Vector u = centre.subtract(ray.getP0());
		//tm = v*u
		double tm = ray.getDir().dotProduct(u);
		double dSquared = u.lengthSquared() - tm*tm;
		double d = Math.sqrt(dSquared);
		//if d>=r no intersections
		if (d >= radius)
			return null;
		double th = Math.sqrt(radius*radius - dSquared);
		double t1 = tm + th;
		double t2= tm - th;
		
		List<Point> results = new LinkedList<Point>();
		if(t1 <= 0 && t2 <= 0 ) {
			return null;
		}
		if(t1 > 0)
			results.add(ray.getP0().add(ray.getDir().scale(t1)));
		if(t2 > 0)
			results.add(ray.getP0().add(ray.getDir().scale(t2)));
		return results;
		
	}

}
