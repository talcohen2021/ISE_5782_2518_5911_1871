package renderer;

import primitives.*;
import static primitives.Util.isZero;

import java.util.MissingResourceException;
/**
 * @author meira
 *
 */
public class Camera {

	private Point p0;
	private Vector vTo, vUp, vRight;
	private double width, height, distance;
	
	private ImageWriter imageWriter;
	private RayTraceBase rayTraceBase;
	
	/**
	 * @param p0 the center of the camera from where the vectors start
	 * @param vUp the up direction
	 * @param vTo the side direction
	 * @brief create orthogonal vRight to complete the three axis
	 */
	public Camera(Point p0, Vector vUp, Vector vTo) {
	
		if(!isZero(vUp.dotProduct(vTo)))
			throw new IllegalArgumentException("The two vectors must be orthogonal");
		this.p0 = p0;
		
		try {
			this.vTo = vTo.normalize();
			this.vUp = vUp.normalize();
			this.vRight =vTo.crossProduct(vUp).normalize();
		} catch (Exception e) {
			System.out.println("Can't have a zero vector");
		}
	}
	
	/**
	 * 
	 * @param width width of the view plane
	 * @param height height of the view plane
	 * @return this (camera)
	 */
	public Camera setVPSize(double width, double height) {
		this.width = width;
		this.height = height;
		return this;
	}
	
	/**
	 * 
	 * @param p0
	 */
	public void setP0(Point p0) {
		this.p0 = p0;
	}
	
	
	/**
	 * 
	 * @param distance the distance from camera to view plane
	 * @return this (camera)
	 */
	public Camera setVPDistance(double distance) {
		this.distance = distance;
		return this;
	}
	 
	/**
	 * 
	 * @param imageWriter
	 * @return this (camera)
	 */
	public Camera setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
		return this;
	} 
		
	/**
	 * @para rayTraceBase
	 * @return this (camera)
	 */
	public Camera setRayTraceBase(RayTraceBase rayTraceBase) {
		this.rayTraceBase = rayTraceBase;
		return this;
	}
		 
	/**
	 * lacking clarity on this method
	 * @return null for now
	 */
	public Ray constructRayPixel() {
		return null;
	}
		
	/**
	 * 
	 * @param nX width - # of rows
	 * @param nY height - # of columns
	 * @param j index of pixel  width = columns
	 * @param i index of pixel height = rows
	 * @return ray from camera to pixel
	 */
	public Ray constructRay(int nX, int nY, int j, int i) {
		try {
			Point pc = p0.add(vTo.scale(distance));
			double pixelWidth = width/nX;
			double pixelHeight = height/nY;
				
			double yi = -(i - (nY-1)/2) * pixelHeight;
			double xj = (j - (nX-1)/2) * pixelWidth;
				
			Point pIJ = pc;
			if(!isZero(yi))
				pIJ = pIJ.add(vUp.scale(yi));
			if(!isZero(xj))
				pIJ = pIJ.add(vRight.scale(xj));
			Vector dir = pIJ.subtract(p0).normalize();
			return new Ray(p0, dir);
				
			} catch (Exception e) {
				System.out.println("Can't have zero vector");
			}
		return null;
	}
		
		
	/**
	 * 
	 * lacking clarity on this method
	 * null for now
	 */	
	public void renderImage() {

		if(this.p0 == null || this.vTo == null || this.vUp == null || this.vRight == null)
			throw new MissingResourceException("missing resource", "Camera", "");
		
		if(this.imageWriter == null || this.rayTraceBase == null)
			throw new MissingResourceException("missing resource", "Camera", "");
		
		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		
		for(int row = 0; row < nY; ++row )
			for(int col = 0; col < nX; ++col) {
				Ray ray = constructRay( nX, nY, col, row);
				//need to figure out how to do this
				RayTraceBase rayTracerBasic = new RayTracerBasic();
				Color pixelColor = rayTracerBasic.traceRay(ray);
				imageWriter.writePixel(col,row,pixelColor);
				
			}
		
		/*
		 * to loop over all the ViewPlane’s pixels. For each pixel it will construct a ray and for each 
		 * ray it will calculate a color (the ray tracer will return a color). The color will be stored 
		 * in the corresponding pixel in the image using the writePixel method.
		 * */
		
		
	}
	
	/**
	 * @brief creates a grid of lines
	 * 
	 */	
	public void printGrid(int interval, Color color)  {
		/*
		 * creates a grid of lines as similar to what you did in the test of the first phase 
		 * (Make sure that the grid does not ruin your picture. The grid should not “overwrite” the picture 
		 * that you are drawing.  You only want to color the pixels where the grid appears in them, leave 
		 * the other pixels alone. 
		 * */
		
		if(imageWriter == null)
			throw new MissingResourceException("missing resource", "Camera", "");
		
		int nX = imageWriter.getNx();
	    int nY = imageWriter.getNy();
	    
	    for (int row = 0; row < nY; row++) 
	      for (int col = 0; col < nX; col++) 
	        if (col % interval == 0 || row % interval == 0) 
	          imageWriter.writePixel(col, row, color);
		
	}

	/**
	 * @brief calls on imageWriters writeToImage
	 * @throws MissingResourceException
	 */	
	public void writeToImage(){
		
		if(imageWriter == null)
			throw new MissingResourceException("missing resource", "Camera", "");
		
		imageWriter.writeToImage();
		
	}
	 
	
	
	/*
	public double getHeight() {
		return height;
	}
	public void setHeight( double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	*/
	
}
