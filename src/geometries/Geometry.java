package geometries;

import primitives.Point;

import primitives.Vector;

//?import primitives;
public interface Geometry {
	
	/**
	 * @param Point point on the geometry
	 * @return The vector that is perpendicular to the geometry starting at the point
	 */
	public Vector getNormal(Point p);
	
}
