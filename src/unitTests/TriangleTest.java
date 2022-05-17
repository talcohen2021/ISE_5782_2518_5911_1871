/**
 * 
 */
package unitTests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import geometries.Triangle;
import primitives.*;

import geometries.Intersectable.GeoPoint;

/**
 * @author meira
 *
 */
public class TriangleTest {

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point)}.
	 */
	@Test
	public void testGetNormal() {
		fail("Not yet implemented");
	}
	
	/**
     * Test method for {@link geometries.Triangle#findIntersections(primitives.Ray)}.
	 * @throws Exception 
     */
    @Test 
    public void testFindIntersections() throws Exception {

    	GeoPoint predictedPoint;
        List<GeoPoint> result;
        Ray ray;
        Triangle triangle = new Triangle(new Point(10, 0, 0), new Point(0, 10, 0), new Point(0, 0, 10));
      
        
        // ============ Equivalence Partitions Tests ==============
    	//new error after changing to geopoint - need to discuss
    	//TC00: Ray intersects the triangle in the body
        ray = new Ray(new Point(1, 0, 0), new Vector(5, 5, 5));
        predictedPoint = new GeoPoint(triangle, new Point(4.003556313703255,3.0035563137032555,3.0035563137032555));
        result = triangle.findGeoIntersections(ray);
        assertEquals("Incorrect intersection point", predictedPoint, result.get(0));
        
    	//TC10: Ray does not intersect the triangle - intersects in the corner wedge
        ray = new Ray(new Point(0, 0, 9), new Vector(-2, -2, 10));
        result = triangle.findGeoIntersections(ray);
        assertNull("There should be no intersection points", result);
        
        //TC20: Ray does not intersect the triangle - intersects in the edge wedge
        ray = new Ray(new Point(-1, 0, 9), new Vector(-2, 6, 10));
        result = triangle.findGeoIntersections(ray);
        assertNull("There should be no intersection points", result);
        
        // =============== Boundary Values Tests ==================
      
		//TC30 Ray does not intersect the triangle. it intersects the extension of the edge of the triangle
        ray = new Ray(new Point(0, -20, 10), new Vector(0, 0, 10));
        result = triangle.findGeoIntersections(ray);
        assertNull("There should be no intersection points", result);
        
		//TC40 Ray intersects on the edge of the triangle - results in no intersection points
        ray = new Ray(new Point(5, 5, -1), new Vector(0, 0, 1));
        result = triangle.findGeoIntersections(ray);
        assertNull("There should be no intersection points", result);
        
		//TC50 Ray intersects on the corner of the triangle - results in no intersection points
        ray = new Ray(new Point(-0.15, -0.2, 9), new Vector(1.54, 2.04, 10));
        result = triangle.findGeoIntersections(ray);
        assertNull("There should be no intersection points", result);
	
    }


}
