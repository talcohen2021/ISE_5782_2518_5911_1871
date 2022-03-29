package geometries;

import java.util.LinkedList;
import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Sphere implements Geometry {
	final Point centre;
	final double radius;
	
	public Sphere(Point p, double r) {
		this.centre = p;
		this.radius = r;
	}
	
	@Override
	public Vector getNormal(Point point) throws Exception {
		//return null; 
		Vector v ;
		v = point.subtract(centre);
		Vector u = v.normalize();
		return u;
		   
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
	public List<Point> findIntsersections(Ray ray) throws Exception {
		
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
		
		if(t1 > 0)
			results.add(ray.getP0().add(ray.getDir().scale(t1)));
		if(t2 > 0)
			results.add(ray.getP0().add(ray.getDir().scale(t2)));
		return results;
		
	}

}
