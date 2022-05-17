package geometries;

import java.util.LinkedList;
import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Class Triangle is the class representing a Triangle in Euclidean Geometry in Cartesian
 * 3-Dimensional coordinate system
 * @author Tali Cohen and Meira Grafstein and Yaakovah Bacharach
 */
public class Triangle extends Polygon{
	/**
	 * Constructor to initialize Triangle object with its three number values
	 * 
	 * @param p1 first coordinate value
	 * @param p2 second coordinate value
	 * @param p3 third coordinate value
	 * @throws Exception 
	 */
	public Triangle(Point p1, Point p2, Point p3) throws Exception {
		super(p1, p2, p3);
	}

	
	@Override
	public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) throws Exception {
		try {
			 List<GeoPoint> intersections = plane.findGeoIntersections(ray);
			    if (intersections == null)
			      return null;
			//v1 = vector(p1-p0)
			Vector v1 = vertices.get(0).subtract(ray.getP0());
			//v2 = vector(p2-p0)
			Vector v2 = vertices.get(1).subtract(ray.getP0());
			//v3 = vector(p3-p0)
			Vector v3 = vertices.get(2).subtract(ray.getP0());
			
			//n1 = normalize(v1crossv2)
			Vector n1 = v1.crossProduct(v2).normalize();
			// n2 = normalize(v2 cross v3
			Vector n2 = v2.crossProduct(v3).normalize();
			//n3 = normalize(v3 cross v1)
			Vector n3 = v3.crossProduct(v1).normalize();
			
			// if all v dot ni are + or -
			double vn1 = ray.getDir().dotProduct(n1);
			double vn2 = ray.getDir().dotProduct(n2);
			double vn3 = ray.getDir().dotProduct(n3);
			
			if((vn1 > 0 && vn2 > 0 && vn3 > 0) ||(vn1 < 0 && vn2 < 0 && vn3 < 0))
				return intersections;
		 }
		 catch(Exception e) {
			 System.out.print(e);
		 }
		 
		return null;
		
}


	public Intersectable setEmission(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

}
