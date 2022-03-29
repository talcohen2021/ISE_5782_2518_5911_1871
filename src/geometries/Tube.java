package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry{
	
	final Ray axisRay;
	final double radius;
	
	/** Constructor to initialize Tube object with a Ray and a double
	 * 
	 * @param axisRay - Ray for the tube
	 * @param radius - radius of the tube
	 */
	public Tube(Ray axisRay, double radius) {
		this.axisRay = axisRay;
		this.radius = radius;
	}

	public Ray getAxisRay()
	{
		return axisRay;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	/** method to get the nomal of the tube from a given point that lies on the tube
	 * 
	 * @param point - point that lays on the body of the tube, where the normal will be from
	 * @throws Exception 
	 */
	public Vector getNormal(Point point) throws Exception {
		// o = projection of Point on cylinder's ray = P0 + v.scale(t)
		//t = distance = v.dotProduct(P-P0)
		double t = this.axisRay.getDir().dotProduct(this.axisRay.getP0().subtract(point));
		Point o = this.axisRay.getP0().add(this.axisRay.getDir().scale(t));
		return point.subtract(o).normalize();
	}

	@Override
	public List<Point> findIntsersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

}
