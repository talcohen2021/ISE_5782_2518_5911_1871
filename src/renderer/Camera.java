package renderer;

import primitives.*;


import static primitives.Util.isZero;

import java.util.MissingResourceException;
/**
 * @author yaakovah, meira, tali
 *
 */
public class Camera {

	private Point p0; // origin of the camera
	private Vector vTo, vUp, vRight; // axis of the camera - vTo = z , vUp = y, vRight = x
	private double distance; // distance of the camera from the viewplane
	private double  width, height ; // width and height of the viewplane
	
	private ImageWriter imageWriter;
	private RayTraceBase rayTraceBase;
	
	/**
	 * @param p0 the center of the camera from where the vectors start
	 * @param vUp the up direction
	 * @param vTo the side direction
	 * @brief create orthogonal vRight to complete the three axis
	 */
	public Camera(Point p0, Vector vTo, Vector vUp)  {
		//orig :  !isZero(vUp.dotProduct(vTo))
		if(!isZero(vTo.dotProduct(vUp)))
			throw new IllegalArgumentException("The two vectors must be orthogonal");
		this.p0 = p0;
		
		try {
			this.vTo = vTo.normalize();
			this.vUp = vUp.normalize();
			//orig : added brackets
			this.vRight = (vTo.crossProduct(vUp)).normalize();
			// reversed: this.vRight =vUp.crossProduct(vTo).normalize();
		} catch (Exception e) {
			System.out.println("Can't have a zero vector");
		}
		
	}
	
	/**
	 * @brief set the side of the view plane
	 * @param width width of the view plane
	 * @param height height of the view plane
	 * @return this (camera)
	 */
	public Camera setVPSize(double width, double height) {
		this.width = width;
		this.height = height;
		return this;
	}
	
	
	public void setP0(Point p0) {
		this.p0 = p0;
	}
	
	
	/**
	 * @brief set the distance of the view plane to the camera
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
	 * @brief construct a ray from a camera point to a pixel
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
				
			double yi = -((i - (nY-1)/2d)) * pixelHeight;
			double xj = ((j - (nX-1)/2d)) * pixelWidth;
				
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
	 *@brief loop over all the pixels in the view plane, construct a ray for each, and color the pixel
	 * @throws Exception 
	 */	
	public void renderImage() throws Exception {

		/*
		 * to loop over all the ViewPlane's pixels. For each pixel it will construct a ray and for each 
		 * ray it will calculate a color (the ray tracer will return a color). The color will be stored 
		 * in the corresponding pixel in the image using the writePixel method.
		 * */
		
		if(this.p0 == null || this.vTo == null || this.vUp == null || this.vRight == null)
			throw new MissingResourceException("missing resource", "Camera", "");
		
		if(this.imageWriter == null || this.rayTraceBase == null)
			throw new MissingResourceException("missing resource", "Camera", "");
		
		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		
		for(int row = 0; row < nY; ++row )
			for(int col = 0; col < nX; ++col) {
				Ray ray = constructRay( nX, nY, col, row);
				Color pixelColor = this.rayTraceBase.traceRay(ray);
				imageWriter.writePixel(col,row,pixelColor);
				
			}
		
	}
	
	/**
	 * @brief creates a grid of lines
	 * @param interval the size of the spacing of the grid
	 * @param color of the grid
	 */	
	public void printGrid(int interval, Color color)  {
		/*
		 * creates a grid of lines as similar to what you did in the test of the first phase 
		 * (Make sure that the grid does not ruin your picture. The grid should not overwrite the picture
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
}
