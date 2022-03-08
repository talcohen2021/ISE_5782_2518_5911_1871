/**
 * 
 */
package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point;

/**
 * @author Yaakovah
 *
 */
class PlaneTests {

	/**
	 * Test method for {@link geometries.Plane#getNormal(java.awt.Point)}.
	 */
	@Test
	void testGetNormalPoint() {
		//fail("Not yet implemented");
		Plane p = new Plane(new Point(1,1,1));
		assertEquals(p.getNormal(new Point(1,2,3)),1);
		
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(java.awt.Point, java.awt.Point, java.awt.Point)}.
	 */
	@Test
	void testGetNormalPointPointPoint() {
		//fail("Not yet implemented");
		
		// ============ Equivalence Partitions Tests ==============
		
		//Check that the plane’s vector is normalized (is of length 1)
		Plane p = new Plane(new Point(1,1,1), new Point(2,2,2), new Point(3,3,3));
		assertEquals(p.getNormal(new Point(1,2,3)),1);
	}
	
}
