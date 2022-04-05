/**
 * 
 */
package renderer;

import primitives.*;
import static primitives.Util.isZero;
/**
 * @author meira
 *
 */
public class Camera {

	private Point p0;
	private Vector vTo, vUp, vRight;
	private double width, height, distance;
	
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
