package geometries;

import java.util.ArrayList;

import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Point;
import primitives.Ray;

public class Geometries extends Intersectable {
	
	public List<Intersectable> geometries;

	public Geometries() {
		//ArrayList instead of LinkedList bc we are mostly accessing
		geometries = new ArrayList<Intersectable>() ; 
		}
	
	public Geometries (Intersectable... geometries) {
		if(geometries == null) 
			return;
		this.geometries = new ArrayList<Intersectable>() ;
		
		for(int i = 0; i < geometries.length; i++) 
			this.geometries.add(geometries[i]);
		
		//this.geometriesList.add(geometries);
		//System.out.println("size in construct");
		//System.out.println(geometriesList.size());

	}
	
	public List<Intersectable> getGeometries(){
		return this.geometries;
	}
	
	public void add(Intersectable... geometries) {
		for(int i = 0; i < geometries.length; i++) {
			this.geometries.add(geometries[i]);
		}
		//System.out.println("size in add");
		//System.out.println(geometriesList.size());
	}

	/*
	@Override
	public List<Point> findIntersections(Ray ray) throws Exception {
		
		if (this.geometries == null)
            return null;
		
		List<Point> listOfIntersections = new ArrayList<Point>(); //bc we are mainly adding
	
		for(int j = 0; j < geometries.size(); j++) {
			List<Point> tempPoints = geometries.get(j).findIntersections(ray);
			
			if (tempPoints != null) {
				for(int i = 0; i < tempPoints.size(); i++) 
                    listOfIntersections.add(tempPoints.get(i));   
			}
		}
		boolean allNull = true;
		
		if (listOfIntersections != null) {
		for(int i = 0; i < listOfIntersections.size(); i++) {
			if(listOfIntersections.get(i) != null) 
				allNull = false;
			}
		}
		
		if((listOfIntersections.size() == 0) || allNull)
			return null;
		
		return listOfIntersections;
	}
	*/
	
	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) throws Exception
	{
		return findGeoIntersectionsHelper(ray);
		
	}
	
	
	@Override
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) throws Exception {
		
		if (this.geometries == null)
            return null;
		
		List<GeoPoint> listOfIntersections = new ArrayList<GeoPoint>(); //bc we are mainly adding
	
		for(int j = 0; j < geometries.size(); j++) {
			List<GeoPoint> tempGeoPoints = geometries.get(j).findGeoIntersections(ray);
			
			if (tempGeoPoints != null) {
				for(int i = 0; i < tempGeoPoints.size(); i++) 
                    listOfIntersections.add(tempGeoPoints.get(i));   
			}
		}
		boolean allNull = true;
		
		if (listOfIntersections != null) {
		for(int i = 0; i < listOfIntersections.size(); i++) {
			if(listOfIntersections.get(i) != null) 
				allNull = false;
			}
		}
		
		if((listOfIntersections.size() == 0) || allNull)
			return null;
		
		return listOfIntersections;
	}
 
}
