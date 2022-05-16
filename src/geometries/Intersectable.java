package geometries;

import java.util.List;


import primitives.Point;
import primitives.Ray;

/**
 * @author Yaakovah
 *
 */
public abstract class Intersectable {
	
	/**
	 * @author Yaakovah
	 * includes a Geometry and a Point
	 *
	 */
	public static class GeoPoint {
	    public Geometry geometry;
	    public Point point;
	    
	    /**
		 * @param g Geometry that we are setting geometry to
		 * @param p Point that we are setting point to
		 */
	    public GeoPoint(Geometry g, Point p)
	    {
	    	geometry = g;
	    	point = p;
	    }
	    
	    @Override
        public boolean equals(Object o) {
	    	
            if (o == this) 
                return true;

            if (!(o instanceof GeoPoint)) 
                return false;

            GeoPoint g = (GeoPoint) o;

            return g.geometry.equals(geometry) && g.point.equals(point);
        }
	    
		@Override
		public String toString() {
			return "(" + geometry.toString() + ", " + point.toString()+ ")";
		}
	
	}


	/**
	 *  
	 * @param ray - a ray that may or may not intersect with the geometry. 
	 * @return - a list of all of the points of intersection or null (in the case that there is no intersection points)
	 * @throws Exception 
	 */
	//public abstract List<Point> findIntersections(Ray ray) throws Exception;
	
	/**
	 * 
	 * @param ray - a ray that may or may not intersect with the geometry. 
	 * @return - a list of all of the GeoPoints of intersection or null (in the case that there is no intersection points)
	 * @throws Exception 
	 *  calls on findGeoIntersectionsHelper to do everything
	 */
	public List<GeoPoint> findGeoIntersections(Ray ray) throws Exception
	{
		return findGeoIntersectionsHelper(ray);
		
	}
	
	/**
	 * @param ray - a ray that may or may not intersect with the geometry. 
	 * @return - a list of all of the GeoPoints of intersection or null (in the case that there is no intersection points)
	 * @throws Exception 
	 * 
	 * called on by findGeoIntersections
	 * 
	 * Note: according to NVI access should be private (and not protected), however, Java does not allow an 
	 * abstract method to be private
	 */
	protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray) throws Exception;
	
}

