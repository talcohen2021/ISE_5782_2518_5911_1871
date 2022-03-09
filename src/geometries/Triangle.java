package geometries;

import primitives.Point;

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
	 */
	protected Triangle(Point p1, Point p2, Point p3) {
		super(p1, p2, p3);
	}

}
