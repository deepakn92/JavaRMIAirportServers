import java.rmi.Remote;
//By Deepak Nalla
//8/19/2016
import java.rmi.RemoteException;
public interface PlaceInterface extends Remote {
public PlaceInfo find_place(String city, String state) throws RemoteException;
//public Double returnLat() throws RemoteException;
//public Double returnLon() throws RemoteException;
}
