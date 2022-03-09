/**
 * 
 */
package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Sphere;
import primitives.Point;
import primitives.Vector;

/**
 * @author Merekat
 *
 */
class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(Point)}.
	 * @throws Exception 
	 */
	@Test
	void testGetNormal() throws Exception {
		//fail("Not yet implemented");
		// ============ Equivalence Partitions Test ==============
		
		Sphere s = new Sphere(new Point(0,0,0), 6);
		assertEquals(s.getNormal(new Point(2,4,4)), new Vector(1/3, 2/3, 2/3));
		  
		 
		
	}

}
