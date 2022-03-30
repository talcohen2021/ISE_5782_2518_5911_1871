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
     * Test method for {@link geometries.Plane#findIntersections(primitives.Ray)}.
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
        expected = List.of(new GeoPoint(triangle, new Point3D(0.25, 0.25, 1)));
        actual = triangle.findGeoIntersections(ray1);
        assertEquals("has intersection failed", expected, actual);
        
    	//TC10: Ray does not intersect the triangle - intersects in the edge wedge
     
        //TC10: Ray does not intersect the triangle - intersects in the corner wedge
        
        // =============== Boundary Values Tests ==================
        
        
        //*** Ray is parallel to the plane - Two cases: 
        
       
		// TC11 the ray is not included in the plane
       
		//*** Ray is orthogonal to the plane - Three cases:
        
		//TC20 𝑃0 before the plane
        
		//TC21 𝑃0 in the plane
      
		//TC22 𝑃0 after the plane
      
	
    }


}
