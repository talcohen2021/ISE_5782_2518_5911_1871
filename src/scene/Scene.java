package scene;

import geometries.Geometries;
import geometries.Intersectable;
import lighting.AmbientLight;
import primitives.Color;
import primitives.Double3;

/**
 * Scene is a PDS (Plain Data Structure) which means that access to all of its attributes is public 
 * @author Yaakovah
 * 
 */
public class Scene {

	String name; 
	Color background;
	AmbientLight ambientLight;
	Geometries geometries;
	
	public Scene(String name) {
		this.name = name;
		this.background = Color.BLACK;
		this.ambientLight = new AmbientLight(); //not sure if i should have this here ... ?
		this.geometries = new Geometries();
	}
	
	public Scene setBackground (Color color) { background = color; return this;}
	
	public Scene setAmbientLight (Color color , Double3 ka) {
		this.ambientLight = new AmbientLight(color, ka); 
		return this;
	}
	
	public Scene setGeometries(Intersectable... geometries) {
		
		this.geometries.add(geometries);
		return this;
	}
	
	public Geometries getGeometries() {
		return geometries;
	}
	
	public AmbientLight getAmbientLight() {
		return ambientLight;
	}

	public Color getBackground() {
		return background;
	}

}


