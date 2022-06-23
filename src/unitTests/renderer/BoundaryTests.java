package unitTests.renderer;
import org.junit.Test;

import geometries.Geometries;
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
public class BoundaryTests {
	
	/*
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
	
	@Test
	public void sphereSpot() throws Exception {
		
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
		    
		    camera1.setFocalPlane(focalPlaneDistance).setApertureSize(apertureSize);
		    camera1.setNumOfRaysSuperSampling(numOfRays);
		}
		
		scan.close();
		
		scene1.geometries.add(sphere, sphere2);
		scene1.printMaxMin();
		scene1.lights.add(new SpotLight(spCL, spPL, new Vector(1, 1, -0.5)).setKL(0.001).setKQ(0.0001));

		ImageWriter imageWriter = new ImageWriter("simple boundary", 500, 500);
		camera1.setImageWriter(imageWriter) //
				.setRayTraceBase(new RayTracerBasic(scene1)); //
		
		camera1.renderImage(); //
		camera1.printGrid(100, new Color(WHITE));
		camera1.writeToImage(); //
	}
	
	*/
	
	
	
	private Scene scene = new Scene("Test scene") 
			.setAmbientLight(new AmbientLight(new Color(WHITE), new Double3(0.15)));
	
	private Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) 
			.setVPSize(200, 200) 
			.setVPDistance(1000);
	
	private Point[] p = { // The Triangles' vertices:
			new Point(-75,78,0),//0
			new Point(-53.75, 80.75, -18.75),//1
			new Point(-32.5, 83.5, -37.5),//2
			new Point(-11.25, 86.25, -56.25),//3
			new Point(10, 89, -75),//4
			new Point(31.25, 91.75, -93.75),//5
			new Point(52.5, 94.5, -112.5),//6
			new Point(73.75, 97.25, -131.25),//7
			new Point(95,100,-150),//8

			new Point(-66.56, 67.63, -18.75),//9
			new Point(-45.31, 70.38, -37.5),//10
			new Point(-22.5, 72.44, -51.56),//11
			new Point(-1.25, 75.19, -70.31),//12
			new Point(20, 77.94, -89.06),//13
			new Point(41.25, 80.69, -107.81),//14
			new Point(62.5, 83.44, -126.56),//15
			new Point(83.75, 86.19, -145.31),//16

			new Point(-79.38, 54.5, -18.75),//17
			new Point(-58.13, 57.25, -37.5),//18
			new Point(-33.75, 58.63, -46.88),//19
			new Point(-12.5, 61.38, -65.63),//20
			new Point(8.75, 64.13, -84.38),//21
			new Point(30, 66.88, -103.13),//22
			new Point(51.25, 69.63, -121.88),//23
			new Point(72.5, 72.38, -140.63),//24
			new Point(96.88, 73.75, -150),//25

			new Point(-70.94, 44.13, -37.5),//26
			new Point(-46.56, 45.5, -46.88),//27
			new Point(-23.75, 47.56, -60.94),//28
			new Point(-2.5, 50.31, -79.69),//29
			new Point(18.75, 53.06, -98.44),//30
			new Point(40, 55.81, -117.19),//31
			new Point(61.25,58.56,-135.94),//32
			new Point(85.63, 59.94, -145.31),//33

			new Point(-83.75, 31, -37.5),//34
			new Point(-59.38, 32.38, -46.88),//35
			new Point(-35, 33.75, -56.25),//36
			new Point(-13.75, 36.5, -75),//37
			new Point(7.5, 39.25, -93.75),//38
			new Point(28.75, 42, -112.5),//39
			new Point(50, 44.75, -131.25),//40
			new Point(74.38, 46.13, -140.63),//41
			new Point(98.75, 47.5, -150),//42

			new Point(-73.75, 19.94, -51.56),//43
			new Point(-49.38, 21.31, -60.94),//44
			new Point(-26.56, 23.38, -75),//45
			new Point(-5.31, 26.13, -93.75),//46
			new Point(17.5, 28.19, -107.81),//47
			new Point(38.75, 30.94, -126.56),//48
			new Point(63.13, 32.31, -135.94),//49
			new Point(87.5, 33.69, -145.31),//50

			new Point(-88.13, 7.5, -56.25),//51
			new Point(-63.75, 8.88, -65.63),//52
			new Point(-39.38, 10.25, -75),//53
			new Point(-18.13, 13, -93.75),//54
			new Point(6.25, 14.38, -103.13),//55
			new Point(27.5, 17.13, -121.88),//56
			new Point(51.88, 18.5, -131.25),//57
			new Point(76.25, 19.88, -140.63),//58
			new Point(100.63, 21.25, -150),//59

			new Point(-78.13, -3.56, -70.31),//60
			new Point(-53.75, -2.19, -79.69),//61
			new Point(-30.94, -0.13, -93.75),//62
			new Point(-6.56, 1.25, -103.13),//63
			new Point(16.25, 3.31, -117.19),//64
			new Point(40.63, 4.69, -126.56),//65
			new Point(65, 6.06, -135.94),//66
			new Point(89.38, 7.44, -145.31),//67

			new Point(-92.5, -16, -75),//68
			new Point(-68.13, -14.63, -84.38),//69
			new Point(-43.75, -13.25, -93.75),//70
			new Point(-19.38, -11.88, -103.13),//71
			new Point(5,-10.5,-112.5),//72
			new Point(29.38, -9.13, -121.88),//73
			new Point(53.75, -7.75, -131.25),//74
			new Point(78.13, -6.38, -140.63),//75
			new Point(102.5, -5, -150),//76

			new Point(-82.5, -27.06, -89.06),//77
			new Point(-58.13, -25.69, -98.44),//78
			new Point(-33.75, -24.31, -107.81),//79
			new Point(-9.38, -22.94, -117.19),//80
			new Point(16.56, -22.25, -121.88),//81
			new Point(40.94, -20.88, -131.25),//82
			new Point(66.88, -20.19, -135.94),//83
			new Point(91.25, -18.81, -145.31),//84

			new Point(-96.88, -39.5, -93.75),//85
			new Point(-72.5, -38.13, -103.13),//86
			new Point(-48.13, -36.75, -112.5),//87
			new Point(-23.75, -35.38, -121.88),//88
			new Point(3.75, -35.38, -121.88),//89
			new Point(28.13, -34, -131.25),//90
			new Point(55.63, -34, -131.25),//91
			new Point(80, -32.63, -140.63),//92
			new Point(104.38, -31.25, -150),//93

			new Point(-86.88, -50.56, -107.81),//94
			new Point(-62.5, -49.19, -117.19),//95
			new Point(-38.13, -47.81, -126.56),//96
			new Point(-10.63, -47.81, -126.56),//97
			new Point(15.31, -47.13, -131.25),//98
			new Point(42.81, -47.13, -131.25),//99
			new Point(68.75, -46.44, -135.94),//100
			new Point(93.13, -45.06, -145.31),//101

			new Point(-101.25, -63, -112.5),//102
			new Point(-76.88, -61.63, -121.88),//103
			new Point(-52.5, -60.25, -131.25),//104
			new Point(-25, -60.25, -131.25),//105
			new Point(2.5, -60.25, -131.25),//106
			new Point(30, -60.25, -131.25),//107
			new Point(57.5, -60.25, -131.25),//108
			new Point(81.88, -58.88, -140.63),//109
			new Point(106.25, -57.5, -150),//110

			new Point(-91.25, -74.06, -126.56),//111
			new Point(-66.88, -72.69, -135.94),//112
			new Point(-39.38, -72.69, -135.94),//113
			new Point(-11.88, -72.69, -135.94),//114
			new Point(15.63, -72.69, -135.94),//115
			new Point(43.13, -72.69, -135.94),//116
			new Point(69.06, -72, -140.63),//117
			new Point(93.44, -70.63, -150),//118

			new Point(-105.63, -86.5, -131.25),//119
			new Point(-81.25, -85.13, -140.63),//120
			new Point(-53.75, -85.13, -140.63),//121
			new Point(-26.25, -85.13, -140.63),//122
			new Point(1.25, -85.13, -140.63),//123
			new Point(28.75, -85.13, -140.63),//124
			new Point(56.25, -85.13, -140.63),//125
			new Point(80.63, -83.75, -150),//126
			new Point(108.13, -83.75, -150),//127

			new Point(-95.63, -97.56, -145.31),//128
			new Point(-68.13, -97.56, -145.31),//129
			new Point(-40.63, -97.56, -145.31),//130
			new Point(-13.13, -97.56, -145.31),//131
			new Point(14.38, -97.56, -145.31),//132
			new Point(41.88, -97.56, -145.31),//133
			new Point(67.81, -96.88, -150),//134
			new Point(95.31, -96.88, -150),//135

			new Point(-110,-110,-150),//136
			new Point(-82.5, -110, -150),//137
			new Point(-55, -110, -150),//138
			new Point(-27.5, -110, -150),//139
			new Point(0, -110, -150),//140
			new Point(27.5, -110, -150),//141
			new Point(55, -110, -150),//142
			new Point(82.5, -110, -150),//143
			new Point(110,-110,-150)};//144

	//top left quardrant of pic
	private Geometry sphere1 = new Sphere(p[18], 10d).setEmission(new Color(BLACK)) //object a
			.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(15).setKR(new Double3(0.5)));
	private Geometry sphere2 = new Sphere(p[20], 10d).setEmission(new Color(BLACK)) //object b
			.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(15).setKR(new Double3(0.5)));
	private Geometry triangle1 = new Triangle(p[36], p[54], p[52]).setMaterial((new Material().setKD(0.5)
			.setKS(0.5).setShininess(15).setKR(new Double3(0.5)))); // object c
	
	//bottom left quardrant of pic
	private Geometry sphere3 = new Sphere(p[112], 10d).setEmission(new Color(BLACK)) //object d
			.setMaterial(new Material().setKD(0.5).setKS(0.5).setShininess(15).setKR(new Double3(0.5)));
	private Geometry triangle2 = new Triangle(p[105], p[114], p[122]).setMaterial((new Material().setKD(0.5)
			.setKS(0.5).setShininess(15).setKR(new Double3(0.5)))); // object e
	
	//bottom right quardrant of pic
	private Geometry triangle3 = new Triangle(p[109], p[118], p[126]).setMaterial((new Material().setKD(0.5)
			.setKS(0.5).setShininess(15).setKR(new Double3(0.5)))); // object f
	
	private Point spPL = new Point(-50, -50, 25); 
	private Color spCL = new Color(800, 500, 0); 
	
	private Geometries geometries1 = new Geometries(sphere1, sphere2, triangle1);
	private Geometries geometries2 = new Geometries(sphere3, triangle2);

	
		
	@Test
	public void sphereSpot() throws Exception {
		
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
		
		
		//scene.geometries.add(geometries1, geometries2, triangle3);
		scene.geometries.add(sphere1, sphere2, sphere3, triangle1, triangle2, triangle3);
		scene.convertFlatGeometriesToHierarchical();
		scene.printMaxMin();
		scene.lights.add(new SpotLight(spCL, spPL, new Vector(1, 1, -0.5)).setKL(0.001).setKQ(0.0001));

		ImageWriter imageWriter = new ImageWriter("complex single boundary", 500, 500);
		camera.setImageWriter(imageWriter) //
				.setRayTraceBase(new RayTracerBasic(scene)); //
		
		camera.setMultithreading(1).setDebugPrint(0.1);
		
		camera.renderImage(); //
		camera.writeToImage(); //
	}
	
	
	
}

