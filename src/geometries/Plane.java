package geometries;

import java.util.ArrayList;



import java.util.LinkedList;
import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * defined by a point and the orthogonal vector 
 */
public class Plane extends Geometry {
	
	final Point q0;
	final Vector normal;
	
	public Plane(Point q0, Point q1, Point q2) throws Exception
	{
		
		this.q0 = q0;
		
		Vector vector1 = q0.subtract(q1);
		Vector vector2 = q2.subtract(q1);
		//Vector crossProduct = vector1.crossProduct(vector2);
		Vector crossProduct = vector2.crossProduct(vector1);
		
		this.normal = crossProduct.normalize();
	}
	
	
	
	public Plane(Point q0, Vector normal) throws Exception
	{
		this.q0 = q0;
		this.normal = normal.normalize();
	}
	
	public Point getPoint()
	{
		return q0;
	}

	@Override
	public Vector getNormal(Point point) throws Exception {
		
		return normal.normalize();
	}
	
//	public Vector getNormal() {
		
	//	return normal;
	//}
	public Vector getNormal(Point point1, Point point2, Point point3) throws Exception {
		
		Vector vector1 = point1.subtract(point2);
		Vector vector2 = point3.subtract(point2);
		Vector crossProduct = vector1.crossProduct(vector2);
		
		return crossProduct.normalize();
	}
	
	@Override
	public String toString() {
		return "q0: " + q0.toString() + "normal: " + normal.toString();
	}



	@Override
	public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) throws Exception {
		List<GeoPoint> results = new LinkedList<GeoPoint>(); //bc mainly adding
		Vector u = q0.subtract(ray.getP0());
		//Vector u = ray.getP0().subtract(q0);
		//(normal*u)/(normal*v)
		double t = (normal.dotProduct(u)) / (normal.dotProduct(ray.getDir()));
		//p = p0+tv
		if(t > 0 && !Double.isInfinite(t)) {
			results.add(new GeoPoint(this, ray.getPoint(t)));
			return results;
		}
		return null;
	}

}

