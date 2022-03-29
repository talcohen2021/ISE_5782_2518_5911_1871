package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

//?import primitives;
public interface Geometry extends Intersectable{
	
	/**
	 * @param Point point on the geometry
	 * @return The vector that is perpendicular to the geometry starting at the point
	 * @throws Exception 
	 */
	public Vector getNormal(Point p) throws Exception;

	
	
}
