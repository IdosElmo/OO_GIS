package GIS;

import java.time.Instant;
import java.util.Arrays;

import Coords.myCoords;
import Geom.Point3D;

public class Data implements Meta_data{
	
	private String[] data = null;
	private long UTC;	
//	private String color = null;

	
	/*
	 * Construct a data object with UTC time only.
	 */
	public Data() { 
		this.UTC = Instant.now().toEpochMilli();
	}
	
	/*
	 *Construct a data object with UTC time and information.
	 */
	public Data(String[] str){
		this.data = new String[str.length];
		this.UTC = Instant.now().toEpochMilli();
		for (int i = 0; i < str.length; i++) {
			this.data[i] = str[i];
		}
	}
	
	/*
	 * Get values of type String from data object.
	 */
	public String getValue(String string){
		
		switch(string){
			case "MAC":{ return data[0];}
			case "SSID": return data[1];
			case "AuthMode": return data[2];
			case "FirstSeen": return data[3];
			case "Channel": return data[4];
			case "RSSI": return data[5];
			case "Latitude": return data[6];
			case "Longitude": return data[7];
			case "Altitude": return data[8];
			case "AccuracyMeters": return data[9];
			case "Type": {
				try{
					return data[10];
				}
				catch (ArrayIndexOutOfBoundsException e) {
					return data[0];
				}
			}
//			case "Color": return color;
			case "id": return data[1];
			case "Lat": return data[2];
			case "Lon": return data[3];
			case "Alt": return data[4];
			case "Speed": return data[5];
			case "Weight": return data[5];
			case "radius": return data[6];
		}
		return null;
	}
	
	
	
	/*
	 * Set the coordinates of an Element.
	 */
	public void setCoordinates(Point3D vec){ 
		if(this.data.length == 11){
			Point3D point = new myCoords().meterToGps(vec);
			data[6] = Double.toString(point.y());
			data[7] = Double.toString(point.x());
			data[8] = Double.toString(point.z());
		}
		else {
			Point3D point = new myCoords().meterToGps(vec);
			data[2] = Double.toString(point.y());
			data[3] = Double.toString(point.x());
			data[4] = Double.toString(point.z());
		}
	}
	
	/*
	 * Get the UTC time of this object.
	 */
	@Override
	public long getUTC() {
		return UTC;
	}

	/*
	 * Get the orientation of this object.
	 */
	@Override
	public Point3D get_Orientation() {
		return null;
	}
	
	/*
	 * Print this object.
	 */
	public String toString() {
		return String.join(",", data);
	}


}
