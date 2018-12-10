package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class Packman extends Element{

	private Data data;
	
	public Packman(String[] str) {
		super(str);
	}
	
	public void move(){
		/*
		 * this function should change the coordinates of the
		 * packman so it "moves" 
		 */
	}
	
	@Override
	public Geom_element getGeom() {
		double x = Double.parseDouble(data.getValue("Lon"));
		double y = Double.parseDouble(data.getValue("Lat"));
		double z = Double.parseDouble(data.getValue("Alt"));
		Point3D geom = new Point3D(x,y,z);
		return geom;
	}


}
