/**

 * 
 */
package unitTests.geometries;
import org.junit.Test;

import primitives.*;
import geometries.*;

/**
 * @author meira
 *
 */
public class CylinderTests {

	
	/**
	 * Test method for {@link geometries.Cylinder#getNormal(Point)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetNormal() throws Exception {
		//fail("Not yet implemented")

		// ============ Equivalence Partitions Tests ==============
		
		Cylinder c = new Cylinder(new Ray(new Point(0,0,0), new Vector(1,1,1)), 1,100);
		
		Vector v = new Vector(-1/Math.sqrt(2),-1/Math.sqrt(2),0);
		
		assert(v.equals(c.getNormal(new Point(0,0,1)))); //if this statement is true, it will pass the test
	
		
	}
	
	/**
	 * Test method for {@link geometries.Cylinder#getNormalBase()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetNormalBase() throws Exception {
		//fail("Not yet implemented")

		// ============ Equivalence Partitions Tests ==============
		
		Cylinder c = new Cylinder(new Ray(new Point(0,0,0), new Vector(1,1,1)), 1,100);
				
		Vector v = c.getNormalBase();
				
		assert(v.equals(c.getAxisRay().getDir().scale(-1)));
	
		
	}
	
	/**
	 * Test method for {@link geometries.Cylinder#getNormalTop()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetNormalTop() throws Exception {
		//fail("Not yet implemented")

		// ============ Equivalence Partitions Tests ==============
		
		Cylinder c = new Cylinder(new Ray(new Point(0,0,0), new Vector(1,1,1)), 1,100);
		
		Vector v = c.getNormalTop();
		
		assert(v.equals(c.getAxisRay().getDir()));
	
		
	}

}

/*For those who create a getNormal for finite cylinder – there are 3 equivalence tests (on the side and on each one of 
the bases) and two boundaries – the center of the bases. (There is no need to check points on the connection between bases 
and side of tube, since no points like this will be created in the findIntersections method).*/