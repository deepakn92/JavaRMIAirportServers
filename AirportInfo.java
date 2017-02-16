
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import AirportData.AirportDataProto.AirportList;

//By Deepak Nalla
//8/19/2016

public class AirportInfo implements Serializable, Comparable <AirportInfo>, List<AirportInfo>
{
	/** By Deepak Nalla ; AirportInfo is a class that stores all the information contained in the Airport List from the binary file given to us
	 * and it parses that and stores it in a data structure called AirportInfoTable against which I will compare the latitude and longitude given to me 
	 * in Airports.java from Client.java and I will store the distance of each Airport into
	 * 
	 *
	 * 
	 */
	private static final long serialVersionUID = 12L;
	String code = "";  
	String name = "";
	Double lat= null;
	Double lon= null;
	double distance = 0.00;
    String str ="";
	
	public AirportInfo(String code,String name, Double lat, Double lon, Double distance) throws RemoteException{
		this.name = name;
//		this.state  = state;
		this.lat = lat;
		this.lon = lon;
		this.code = code;
		this.distance = distance;
	}
	@Override
	public String toString(){
	return str = this.code + "," + this.name + ":" + this.lat + "," + this.lon + "," + this.distance;
	}
	public String getPlaceName() {
		return name;
	}
	public void setPlaceName(String name) {
		this.name = name;
	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
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
	public Integer getDistance(){
		return (int)distance;
	}
	@Override
	public int compareTo(AirportInfo o) {
		
		return 0;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<AirportInfo> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(AirportInfo e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends AirportInfo> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends AirportInfo> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public AirportInfo get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AirportInfo set(int index, AirportInfo element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void add(int index, AirportInfo element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public AirportInfo remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<AirportInfo> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator<AirportInfo> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<AirportInfo> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}