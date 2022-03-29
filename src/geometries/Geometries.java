package geometries;

import java.util.ArrayList;
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
	
	
	public Geometries (Intersectable geometries) {
		this.geometries = new ArrayList<Intersectable>(); 
		this.geometries.add(geometries);

	}
	
	
	public void add(Intersectable geometries) {
		this.geometries.add(geometries);
	}

	@Override
	public List<Point> findIntsersections(Ray ray) {
		
		List<Point> listOfIntersections = new LinkedList<Point>(); //bc we are mainly adding

		Iterator<Intersectable> geometryIterator = geometries.iterator();
		while(geometryIterator.hasNext())
		{
			Intersectable i = (Intersectable)geometryIterator.next();
			return listOfIntersections.add(i.findIntsersections(ray));
		}
		//The method shall return a collection of intersection points for all the shapes in the collection.
		//If there are no intersection points, it should return null.
		return null;
	}
 
}
