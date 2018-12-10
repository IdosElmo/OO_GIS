package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class Fruit extends Element {

	private Data data;
	
	public Fruit(String[] res) {
		super(res);
	}
	
	@Override
	public Geom_element getGeom() {
		double x = Double.parseDouble(data.getValue("Lon"));
		double y = Double.parseDouble(data.getValue("Lat"));
		double z = Double.parseDouble(data.getValue("Alt"));
		Point3D geom = new Point3D(x,y,z);
		return geom;
	}
	
	@Override
	public Meta_data getData() {
		return data; 
	}
	
}