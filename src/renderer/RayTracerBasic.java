/**
 * 
 */
package renderer;

import primitives.Color;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.util.ArrayList;
import java.util.List;

import geometries.Intersectable.GeoPoint;

/**
 * @author Yaakovah, Meira, Tali
 *
 */
public class RayTracerBasic extends RayTraceBase {
	/**
	 * a constant field for the amount that you want to move the ray’s head (when  we are making shadow rays)
	 */
	private static final double DELTA = 0.1;

	/**
	 * @param s
	 */
	public RayTracerBasic(Scene s) {
		super(s);
	}
	
	@Override
	public Color traceRay(Ray ray) throws Exception {
		/*
		 * to search intersections between the ray and the 3DModel of the scene. 
		 * If there are no intersections the color will be the background color. Otherwise, find the closest 
		 * point to the ray's head (by using the method that we implemented in phase 3) and find the color of 
		 * */
		
		List<GeoPoint> intersectingGeoPoints = scene.getGeometries().findGeoIntersections(ray);
		
		if(intersectingGeoPoints == null)
			return scene.getBackground();
		
		return calcColor(ray.findClosestGeoPoint(intersectingGeoPoints), ray);

	}
	
	/**
	 * 
	 * @param p - a Geopoint
	 * @return the color of point p
	 * 
	 * updates the calcColor function to add the object's color to the point's color
	 */
	public Color calcColor(GeoPoint gp, Ray ray) {
		
		Color tempEmission = gp.geometry.getEmission();
		return scene.getAmbientLight().getIntensity().add(tempEmission);
    
	}
	
	/**
	 * check if a point is not being shadowed - meaning, check if there is something that is blocking the 
	 * light from you point.  
	 * @param l
	 * @param n
	 * @param gp
	 * @return
	 * @throws Exception 
	 */
	private boolean unshaded(Vector l, Vector n, GeoPoint gp) throws Exception {
		
		Vector lightDirection = l.scale(-1); //from point to light force
		Vector DELTAVector = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);
		Point point = gp.point.add(DELTAVector);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.getGeometries().findGeoIntersections(lightRay);
	
		return intersections.isEmpty();
	
	}
	
}
