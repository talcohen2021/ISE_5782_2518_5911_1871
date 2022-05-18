/**
 * 
 */
package renderer;

import primitives.Color;

import primitives.Point;
import primitives.Ray;
import scene.Scene;

import java.util.ArrayList;
import java.util.List;

import geometries.Intersectable.GeoPoint;

/**
 * @author Yaakovah
 *
 */
public class RayTracerBasic extends RayTraceBase {

	/**
	 * @param s
	 */
	public RayTracerBasic(Scene s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color traceRay(Ray ray) {
		/*
		 * to search intersections between the ray and the 3DModel of the scene. 
		 * If there are no intersections the color will be the background color. Otherwise, find the closest 
		 * point to the ray’s head (by using the method that we implemented in phase 3) and find the color of 
		 * the point using this method:
	
		 * */
		List<GeoPoint> intersectingGeoPoints;
		
		try {
			intersectingGeoPoints = new ArrayList<GeoPoint>(scene.getGeometries().findGeoIntersections(ray));
		
		
		if(intersectingGeoPoints == null)
			return scene.getBackground();
		
		return calcColor(ray.findClosestGeoPoint(intersectingGeoPoints));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * At this stage of the project, the function shall return the color of the ambient light of the scene
	 * At this stage in the project we are not yet using the parameter that was passed to the method
	 * 
	 * @param p - a Geopoint
	 * @return the color of point p
	 * 
	 * updates the calcColor function to add the object’s color to the point’s color
	 */
	public Color calcColor(GeoPoint p) {
		
		p.geometry.setEmission(scene.getAmbientLight().getIntensity());
		return scene.getAmbientLight().getIntensity();
	}

}
