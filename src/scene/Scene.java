package scene;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import geometries.Geometries;
import geometries.Intersectable;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.Color;
import primitives.Double3;

/**
 * Scene is a PDS (Plain Data Structure) which means that access to all of its attributes is public 
 * @author Yaakovah, meira, Tali
 */
public class Scene {

	public String name; 
	public Color background;
	public AmbientLight ambientLight;
	public Geometries geometries;
	public LinkedList<LightSource> lights = new LinkedList<LightSource>();
	
	//to be removed
	public void printMaxMin() {
		
		System.out.println("global max X: " + geometries.getMaxX());
		System.out.println("global max Y: " + geometries.getMaxY());
		System.out.println("global min X: " + geometries.getMinX());
		System.out.println("global min Y: " + geometries.getMinY());
	}
	
	public Scene(String name) {
		this.name = name;
		this.background = Color.BLACK;
		this.ambientLight = new AmbientLight(); 
		this.geometries = new Geometries();
	}
	
	/**
	 * 
	 * @return the number of objects in the scene
	 */
	public int getNumberOfObjects() {return geometries.getSize();}

	
	/**
	 * setter
	 * @param color
	 * @return this, according to the builder pattern
	 */
	public Scene setBackground (Color color) { 
		background = color; 
		return this;
	}
	
	/**
	 * setter
	 * @param color
	 * @param ka = attenuation factor
	 * @return this, according to the builder pattern
	 */
	public Scene setAmbientLight (Color color , Double3 ka) {
		this.ambientLight = new AmbientLight(color, ka); 
		return this;
	}
	
	/**
	 * setter
	 * @param ambientLight
	 * @return this, according to the builder pattern
	 */
	public Scene setAmbientLight (AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
		return this;
	}
	
	/**
	 * setter
	 * @param lights
	 * @return this, according to the builder pattern
	 */
	public Scene setLights(LinkedList<LightSource> lights) {
		this.lights = lights;
		return this;
	}
	
	/**
	 * setter
	 * @param geometries
	 * @return this, according to the builder pattern
	 */
	public Scene setGeometries(Intersectable... geometries) {
		this.geometries.add(geometries);
		return this;
	}

	/**
	 * @brief take the current geometries and make it into hierarchial list 
	 */
	public void convertFlatGeometriesToHierarchical()
	{
		//create temp list to put all the geometries in hierarchially
		Geometries tempGeometries = new Geometries();
		
		//for each intersectable in geometries
		for(int i=0;i<getNumberOfObjects();++i)
		{
			boolean joinedAboundary = false;
			
			//check all the goemetries in tempGeometries and see if the 
			//intersectable should be part of that boundary 
			for(int j=0;i<tempGeometries.getSize();++j)
				
				//if the intersectable is in the boundary, add it that region
				if(geometries.geometries.get(i).withinDistance(tempGeometries.geometries.get(j), 35))
					{
						((Geometries)(tempGeometries.geometries.get(j))).add(geometries.geometries.get(i));
						joinedAboundary = true;
					}
			//if didnt add the intersectable to any region yet, add it to a new region
			if(!joinedAboundary)
			{
				tempGeometries.add(new Geometries(geometries.geometries.get(i)));
			}
		}
		
		geometries =  tempGeometries;
	}
	
}


