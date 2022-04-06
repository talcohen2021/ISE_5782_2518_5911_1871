package geometries;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import primitives.Double3;
import primitives.Point;
import primitives.Ray;

public class Geometries implements Intersectable {
	
	public List<Intersectable> geometries;

	public Geometries() {
		//ArrayList instead of LinkedList bc we are mostly accessing
		this.geometries = new ArrayList<Intersectable>(); 
		}
	
	
	//public Geometries (Intersectable... geometries) {
		//this.geometries = new ArrayList<Intersectable>(); 
		//this.geometries.addAll(geometries);

	//}
	
	
	public void add(Intersectable... geometries) {
		if (geometries == null) 
           this.geometries = new ArrayList<>(List.of(geometries));
		Collections.addAll(this.geometries, geometries);    
       
	}

	@Override
public List<Point> findIntersections(Ray ray) throws Exception {
		
		if (geometries == null) {
            return null;
        }
		List<Point> listOfIntersections = new LinkedList<Point>(); //bc we are mainly adding

		Iterator<Intersectable> geometryIterator = geometries.iterator();
		while(geometryIterator.hasNext())
		{
			System.out.println("in while loop");
			List<Point> tempPoints = geometryIterator.next().findIntersections(ray);
			//System.out.println(tempPoints.get(0));
			if (tempPoints != null) {
				System.out.println("in outer if ");
                // otherwise, initialize with a list when first intersection found
                if (listOfIntersections == null) {
                	System.out.println("in Inner if ");
                    listOfIntersections = new ArrayList<>(tempPoints);
                    continue;
                }
                listOfIntersections.addAll( tempPoints);
                System.out.println("bottom of outer if ");
			}
		}
		
		if(listOfIntersections.isEmpty())
			return null;

		return listOfIntersections;
	}
 
}
