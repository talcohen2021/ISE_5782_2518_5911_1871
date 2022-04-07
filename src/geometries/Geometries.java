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
		
		if (this.geometriesList == null) {
            return null;
        }
		
		List<Point> listOfIntersections = new ArrayList<Point>(); //bc we are mainly adding
		//List<Point> tempPoints = new ArrayList<Point>();
		for(int j = 0; j < geometriesList.size(); j++){
			//System.out.println("size in find intersections");
			//System.out.println(listOfIntersections.size());
			
			List<Point> tempPoints = geometriesList.get(j).findIntersections(ray);
			//tempPoints.add((Point) geometriesList.get(j).findIntersections(ray));
			//System.out.println("size in find of temp");
			//System.out.println(tempPoints.size());
			//if (tempPoints == null) { continue;
			//}
			if (tempPoints != null) {
				//System.out.println("in if temp sixe");
				//System.out.println(tempPoints.size());
				for(int i = 0; i < tempPoints.size(); i++) {
                    listOfIntersections.add(tempPoints.get(i));
                    //System.out.println("in for adding to listofinter");
                   // System.out.println(i);
                    //System.out.println(listOfIntersections.size());
                }
                
			}
		}
		if (listOfIntersections != null) {
		for(int k = 0; k < listOfIntersections.size(); k++) {
			//System.out.println("in j loop after first for");
			//System.out.println(listOfIntersections.get(k));
			}
		}
		boolean allNull = true;
		if (listOfIntersections != null) {
		for(int i = 0; i < listOfIntersections.size(); i++) {
			if(listOfIntersections.get(i) != null) {
				//System.out.println(listOfIntersections.get(i));
				allNull = false;
				}
			}
		}
		if((listOfIntersections.size() == 0) || allNull) {
			//System.out.println("I'm null after all");
			return null;
		}
		//System.out.println("returning list");
		return listOfIntersections;
	}
 
}
