
 
package unitTests.renderer;
import org.junit.Test;

import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import lighting.AmbientLight;
import lighting.DirectionalLight;
import lighting.SpotLight;
import lighting.PointLight;
import primitives.Color;
import primitives.Double3;
import primitives.Material;
import primitives.Point;
import primitives.Vector;
import renderer.Camera;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import scene.Scene;

import static java.awt.Color.*;
import static org.junit.jupiter.api.Assertions.*;



/**
 * @author meira
 *
 */
public class PictureTests {

	private Scene scene = new Scene("Test scene") //
			.setAmbientLight(new AmbientLight(new Color(WHITE), new Double3(0.15)));
	
	private Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
			.setVPSize(200, 200) //
			.setVPDistance(1000);
	
	//private Point trPL = new Point(30, 10, -100); // Triangles test Position of Light
	//private Point spPL = new Point(-50, -50, 25); // Sphere test Position of Light
	private Color trCL = new Color(400, 600, 350); // Triangles test Color of Light
	//private Color spCL = new Color(800, 500, 0); // Sphere test Color of Light
	private Vector trDL = new Vector(-2, -2, -2); // Triangles test Direction of Light
	
	private Point[] p = { // The Triangles' vertices:
			new Point(-110, -110, -150), // the shared left-bottom - a - 0
			new Point(95, 100, -150), // the shared right-top - b - 1
			new Point(110, -110, -150), // the right-bottom - c - 2
			new Point(-75, 78, 0), // the left-top - d -3
			new Point(-7.5, -5, -150), //halfway btwn a and b -e - 4
			new Point(10, 89, -75), //halfway btwn d and b -f - 5
			new Point(102.5, -5, -150), //halfway btwn b and c -g - 6
			new Point(-92.5, -16, -75), //halfway btwn a and d -h - 7
			new Point(0, -110, -150)}; //halfway btwn a and c -i - 8
			

	private Material material = new Material().setKD(0.5).setKS(0.5).setShininess(300);
	private Material material2 = new Material().setKD(0.9).setKS(0.9).setShininess(500);
	
	private Geometry triangle1 = new Triangle(p[0], p[4], p[8]).setMaterial(material); //a,e,i
	private Geometry triangle2 = new Triangle(p[2], p[4], p[8]).setMaterial(material2); //c, e, i
	private Geometry triangle3 = new Triangle(p[0], p[4], p[7]).setMaterial(material); //a, e, h
	private Geometry triangle4 = new Triangle(p[3], p[4], p[7]).setMaterial(material2); //d, e, h
	private Geometry triangle5 = new Triangle(p[1], p[4], p[5]).setMaterial(material); //b, e, f
	private Geometry triangle6 = new Triangle(p[3], p[4], p[5]).setMaterial(material2); //d, e, f
	private Geometry triangle7 = new Triangle(p[1], p[4], p[6]).setMaterial(material); //b, e, g
	private Geometry triangle8 = new Triangle(p[2], p[4], p[6]).setMaterial(material2); //c, e, g
	
	
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void makePicture() throws Exception {
	
		scene.getGeometries().add(triangle1.setEmission(new Color(BLUE)), 
				//triangle2.setEmission(new Color(RED)), 
				triangle3.setEmission(new Color(GREEN)), 
				//triangle4.setEmission(new Color(YELLOW)),
				triangle5.setEmission(new Color(BLACK)),
				//triangle6.setEmission(new Color(WHITE)),
				triangle7.setEmission(new Color(ORANGE)),
				//triangle8.setEmission(new Color(PINK))
				new Sphere(new Point(-60, 50, -50), 30d).setEmission(new Color(BLUE)) //
				.setMaterial(new Material().setKD(0.2).setKS(0.2).setShininess(30).setKT(new Double3(0.6))),
				new Sphere(new Point(60, -50, -50), 30d).setEmission(new Color(BLUE)) //
				.setMaterial(new Material().setKD(0.2).setKS(0.2).setShininess(30).setKT(new Double3(0.6))));

	

	
		scene.getLights().add(new DirectionalLight(trCL, trDL));
		scene.getLights().add( new PointLight(new Color(WHITE), new Point(60, -50, -50)));

		ImageWriter imageWriter = new ImageWriter("ourPicture", 500, 500);
		camera.setImageWriter(imageWriter) //
				.setRayTraceBase(new RayTracerBasic(scene));
		camera.renderImage();
		camera.writeToImage(); 		
	}

	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void makePicture2() throws Exception {
	
		scene.getGeometries().add(triangle1.setEmission(new Color(BLUE)), 
				//triangle2.setEmission(new Color(RED)), 
				//triangle3.setEmission(new Color(GREEN)), 
				triangle4.setEmission(new Color(YELLOW)),
				triangle5.setEmission(new Color(BLACK)),
				//triangle6.setEmission(new Color(WHITE)),
				//triangle7.setEmission(new Color(ORANGE)),
				triangle8.setEmission(new Color(PINK)),
				new Sphere(new Point(0, 0, -50), 25d).setEmission(new Color(RED)) 
						.setMaterial(new Material().setKD(0.4).setKS(0.3).setShininess(100).setKT(new Double3(0.3))),
				new Sphere(new Point(0, 0, -50), 12.5d).setEmission(new Color(GREEN)) 
						.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(100)));
	
