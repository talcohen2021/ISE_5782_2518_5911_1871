package primitives;

public class Ray {
	
	final Point p0;
	final Vector dir;
	
	//?@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Ray))
			return false;
		Ray other = (Ray) obj;
		return false; //to be done properly (placeholding)
	}
	
	//?@Override
	public String toString() {
		return null;
		//to do
	}

}
