package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * defined by a point and the orthogonal vector 
 */
public class Plane implements Geometry {
	
	final Point q0;
	final Vector normal;
	
	public Plane(Point q0, Point q1, Point q2) throws Exception
	{
		
		this.q0 = q0;
		
		Vector vector1 = q0.subtract(q1);
		Vector vector2 = q2.subtract(q1);
		Vector crossProduct = vector1.crossProduct(vector2);
		
		this.normal = crossProduct;
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
	public Vector getNormal(Point point) {
		
		return normal;
	}
	
	public Vector getNormal(Point point1, Point point2, Point point3) throws Exception {
		
		Vector vector1 = point1.subtract(point2);
		Vector vector2 = point3.subtract(point2);
		Vector crossProduct = vector1.crossProduct(vector2);
		
		return crossProduct;
	}
	
	@Override
	public String toString() {
		return "q0: " + q0.toString() + "normal: " + normal.toString();
	}



	@Override
	public List<Point> findIntsersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

}

