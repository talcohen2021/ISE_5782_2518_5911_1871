/**
 * 
 */
package unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import geometries.Triangle;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * @author meira
 *
 */
class TriangleTest {

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		fail("Not yet implemented");
	}
	
	/**
     * Test method for {@link geometries.Triangle#findIntersections(primitives.Ray)}.
	 * @throws Exception 
     */
    @Test 
    public void testFindIntersections() throws Exception {

    	Point predictedPoint;
        List<Point> result;
        Ray ray;
        Triangle triangle = new Triangle(new Point(10, 0, 0), new Point(0, 10, 0), new Point(0, 0, 10));
      
        
        // ============ Equivalence Partitions Tests ==============
    	
    	//TC00: Ray intersects the triangle in the body
        ray = new Ray(new Point(0, 0, 9), new Vector(0, 0, 10));
        predictedPoint = new Point(0, 0, 10);
        result = triangle.findIntsersections(ray);
        assertEquals("Incorrect intersection point", predictedPoint, result.get(0));
        
    	//TC10: Ray does not intersect the triangle - intersects in the edge wedge
        ray = new Ray(new Point(0, 0, 9), new Vector(0, -1, 10));
        result = triangle.findIntsersections(ray);
        assertNull("There should be no intersection points", result);
        
        //TC20: Ray does not intersect the triangle - intersects in the corner wedge
        //didnt calculate this one
        ray = new Ray(new Point(0, 0, 9), new Vector(0, -1, 10));
        result = triangle.findIntsersections(ray);
        assertNull("There should be no intersection points", result);
        
        // =============== Boundary Values Tests ==================
      
		//TC30 Ray does not intersect the triangle. it intersects the line that the edge of the triangle is on
        //didnt calculate this point
        ray = new Ray(new Point(0, -20, 10), new Vector(0, 0, 10));
        result = triangle.findIntsersections(ray);
        assertNull("There should be no intersection points", result);
        
		//TC40 Ray intersects on the edge of the triangle - results in no intersection points
        //didnt calculate this point
        ray = new Ray(new Point(0, 0, 9), new Vector(0, -1, 10));
        result = triangle.findIntsersections(ray);
        assertNull("There should be no intersection points", result);
        
		//TC50 Ray intersects on the corner of the triangle - results in no intersection points
        ray = new Ray(new Point(0, 0, 9), new Vector(0, 0, 9));
        result = triangle.findIntsersections(ray);
        assertNull("There should be no intersection points", result);
	
    }


}
