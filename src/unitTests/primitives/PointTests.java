/**
 * 
 */
package unitTests.primitives;
import primitives.Point;
import org.junit.Test;
import primitives.Vector;
import static org.junit.jupiter.api.Assertions.*;


//import org.junit.jupiter.api.Test;

/**
 * @author Merekat
 *
 */
public class PointTests {

	/**
	 * Test method for {@link primitives.Point#add(primitives.Vector)}.
	 * @throws Exception 
	 */
	@Test
	public void testAdd() throws Exception {
		//fail("Not yet implemented");
		Point p = new Point(1,2,3);
		assert(p.add(new Vector(-1, -2, -3)).equals(new Point(0, 0, 0)));	
	}

	/**
	 * Test method for {@link primitives.Point#subtract(primitives.Point)}.
	 * @throws Exception 
	 */
	@Test
	public void testSubtract() throws Exception {
		//fail("Not yet implemented");
		Point p = new Point(1,2,3);
		assert(new Vector(1, 1, 1).equals(new Point(2, 3, 4).subtract(p)));
	}

	/**
	 * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}.
	 */
	@Test
	public void testDistanceSquared() {
		//fail("Not yet implemented");
		Point p = new Point(1,2,3);
		assertEquals(p.distanceSquared(new Point(1,2,3)),0);
		assertEquals(p.distanceSquared(new Point(3,6,7)),36);
	}

	/**
	 * Test method for {@link primitives.Point#distance(primitives.Point)}.
	 */
	@Test
	public void testDistance() {
		//fail("Not yet implemented");
		Point p = new Point(1,2,3);
		assertEquals(p.distance(new Point(1,2,3)),0);
		assertEquals(p.distance(new Point(3,6,7)),6);
	}

}