		scene.getLights().add(new DirectionalLight(trCL, trDL));

		ImageWriter imageWriter = new ImageWriter("ourPicture2", 500, 500);
		camera.setImageWriter(imageWriter) //
				.setRayTraceBase(new RayTracerBasic(scene));
		camera.renderImage();
		camera.writeToImage(); 		
	}
	/* copy of method so that if we make changes we have what to look back on
	 * public void makePicture2() throws Exception {
	
		scene.getGeometries().add(triangle1.setEmission(new Color(BLUE)), 
				//triangle2.setEmission(new Color(RED)), 
				//triangle3.setEmission(new Color(GREEN)), 
				triangle4.setEmission(new Color(YELLOW)),
				triangle5.setEmission(new Color(BLACK)),
				//triangle6.setEmission(new Color(WHITE)),
				//triangle7.setEmission(new Color(ORANGE)),
				triangle8.setEmission(new Color(PINK)),
				new Sphere(new Point(0, 0, -50), 25d).setEmission(new Color(RED)) 
						.setMaterial(new Material().setKD(0.4).setKS(0.3).setShininess(100).setKT(new Double3(0.3))),
				new Sphere(new Point(0, 0, -50), 12.5d).setEmission(new Color(GREEN)) 
						.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(100)));
	
		scene.getLights().add(new DirectionalLight(trCL, trDL));

		ImageWriter imageWriter = new ImageWriter("ourPicture2", 500, 500);
		camera.setImageWriter(imageWriter) //
				.setRayTraceBase(new RayTracerBasic(scene));
		camera.renderImage();
		camera.writeToImage(); 		
	}

	 * */

}
/*
 * Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setVPSize(150, 150).setVPDistance(1000);

		scene.getGeometries().add( //
				new Sphere(new Point(0, 0, -50), 50d).setEmission(new Color(BLUE)) //
						.setMaterial(new Material().setKD(0.4).setKS(0.3).setShininess(100).setKT(new Double3(0.3))),
				new Sphere(new Point(0, 0, -50), 25d).setEmission(new Color(RED)) //
						.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(100)));
		scene.getLights().add( //
				new SpotLight(new Color(1000, 600, 0), new Point(-100, -100, 500), new Vector(-1, -1, -2)) //
						.setKL(0.0004).setKQ(0.0000006));

		camera.setImageWriter(new ImageWriter("refractionTwoSpheres", 500, 500)) //
				.setRayTraceBase(new RayTracerBasic(scene)); //
		camera.renderImage(); //
		camera.writeToImage();
 * */



