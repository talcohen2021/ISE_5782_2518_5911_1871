package unitTests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Intersectable;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.*;
import renderer.Camera;

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
	public int intersectionCalculator(Camera cam, Intersectable geometry) throws Exception {
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Ray ray = cam.constructRay(3, 3, j, i);
				List<Point> intersections = geometry.findIntsersections(ray);
				count += intersections.size();
			}
		}
	return count;
	}


	@Test
	void sphereIntegrationTest() throws Exception {
		Camera cam = new Camera(new Point(Double3.ZERO), new Vector(0,1,0), new Vector(0,0,-1));
		cameraSetUp(cam, 1, 3, 3);
		
		/*---- sphere tests------*/
		
		Sphere sphere = new Sphere(new Point(0,0,-3), 1);
		
		//tc 1
		assertEquals("there should be 2 intersections ", intersectionCalculator(cam, sphere), 2);
	
		sphere = new Sphere(new Point(0,0,-2.5), 2.5);
		cam.setP0(new Point(0,0,0.5));
		
		//tc 2
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
	
	@Test
	void planeIntegrationTest() throws Exception {
		Camera cam = new Camera(new Point(Double3.ZERO), new Vector(0,-1, 0), new Vector(0,0, -1));
		cameraSetUp(cam, 1, 3, 3);
		
		Plane plane = new Plane(new Point(0,0,-10), new Vector(0,0,1));
		
		//tc 1
		assertEquals("there should be 9 intersections ", intersectionCalculator(cam, plane), 9);
		
		plane = new Plane(new Point(0,0,-10), new Vector(0,1, 2)); 
		
		//tc 2
		assertEquals("there should be 9 intersections ", intersectionCalculator(cam, plane), 9);
		
		plane = new Plane(new Point(0,0,-10), new Vector(0,1,1));
		
		//tc 3
		assertEquals("there should be 6 intersections ", intersectionCalculator(cam, plane), 6);
		
	}
	
	@Test
	void triangleIntegrationTest() throws Exception {
		
		Camera cam = new Camera(new Point(Double3.ZERO), new Vector(0,1,0), new Vector(0,0,-1));
		cameraSetUp(cam, 1, 3, 3);
		
		Triangle triangle = new Triangle(new Point(0,1,-2), new Point(1,-1,-2), new Point(-1,-1,-2));
		
		//tc 1
		assertEquals("there should be 1 intersection ", intersectionCalculator(cam, triangle), 1);
		
		triangle = new Triangle(new Point(0,20,-2), new Point(1,-1,-2), new Point(-1,-1,-2));
		
		//tc 2
		assertEquals("there should be 2 intersections ", intersectionCalculator(cam, triangle), 2);
	}

}
