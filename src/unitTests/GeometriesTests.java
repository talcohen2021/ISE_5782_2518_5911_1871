/**
 * 
 */
package unitTests;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.*;
import primitives.*;
//testing(3/4/22)
/**
 * @author Yaakovah
 *
 */
class GeometriesTests {

	

	@Test
	void testfindIntersections() throws Exception {
		List<Point> result;
		Geometries intersectables = new Geometries();
		
		// =============== Boundary Values Tests ==================
		//an empty collection (BVA)
		Ray ray = new Ray(new Point(20, 20, 20), new Vector(0, 0, 2));
		result = intersectables.findIntsersections(ray);
		assertNull("There should be no intersection - the scene is empty", result);
		
		//no ray intersects with a geometry (BVA)
		 Sphere sphere = new Sphere(new Point(1, 0, 0), 1d);
		 Triangle triangle = new Triangle(new Point(10, 0, 0), new Point(0, 10, 0), new Point(0, 0, 10));
		 intersectables.add(triangle);
		 intersectables.add(sphere);
		 result = intersectables.findIntsersections(ray);
		 assertNull("There should be no intersection", result);
		 
		//only one shape intersects (BVA)
		 ray = new Ray(new Point(0,0,1), new Vector(2,5,6));
		 result = intersectables.findIntsersections(ray);
		 assertEquals("there should only be one intersection. Ray with triangle", result.size(), 1);
		 
		//all shapes intersects (BVA)
		 ray = new Ray(new Point(-12.52,-5.09,-10.63), new Vector(23.76, 9.7, 18.37));
		 result = intersectables.findIntsersections(ray);
		 assertEquals("there should be three intersections. two with sphere and one with triangle", result.size(), 3);
		
		 // ============ Equivalence Partitions Tests ==============
         // some shapes but not all intersects (EP)
		 ray = new Ray(new Point(0,0,1), new Vector(2,5,6));
		 result = intersectables.findIntsersections(ray);
		 assertEquals("there should only be one intersection. Ray with triangle", result.size(), 1);
		 
	}
	
}
