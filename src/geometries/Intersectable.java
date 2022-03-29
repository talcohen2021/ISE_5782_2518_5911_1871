package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;

/**
 * @author Yaakovah
 *
 */
public interface Intersectable {

	/**
	 * 
	 * @param ray - a ray that may or may not intersect with the geometry. 
	 * @return - a list of all of the points of intersection or null (in the case that there is no intersection points)
	 * @throws Exception 
	 */
	List<Point> findIntsersections(Ray ray) throws Exception;
}
