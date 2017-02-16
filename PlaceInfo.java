
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public  class PlaceInfo implements Serializable
//By Deepak Nalla
//8/19/2016
{
	/**
	 * 
	 */	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name = "";
	String state = "";  
	Double lat= null;
	Double lon= null;
	String str ="";
	public PlaceInfo(String name, String state, Double lat, Double lon) throws RemoteException{
		this.name = name;
		this.state = state;
		this.lat = lat;
		this.lon = lon;
		// str ="";
	}
	@Override
	public String toString(){
	return str = this.name + "," + this.state + ":" + this.lat + "," + this.lon;
	}
	public String getPlaceName() {
		return name;
	}
	public void setPlaceName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}

}

