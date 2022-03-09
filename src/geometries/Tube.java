package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry{
	
	final Ray axisRay = null;
	final double radius = 0;
	
	
	public Ray getAxisRay()
	{
		return axisRay;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public Vector getNormal(Point point) {
		return null;
	}

}
