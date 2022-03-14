/**
 * 
 */
package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Polygon;
import geometries.Tube;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Yaakovah
 *
 */
class TubeTests {
	
	/**
	 * Test method for {@link geometries.Tube#Tube(...)}.
	 */
	@Test
	public void testConstructor() throws Exception {
	
		// =============== Boundary Values Tests ==================
		//radius: does not equal 0


		Tube t = new Tube(new Ray(new Point(0,0,0), new Vector(1,1,1)), 0);
		assertNotEquals(t.getRadius(), 0, "bad radius for tube");
	}

	/**
	 * Test method for {@link geometries.Tube#getNormal(Point)}.
	 * @throws Exception 
	 */
	@Test
	void testGetNormal() throws Exception {
		fail("Not yet implemented");
		
		// ============ Equivalence Partitions Tests ==============
		// connection between the point on the body and the ray’s head creates a 90 degrees with the ray

		Tube t = new Tube(new Ray(new Point(0,0,0), new Vector(1,1,1)), 1);
		double lengthV = t.getAxisRay().getDir().length();
		double lengthNormal = t.getNormal(new Point(0,0,1)).length();
		assertEquals(lengthV*lengthNormal, t.getAxisRay().getDir().crossProduct(new Point(0,0,1).subtract(t.getAxisRay().getP0())), "Bad normal to tube");
	
	}

}

