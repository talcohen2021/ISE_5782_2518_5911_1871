package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * defined by a point and the orthogonal vector 
 */
public class Plane implements Geometry {
	
	final Point q0;
	final Vector normal;
	
	Plane(Point q0, Point q1, Point q2) throws Exception
	{
		
		this.q0 = q0;
		
		Vector vector1 = q0.subtract(q1);
		Vector vector2 = q2.subtract(q1);
		Vector crossProduct = vector1.crossProduct(vector2);
		
		this.normal = crossProduct;
	}
	
	
	Plane(Point q0, Vector normal) throws Exception
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

}

