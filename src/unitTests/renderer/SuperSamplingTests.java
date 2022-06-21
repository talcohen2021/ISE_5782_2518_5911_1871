package unitTests.renderer;
import org.junit.Test;

import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import lighting.AmbientLight;
import lighting.DirectionalLight;
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

import static java.awt.Color.*;

import java.util.Scanner;


/**
 * @author Yaakovah, Meira, Tali
 *
 */
public class SuperSamplingTests {
	/*
	private Scene scene = new Scene("Test scene") 
			.setAmbientLight(new AmbientLight(new Color(WHITE), new Double3(0.15)));
	
	private Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) 
			.setVPSize(200, 200) 
			.setVPDistance(1000);
	
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
	
	private Geometry triangle1 = new Triangle(p[0], p[4], p[8]).setMaterial(material); //a,e,i
	private Geometry triangle3 = new Triangle(p[0], p[4], p[7]).setMaterial(material); //a, e, h
	private Geometry triangle5 = new Triangle(p[1], p[4], p[5]).setMaterial(material); //b, e, f
	private Geometry triangle7 = new Triangle(p[1], p[4], p[6]).setMaterial(material); //b, e, g
	*/
	//for the boundary simple test
	private Scene scene1 = new Scene("Test scene");
	private Camera camera1 = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
			.setVPSize(150, 150) //
			.setVPDistance(1000);
	private Geometry sphere = new Sphere(new Point(0, 0, -50), 50d) //
			.setEmission(new Color(BLUE).reduce(2)) //
			.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(300));
	private Geometry sphere2 = new Sphere(new Point(50, 50, -50), 50d) //
			.setEmission(new Color(BLUE).reduce(2)) //
			.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(300));
	private Point spPL = new Point(-50, -50, 25); // Sphere test Position of Light
	private Color spCL = new Color(800, 500, 0); // Sphere test Color of Light
/*
	@Test
	public void makePictureSuper() throws Exception {
		
		String choice;
		Scanner scan = new Scanner(System.in);
		System.out.println("Type 'yes' if you would like to use the 'depth of field' option and type anything else otherwise: " );
		choice = scan.nextLine();
		
		double focalPlaneDistance = 1000;
		double apertureSize = 1;
		int numOfRays = 81;
		
		if(choice.equals("yes")) {
			System.out.println("Please enter your preferred focal plane distance. Must be greater than view plane distance." );
			focalPlaneDistance = scan.nextDouble();
			System.out.println("Please enter your preferred aperture size. ");
		    apertureSize = scan.nextDouble();
		    System.out.println("Please enter your preferred super sampling size. ");
		    numOfRays = scan.nextInt();
		    System.out.println("Input received, picture is being processed.");
		    
		    camera.setFocalPlane(focalPlaneDistance).setApertureSize(apertureSize);
		    camera.setNumOfRaysSuperSampling(numOfRays);
		}
		
	    scan.close();
	    
		
		scene.geometries.add(
				triangle1.setEmission(new Color(WHITE)).setEmission(new Color(BLUE)) 
					.setMaterial(new Material().setKR(0.5).setKS(0.5).setKT(0.2)), 
				triangle3.setEmission(new Color(WHITE)).setEmission(new Color(BLUE)) 
					.setMaterial(new Material().setKR(0.5).setKS(0.5).setShininess(30)), 
				triangle5.setEmission(new Color(WHITE)).setEmission(new Color(BLUE)), 
				triangle7.setEmission(new Color(WHITE)).setEmission(new Color(BLUE)),
				//make shpere on top left
				new Sphere(new Point(-60, 50, -50), 30d).setEmission(new Color(BLUE)) 
					.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(30).setKT(new Double3(0.8))),
				//make 2 little spheres inside the above sphere
				new Sphere(new Point(-55, 55, -50), 10d).setEmission(new Color(BLACK)) //inner circle higher
					.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(15).setKR(new Double3(0.5))),
				new Sphere(new Point(-65, 45, -25), 7.5d).setEmission(new Color(BLACK)) //inner circle lower
					.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(30).setKR(new Double3(0.5))),
				new Sphere(new Point(-55, 45, -35), 7.5d).setEmission(new Color(BLACK)) //inner circle lower right
					.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(25).setKR(new Double3(0.5))),
				//make sphere on bottom right
				new Sphere(new Point(60, -50, -50), 30d).setEmission(new Color(BLUE)) 
					.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(30)),
				new Sphere(new Point(0, 0, -100), 25d).setEmission(new Color(RED)) 
					.setMaterial(new Material().setKD(0.4).setKS(0.3).setShininess(100).setKT(new Double3(0.3))));
	
		scene.lights.add(new DirectionalLight(new Color(RED), new Vector(-2,-2,-2)));
		scene.lights.add(new DirectionalLight(new Color(GREEN), new Vector(0,1,-50)));
		
		//create shadows of the spheres
		scene.lights.add(new SpotLight(new Color(700, 400, 400), new Point(60, -50, 0),
				new Vector(0, 0, -1)).setKL(4E-5).setKQ(2E-7)); 

		
		ImageWriter imageWriter = new ImageWriter("ourPicturesuper2", 500, 500);
		camera.setImageWriter(imageWriter).setRayTraceBase(new RayTracerBasic(scene));

		//camera.setMultithreading(3).setDebugPrint(0.1);
		
		camera.renderImage();
		camera.writeToImage(); 		
	}*/
	
	@Test
	public void sphereSpot() throws Exception {
		scene1.geometries.add(sphere, sphere2);
		scene1.printMaxMin();
		scene1.lights.add(new SpotLight(spCL, spPL, new Vector(1, 1, -0.5)).setKL(0.001).setKQ(0.0001));

		ImageWriter imageWriter = new ImageWriter("simple boundary", 500, 500);
		camera1.setImageWriter(imageWriter) //
				.setRayTraceBase(new RayTracerBasic(scene1)); //
		camera1.renderImage(); //
		camera1.writeToImage(); //
	}

}
