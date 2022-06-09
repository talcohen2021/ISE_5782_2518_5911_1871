package geometries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Point;
import primitives.Ray;

/**
 * 
 * @author Yaakovah, Meira, Tali
 *	uses composite pattern(along with geometry and intersectable) to treat a single object and a list of that object the same
 */
public class Geometries extends Intersectable {
	
	public List<Intersectable> geometries;

	public Geometries() 
	{
		
		//ArrayList instead of LinkedList bc we are mostly accessing
		geometries = new ArrayList<Intersectable>() ; 
		
	}
	
	public Geometries (Intersectable... geometries) 
	{
		if(geometries == null) 
			return;
		
		this.geometries = new ArrayList<Intersectable>() ;
		
		for(int i = 0; i < geometries.length; i++) 
			this.geometries.add(geometries[i]);

	}
	
	public List<Intersectable> getGeometries()
	{
		return geometries;
	}
	
	/**
	 * @brief adds all of the intersectables that it receives to "geometries" (its list of intersectables)
	 * @param geometries = 0 or more intersectables
	 */
	public void add(Intersectable... geometries) 
	{
		for(int i = 0; i < geometries.length; i++) 
			this.geometries.add(geometries[i]);
	}
	
	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) throws Exception
	{
		return findGeoIntersectionsHelper(ray);	
	}
	
	@Override
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) throws Exception {
		
		if (geometries == null)
            return null;
		
		//LinkedList bc we are mainly adding
		List<GeoPoint> listOfIntersections = new LinkedList<GeoPoint>(); 
		
		for(int j = 0; j < geometries.size(); j++) {
			
			//making a temporary list to store intersections for each intersectable
			List<GeoPoint> tempGeoPoints = new ArrayList<GeoPoint>(); //adding and also accessing
			tempGeoPoints = geometries.get(j).findGeoIntersections(ray);
			
			//if there were intersection(s) with the currect intersectable, add it/them to listOfIntersections
			if (tempGeoPoints != null) 
				for(int i = 0; i < tempGeoPoints.size(); i++) 
                    listOfIntersections.add(tempGeoPoints.get(i));   
		}
		
		//as per the hw instructions, if there are no intersection we need to return null, and not an empty list
		if( listOfIntersections.size() == 0)
			return null;
		
		return listOfIntersections;
	}
}
