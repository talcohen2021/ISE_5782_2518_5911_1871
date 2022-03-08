/**
 * 
 */
package unitTests;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;

/**
 * @author Meira
 *
 */
class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 * @throws Exception 
	 */
	@Test
	void testAddVector() throws Exception {
		Point p1 = new Point(1, 2, 3);
		assert(p1.add(new Vector(-1, -2, -3)).equals(new Point(0, 0, 0)));
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 * @throws Exception 
	 */
	@Test
	void testScale() throws Exception {
		Vector v = new Vector(1,1,1);
		Vector v1 = new Vector(2, 2, 2);
		assert(v.scale(2).equals(v1));
	}
		

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 * @throws Exception 
	 */
	@Test
	void testCrossProduct() throws Exception {
		Vector v1 = new Vector(1, 2, 3);
		Vector v3 = new Vector(0, 3, -2);
		//fail("Not yet implemented");
		Vector vr = v1.crossProduct(v3);
		assert(isZero(vr.length() - v1.length() * v3.length()));
		assert(isZero(vr.dotProduct(v1)) && isZero(vr.dotProduct(v3)));
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 * @throws Exception 
	 */
	@Test
	void testLengthSquared() throws Exception {
		assert(isZero(new Vector(1, 2, 3).lengthSquared() - 14));
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 * @throws Exception 
	 */
	@Test
	void testLength() throws Exception {
		assert(isZero(new Vector(0, 3, 4).length() - 5));
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 * @throws Exception 
	 */
	@Test
	void testNormalize() throws Exception {
		Vector v = new Vector(1, 2, 3);
		Vector u = v.normalize();
		assert(isZero(u.length() - 1));
	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 * @throws Exception 
	 */
	@Test
	void testDotProduct() throws Exception {
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(-2, -4, -6);
		Vector v3 = new Vector(0, 3, -2);
		assert(isZero(v1.dotProduct(v3)));
		assert(isZero(v1.dotProduct(v2) + 28));	
	}

}
