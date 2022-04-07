package geometries;

import java.util.ArrayList;

import java.util.List;
import primitives.Point;
import primitives.Ray;

public class Geometries implements Intersectable {
	
	public List<Intersectable> geometriesList =  new ArrayList<Intersectable>();

	//public Geometries() {
		//ArrayList instead of LinkedList bc we are mostly accessing
		//this.geometriesList = null; 
		//}
	
	//??
	public Geometries (Intersectable... geometries) {
		if(geometries == null) {
			return;
		}
		for(int i = 0; i < geometries.length; i++) {
			this.geometriesList.add(geometries[i]);
		}
		//this.geometriesList.add(geometries);
		//System.out.println("size in construct");
		//System.out.println(geometriesList.size());

	}
	
	public List<Intersectable> getGeometries(){
		return this.geometriesList;
	}
	
	public void add(Intersectable... geometries) {
		for(int i = 0; i < geometries.length; i++) {
			geometriesList.add(geometries[i]);
		}
		//System.out.println("size in add");
		//System.out.println(geometriesList.size());
	}

	@Override
	public List<Point> findIntersections(Ray ray) throws Exception {
		
		if (this.geometriesList == null)
            return null;
		
		List<Point> listOfIntersections = new ArrayList<Point>(); //bc we are mainly adding
	
		for(int j = 0; j < geometriesList.size(); j++) {
			List<Point> tempPoints = geometriesList.get(j).findIntersections(ray);
			
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
 
}
