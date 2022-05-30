
package renderer;

import primitives.Util;
import primitives.Color;
import primitives.Double3;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.util.ArrayList;
import java.util.List;

import geometries.Intersectable.GeoPoint;
import lighting.LightSource;

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
	 * @throws Exception 
	 */
	public Color calcColor(GeoPoint intersection, Ray ray) throws Exception {
		
		Color tempEmission = intersection.geometry.getEmission();
		return scene.getAmbientLight().getIntensity().add(tempEmission) //.add(calculated light contribution from all light sources)
		.add(calcLocalEffects(intersection, ray));
    
	}
	
	/**
	 * this function was taken from the slides
	 * @param intersection
	 * @param ray
	 * @return
	 * @throws Exception 
	 */
	private Color calcLocalEffects(GeoPoint intersection, Ray ray) throws Exception {
		Vector v = ray.getDir(); 
		Vector n = intersection.geometry.getNormal(intersection.point);
		double nv= Util.alignZero(n.dotProduct(v)); 
		if (nv== 0) 
			return Color.BLACK;
		int nShininess= intersection.geometry.getShininess();
		Double3 kd= intersection.geometry.getKD();
		Double3 ks= intersection.geometry.getKS();
		Color color= Color.BLACK;
		for (LightSource lightSource: scene.getLights()) {
			Vector l = lightSource.getL(intersection.point);
			double nl= Util.alignZero(n.dotProduct(l));
			if (nl* nv> 0) { // sign(nl) == sing(nv)
				if (unshaded(l, n, intersection, lightSource)) {
					Color lightIntensity = lightSource.getIntensity(intersection.point);
					color = color.add(calcDiffusive(kd, l, n, lightIntensity), calcSpecular(ks, l, n, v, nShininess, lightIntensity));
				}
			}
		}
		return color;
	}
	
	/**
	 * 
	 * @param kd
	 * @param l
	 * @param n
	 * @param lightIntensity
	 * @return
	 */
	private Color calcDiffusive(Double3 kd, Vector l, Vector n, Color lightIntensity) {
	    double factor = Math.abs(Util.alignZero(l.dotProduct(n)));
	    return lightIntensity.scale(kd.scale(factor));
	  }
	
	/**
	 * 
	 * @param ks
	 * @param l is the light direction
	 * @param n is the normal
	 * @param v view direction
	 * @param nShininess
	 * @param lightIntensity
	 * @return
	 */
	private Color calcSpecular(Double3 ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
	    Vector r = l.subtract(n.scale(Util.alignZero(2 * l.dotProduct(n))));
	    double vr = Util.alignZero(v.dotProduct(r));	
	    return lightIntensity.scale((ks.scale(Math.pow(-vr, nShininess))).abs());
	  }
	
	/**
	 * check if a point is not being shadowed - meaning, check if there is something that is blocking the 
	 * light from you point.  
	 * @param l is the light direction
	 * @param n is the normal
	 * @param gp
	 * @return true if there are no intersections (ie its unshaded) and false otherwise
	 * @throws Exception 
	 */
	private boolean unshaded(Vector l, Vector n, GeoPoint gp, LightSource ls) throws Exception {
		
		Vector lightDirection = l.scale(-1); //from point to light force
		Vector DELTAVector = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);
		Point point = gp.point.add(DELTAVector);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.getGeometries().findGeoIntersections(lightRay);
	
		boolean isEmpty = false;
		
		if(intersections==null) 
			isEmpty = true;
		else
		{
			//isEmpty = false;
			double distanceBtwnGpLs = ls.getDistance(gp.point);
			
			for (GeoPoint geo : intersections)
			{
				double tempDistance = geo.point.distance(gp.point);
				
				if(tempDistance <= distanceBtwnGpLs)
				{
					return false;	
				}
			}
			
		}
			
		//System.out.println("returning. isempty is:" + isEmpty);
		return isEmpty;
	
	}
	
	
	
}
