package geometries;

import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.*;

//?import primitives;
public abstract class Geometry extends Intersectable{
	
	protected Color emission = Color.BLACK;
	private Material material = new Material();
	/**
	 * @param Point point on the geometry
	 * @return The vector that is perpendicular to the geometry starting at the point
	 * @throws Exception 
	 */
	public abstract Vector getNormal(Point p) throws Exception;
	
	/**
	 * @return the emission color for the geometry
	 */
	public Color getColor() {return emission;}
	
	/**
	 * @param c the color that we want to set emission to
	 * @return this (according to the builder pattern)
	 */
	public Geometry setColor(Color c) {emission = c; return this;}
	
	/**
	 * getter
	 * @return material
	 */
	public Material getMaterial() {
		return material;
	}
	
	/**
	 * setter
	 * @param material
	 * @return this
	 */
	public Geometry setMaterial(Material material) {
		this.material = material;
		return this;
	}
	
	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) throws Exception
	{
		return findGeoIntersectionsHelper(ray);
		
	}
	
	@Override
	protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray) throws Exception;

	
	
}

