/**
 * 
 */
package unitTests;
import primitives.Point;
import primitives.Vector;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

/**
 * @author Merekat
 *
 */
class PointTests {

	/**
	 * Test method for {@link primitives.Point#add(primitives.Vector)}.
	 * @throws Exception 
	 */
	@Test
	void testAdd() throws Exception {
		//fail("Not yet implemented");
		Point p = new Point(1,2,3);
		assert(p.add(new Vector(-1, -2, -3)).equals(new Point(0, 0, 0)));	
	}

	/**
	 * Test method for {@link primitives.Point#subtract(primitives.Point)}.
	 * @throws Exception 
	 */
	@Test
	void testSubtract() throws Exception {
		//fail("Not yet implemented");
		Point p = new Point(1,2,3);
		assert(new Vector(1, 1, 1).equals(new Point(2, 3, 4).subtract(p)));
	}

	/**
	 * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}.
	 */
	@Test
	void testDistanceSquared() {
		//fail("Not yet implemented");
		Point p = new Point(1,2,3);
		assertEquals(p.distanceSquared(new Point(1,2,3)),0);
		assertEquals(p.distanceSquared(new Point(3,6,7)),36);
	}

	/**
	 * Test method for {@link primitives.Point#distance(primitives.Point)}.
	 */
	@Test
	void testDistance() {
		//fail("Not yet implemented");
		Point p = new Point(1,2,3);
		assertEquals(p.distance(new Point(1,2,3)),0);
		assertEquals(p.distance(new Point(3,6,7)),6);
	}

}
