/**
 * 
 */
package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.Point;
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
	
}
