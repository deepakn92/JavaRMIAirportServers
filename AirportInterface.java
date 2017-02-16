import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import AirportData.AirportDataProto.AirportList;
public interface AirportInterface extends Remote {
public List<AirportInfo> find_airports(Double lat, Double lon) throws RemoteException;

}
