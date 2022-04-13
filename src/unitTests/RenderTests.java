package unitTests;

import org.junit.Test;

import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;
import elements.*;

/**
 * Test rendering a basic image
 * 
 * @author Dan
 */
public class RenderTests {

	/**
	 * Produce a scene with basic 3D model and render it into a png image with a
	 * grid
	 * @throws Exception 
	 */
	@Test
	public void basicRenderTwoColorTest() throws Exception {
		Scene scene = new Scene("Test scene")//
				.setAmbientLight(new Color(255, 191, 191), new Double3(1,1,1)) //
				.setBackground(new Color(75, 127, 90));

		scene.getGeometries().add(new Sphere(new Point(0, 0, -100), 50),
				new Triangle(new Point(-100, 0, -100), new Point(0, 100, -100), new Point(-100, 100, -100)), // up
																													// left
				new Triangle(new Point(-100, 0, -100), new Point(0, -100, -100), new Point(-100, -100, -100)), // down
																														// left
				new Triangle(new Point(100, 0, -100), new Point(0, -100, -100), new Point(100, -100, -100))); // down
																													// right
		Camera camera = new Camera(new Point(Double3.ZERO), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setVPDistance(100) //
				.setVPSize(500, 500) //
				.setImageWriter(new ImageWriter("base render test", 1000, 1000))				
				.setRayTraceBase(new RayTracerBasic(scene));

		camera.renderImage();
		camera.printGrid(100, new Color(java.awt.Color.YELLOW));
		camera.writeToImage();
	}

	
	/**
	 * Test for XML based scene - for bonus
	 * @throws Exception 
	 */
	//@Test
	
	/*
	public void basicRenderXml() throws Exception {
		Scene scene = new Scene("XML Test scene");
		// enter XML file name and parse from XML file into scene object
		// ...

		Camera camera = new Camera(new Point(Double3.ZERO), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setVPDistance(100) //
				.setVPSize(500, 500)
				.setImageWriter(new ImageWriter("xml render test", 1000, 1000))
				.setRayTraceBase(new RayTracerBasic(scene));
		camera.renderImage();
		camera.printGrid(100, new Color(java.awt.Color.YELLOW));
		camera.writeToImage();
	}
	*/
}
