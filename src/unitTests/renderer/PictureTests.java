
 
package unitTests.renderer;
import org.junit.Test;

import geometries.Sphere;
import geometries.Triangle;
import lighting.AmbientLight;
import lighting.SpotLight;
import primitives.Color;
import primitives.Double3;
import primitives.Material;
import primitives.Point;
import primitives.Vector;
import renderer.Camera;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import scene.Scene;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static org.junit.jupiter.api.Assertions.*;



/**
 * @author meira
 *
 */
public class PictureTests {

	private Scene scene = new Scene("Test scene");
	private Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
			.setVPSize(400, 400).setVPDistance(1000) //
			.setRayTraceBase(new RayTracerBasic(scene));
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void makePicture() throws Exception {
		scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), new Double3(0.15)));
		
		scene.getGeometries().add( //
				new Triangle(new Point(50, 500, 50), new Point(50, -50, 50), new Point(-50, 50, 50)) 
						.setEmission(new Color(RED))
						.setMaterial(new Material().setKD(0.4).setKS(0.9).setShininess(60)), 
				new Triangle(new Point(-60, 60, 50), new Point(-45, 50, 50), new Point(-75, 50, 50)) 
						.setEmission(new Color(BLUE))
						.setMaterial(new Material().setKS(0.2).setShininess(70)), 
				new Triangle(new Point(-100, 100, 100), new Point(-50, -50, -50), new Point(-75, -50, -50)) 
						//.setEmission(new Color())
						.setMaterial(new Material().setKS(0.7).setShininess(50)));
		
		scene.getLights().add( //
				new SpotLight(new Color(1000, 600, 0), new Point(-100, -100, 500), new Vector(-1, -1, -2)) 
				.setKL(0.0004).setKQ(0.0000006));
		
		camera.setImageWriter(new ImageWriter("ourPicture", 600, 600));
		camera.renderImage();
		camera.writeToImage();
						
						
	}

}



