
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
	 * a constant field for the amount that you want to move the ray's head (when  we are making shadow rays)
	 */
	private static final double DELTA = 0.1;
	private static final int MAX_CALC_COLOR_LEVEL = 10;
	private static final double MIN_CALC_COLOR_K = 0.001;
	private static final double INITIAL_K = 1.0;

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
		
		/* before refactoring :
		List<GeoPoint> intersectingGeoPoints = scene.getGeometries().findGeoIntersections(ray);
		
		if(intersectingGeoPoints == null)
			return scene.getBackground();
		
		return calcColor(ray.findClosestGeoPoint(intersectingGeoPoints), ray);
		*/
		
		GeoPoint closestIntersection = findClosestIntersection(ray);
		if(closestIntersection == null)
			return scene.getBackground();
		return calcColor(closestIntersection, ray);
				
	}
	
	/**
	 * 
	 * @param intersection - a Geopoint that is being intersected that we will calculate the color of
	 * @param ray - the ray that is intersecting the point
	 * @param level - the level of reflecting/refracting (for the recursion)
	 * @param k - the percent of color we are taking from this geometry ... ?(for the recursion)
	 * @return the color of the intersection
	 * @throws Exception 
	 * 
	 * adds the object's color to the point's color. supports reflection and refraction
	 */
	public Color calcColor(GeoPoint intersection, Ray ray, int level, double k) throws Exception {
		
		Color tempEmission = intersection.geometry.getEmission();
		//line below was previously - Color color = scene.getAmbientLight().getIntensity().add(tempEmission) 
		Color color = tempEmission 
				.add(calcLocalEffects(intersection, ray)); //.add(calculated light contribution from all light sources)
		if(level==1)
			return color;
		else
		{
			color = color.add(calcGlobalEffects(intersection, ray, level, k));
			return color;
		}
		
	}
	
	/**
	 * 
	 * @param intersection - a Geopoint that is being intersected that we will calculate the color of
	 * @param ray - the ray that is intersecting the point
	 * @return the color of the intersection
	 * 
	 * updates the calcColor function to add the object's color to the point's color
	 * @throws Exception 
	 */
	private Color calcColor(GeoPoint gp, Ray ray) throws Exception
	{

		return calcColor(gp , ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(scene.getAmbientLight().getIntensity()); //.add... was from the slides...?
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
					//color = color.add(calcGlobalEffects(intersection, ray)); //new line
				}
			}
		}
		return color;
	}
	
	/**
	 * 
	 * @param intersection
	 * @param ray
	 * @param level - the level of reflecting/refracting (for the recursion)
	 * @param k - the percent we are taking ... ?(for the recursion)
	 * @return
	 * @throws Exception
	 */
	private Color calcGlobalEffects(GeoPoint intersection, Ray ray, int level, double k) throws Exception 
	{
		Color color = Color.BLACK;
		Ray reflectedRay = getReflectedRay(intersection, ray);
		GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
		
		Double3 kr = intersection.geometry.getKR();
		Double3 kkr = kr.scale(k);
		
		if (kkr.castToDouble() > MIN_CALC_COLOR_K) 
			color = color.add(calcColor(reflectedPoint, reflectedRay, level-1, kkr.castToDouble()).scale(kr)); //intersection.geometry.getKr()));
		Double3 kt = intersection.geometry.getKR();
		Double3 kkt = kt.scale(k);
		
		Ray refractedRay = getRefractedRay(intersection, ray);
		GeoPoint refractedPoint = findClosestIntersection(refractedRay);
		
		if(kkt.castToDouble() > MIN_CALC_COLOR_K) 
			color = color.add(calcColor(refractedPoint, refractedRay, level-1, kkt.castToDouble()).scale(kt)); //intersection.geometry.getKt());
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
		double vrmax = Math.max(0, v.scale(-1).dotProduct(r));
		double vrn = Math.pow(vrmax, nShininess);
		return lightIntensity.scale(ks.scale(vrn));
	    //double vr = Util.alignZero(v.dotProduct(r));	
	    //return lightIntensity.scale((ks.scale(Math.pow(-vr, nShininess))).abs());
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
		if(intersections==null) 
			return true;
		else
		{	//isEmpty = false;
			double distanceBtwnGpLs = ls.getDistance(lightRay.getP0());
			for (GeoPoint geo : intersections)
			{
				double tempDistance = geo.point.distance(lightRay.getP0());				
				if((tempDistance <= distanceBtwnGpLs) && geo.geometry.getKT().castToDouble() == 0)
					return false;	
			}		
		}		
		
		//only objects that are completely non-transparent( transparency coefficient kT == 0) will cause a shadow.
		//if(gp.geometry.getKT().castToDouble() == 0)
		//	return false;
		
		return true;	
	}
	
	
	 private Ray getReflectedRay(GeoPoint gpIntersection, Ray ray) throws Exception {
		    Vector dirRay = ray.getDir();
		    Vector normal = gpIntersection.geometry.getNormal(gpIntersection.point);
		    double dotProduct = dirRay.dotProduct(normal);
		    if (dotProduct == 0) {
		      return null;
		    }
		    double scale;
		    Vector newRay = dirRay.subtract(normal.scale(2 * dotProduct)).normalize();
		    double dotProduct2 = newRay.dotProduct(normal);
		    if(dotProduct2 >= 0)
				 scale = DELTA;
			 else 
				 scale = -DELTA;
		    Vector delta = normal.scale(scale);
		    Point point = gpIntersection.point.add(delta);
		    return new Ray(point, newRay);
	  }

	 private Ray getRefractedRay(GeoPoint gpIntersection, Ray ray) throws Exception {
		 Vector rayDir = ray.getDir();
		 Vector normal = gpIntersection.geometry.getNormal(gpIntersection.point);
		 double dotProduct = normal.dotProduct(rayDir);
		 double scale;
		 if(dotProduct >= 0)
			 scale = DELTA;
		 else 
			 scale = -DELTA;
		 Vector delta = normal.scale(scale);
		 Point point = gpIntersection.point.add(delta);
		 return new Ray(point, rayDir);
	  }
	 
	 /**
	  * 
	  * @param ray the ray that we ar finding the closest intersection of
	  * @return the closest geoPoint that is intersected by the ray
	  * @throws Exception
	  */
	 private GeoPoint findClosestIntersection(Ray ray) throws Exception
	 {
		 List<GeoPoint> intersections = scene.getGeometries().findGeoIntersections(ray);
		 
		 if(intersections == null)
			 return null;
		 
		 return ray.findClosestGeoPoint(intersections);		 
		 
	 }
}
