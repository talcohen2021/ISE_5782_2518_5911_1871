package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

import geometries.*;
import primitives.*;
import renderer.Camera;

import geometries.Intersectable.GeoPoint;

public class CameraIntegrationTests {
	
	public void cameraSetUp (Camera cam, double dist, double width, double height) {
		cam.setVPDistance(dist);
		cam.setVPSize(width, height);
	}
	
	/**
	 * @param cam the camera
	 * @param geometry the geometry we're intersecting
	 * @return the number of intersections between the cameras rays of a 3x3 view plane
	 *  and the geometry
	 * @throws Exception 
	 */
	public int intersectionCalculator(Camera cam, Geometry geometry) throws Exception {
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Ray ray = cam.constructRay(3, 3, j, i);
				List<GeoPoint> intersections = geometry.findGeoIntersections(ray);
				if(intersections != null) {
					count += intersections.size();
				}
			}
		}
	return count;
	}


	@Test
	public void sphereIntegrationTest() throws Exception {
		//orig
		//Camera cam = new Camera(new Point(Double3.ZERO), new Vector(0,1,0), new Vector(0,0,-1));
		//cameraSetUp(cam, 1, 3, 3);
		/*---- sphere tests------*/
		
		//orig (switched vtoandup
		Camera cam = new Camera(new Point(Double3.ZERO), new Vector(0,0,-1), new Vector(0,1,0));
		cameraSetUp(cam, 1, 3, 3);
		/*---- sphere tests------*/
		
		Sphere sphere = new Sphere(new Point(0,0,-3), 1);
		
		//tc 1
		assertEquals("there should be 2 intersections ", intersectionCalculator(cam, sphere), 2);
	
		//tc 2
		sphere = new Sphere(new Point(0,0,-2.5), 2.5);
		cam.setP0(new Point(0,0,0.5));
		assertEquals("there should be 18 intersections", intersectionCalculator(cam, sphere), 18);
		
		//tc 3
		sphere = new Sphere(new Point(0,0,-2), 2);
		assertEquals("there should be 10 intersections", intersectionCalculator(cam, sphere), 10);
		
		//tc 4 
		sphere = new Sphere(new Point(0,0,-1), 4);
		assertEquals("there should be 9 intersections ", intersectionCalculator(cam, sphere), 9);
		
		//tc 5
		sphere = new Sphere(new Point(0,0,1), 0.5);
		cam.setP0(new Point(Double3.ZERO));
		assertEquals("there should be 0 intersections ", intersectionCalculator(cam, sphere), 0);
		
		
	}
	
	@Test
	public void planeIntegrationTest() throws Exception {
		Camera cam = new Camera(new Point(Double3.ZERO), new Vector(0,0, -1), new Vector(0,-1, 0));
		cameraSetUp(cam, 1, 3, 3);
		
		//tc 1 //running test changed 9 to 8 to compare output got : there should be 9 intersections a expected:<9> but was:<8>
		Plane plane = new Plane(new Point(0,0,-10), new Vector(0,0,1));
		assertEquals("there should be 9 intersections a", intersectionCalculator(cam, plane), 9);
		
		//tc 2  //this test is failing  there should be 9 intersections b expected:<6> but was:<9>
		//orig : 
		plane = new Plane(new Point(0,0,-5), new Vector(0,1, 2));  
		assertEquals("there should be 9 intersections b", intersectionCalculator(cam, plane), 9);
		
		//tc 3 //this test is failing  there should be 6 intersections expected:<4> but was:<6>
		plane = new Plane(new Point(0,0,-5), new Vector(0,1,1)); 
		assertEquals("there should be 6 intersections ", intersectionCalculator(cam, plane), 6);
		
	}
	
/*	
	@Test
	public void triangleIntegrationTest() throws Exception {
		
		Camera cam = new Camera(new Point(Double3.ZERO), new Vector(0,1,0), new Vector(0,0,-1));
		cameraSetUp(cam, 1, 3, 3);
		
		//tc 1
		Triangle triangle = new Triangle(new Point(0,1,-2), new Point(1,-1,-2), new Point(-1,-1,-2));
		assertEquals("there should be 1 intersection ", intersectionCalculator(cam, triangle), 1);
		
		
		//tc 2
		triangle = new Triangle(new Point(0,20,-2), new Point(1,-1,-2), new Point(-1,-1,-2));
		assertEquals("there should be 2 intersections ", intersectionCalculator(cam, triangle), 2);
	}
*/	
//*/
}
