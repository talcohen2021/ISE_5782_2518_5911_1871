/**
 * 
 */
package unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import geometries.Sphere;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Yaakovah
 *
 *
 */
class PlaneTests {

	/**
	 * Test method for {@link geometries.Plane#getNormal(java.awt.Point)}.
	 */
	@Test
	void testGetNormalPoint() {
		//fail("Not yet implemented");
		
		try {
		Plane p = new Plane(new Point(1,1,1), new Vector(5,5,5));
		assertEquals(p.getNormal(new Point(1,2,3)).length(),1);
		} catch(Exception e) {}
		
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(java.awt.Point, java.awt.Point, java.awt.Point)}.
	 * @throws Exception 
	 */
	@Test
	void testGetNormalPointPointPoint() throws Exception {
		//fail("Not yet implemented");
		
		// ============ Equivalence Partitions Tests ==============
		
		//Check that the plane’s vector is normalized (is of length 1)
		
		try {
			Plane p = new Plane(new Point(1,1,1), new Point(2,2,2), new Point(3,3,3));
			assertEquals(p.getNormal(new Point(1,2,3)).length(),1);
		} catch(Exception e) {}
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
        Plane plane = new Plane(new Point(0, 0, 10), new Point(10, 0, 0), new Point(0, 10, 0));
       
        
        // ============ Equivalence Partitions Tests ==============
    	
    	// TC01: Ray intersects the plane (The Ray must be neither orthogonal nor parallel to the plane)
        ray = new Ray(new Point(0, 0, 1), new Vector(0, 0, 1));
        predictedPoint = new Point(0, 0, 10);
        result = plane.findIntsersections(ray);
        assertEquals("Did not find the correct intersection point", predictedPoint, result.get(0));
        
    	//TC02: Ray does not intersect the plane (The Ray must be neither orthogonal nor parallel to the plane )
        ray = new Ray(new Point(0, 0, 11), new Vector(0, 0, 1));
        result = plane.findIntsersections(ray);
        assertNull("There should not be an intersection", result);

        // =============== Boundary Values Tests ==================
        
        
        //*** Ray is parallel to the plane - Two cases: 
        
        //TC10 the ray included in the plane
        ray = new Ray(new Point(0, 0, 10), new Vector(10, 0, 10));
        result = plane.findIntsersections(ray);
        assertNull("There should not be an intersection because the ray is inside the plane", result);
        
		// TC11 the ray is not included in the plane
        ray = new Ray(new Point(-1, 0, 0), new Vector(10, 0, 10));
        result = plane.findIntsersections(ray);
        assertNull("There should not be an intersection because the ray is parallel to the plane", result);
        
		//*** Ray is orthogonal to the plane - Three cases:
        
		//TC20 𝑃0 before the plane
        ray = new Ray(new Point(0, 0, 9), new Vector(-10, -10, -10));
        result = plane.findIntsersections(ray);
        assertEquals("There should not be an intersection.", result);
         
		//TC21 𝑃0 in the plane
        ray = new Ray(new Point(0, 0, 10), new Vector(-10, -10, -10));
        result = plane.findIntsersections(ray);
        assertNull("There should not be an intersection.", result);

		//TC22 𝑃0 after the plane :)
        ray = new Ray(new Point(0, 0, 11), new Vector(10, 10, 10));
        result = plane.findIntsersections(ray);
        assertNull("There should not be an intersection. Ray starts after the plane", result);

	
    }

	
}

