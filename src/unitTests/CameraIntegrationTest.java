package unitTests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Intersectable;
import geometries.Sphere;
import primitives.*;
import renderer.Camera;

class CameraIntegrationTest {
	
	public void cameraSetUp (Camera cam, double dist, double width, double height) {
		cam.setVPDistance(dist);
		cam.setVPSize(width, height);
	}
	/**
	 * 
	 * @param cam the camera
	 * @param geometry the geometry we're intersecting
	 * @return the number of intersections between the cameras rays and the geometry
	 * @throws Exception 
	 */
	public int intersectionCalculator(Camera cam, Intersectable geometry) throws Exception {
		int count = 0;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; j++) {
				Ray ray = cam.constructRay(3, 3, j, i);
				List<Point> intersections = geometry.findIntsersections(ray);
				count += intersections.size();
			}
		}
	return count;
	}
	
	//public void helperIntersection()

	@Test
	void integrationTest() throws Exception {
		Camera cam = new Camera(new Point(Double3.ZERO), new Vector(0,1,0), new Vector(0,0,-1));
		cameraSetUp(cam, 1, 3, 3);
		
		/*---- sphere tests------*/
		Sphere sphere = new Sphere(new Point(0,0,-3), 1);
		//tc 0 
		assertEquals("there should be 2 intersections ", intersectionCalculator(cam, sphere), 2);
	
		sphere = new Sphere(new Point(0,0,-2.5), 2.5);
		cam.setP0(new Point(0,0,0.5));
		
		//tc 1
		assertEquals("there should be 18 intersections", intersectionCalculator(cam, sphere), 18);
		
		//tc 3
		sphere = new Sphere(new Point(0,0,-2), 2);
		assertEquals("there should be 10 intersections", intersectionCalculator(cam, sphere), 10);
		
		//tc 4 
		sphere = new Sphere(new Point(0,0,-1), 4);
		assertEquals("there should be 9 intersections ", intersectionCalculator(cam, sphere), 9);
		
		//tc 5
		sphere = new Sphere(new Point(0,0,1), 0.5);
		assertEquals("there should be 0 intersections ", intersectionCalculator(cam, sphere), 0);
		
		
	}

}
