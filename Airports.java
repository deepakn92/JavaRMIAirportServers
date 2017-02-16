import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import AirportData.AirportDataProto.Airport;
import AirportData.AirportDataProto.AirportList;
//By Deepak Nalla
//8/19/2016

public class Airports extends UnicastRemoteObject implements AirportInterface, Comparable <AirportInfo>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7236309878969633076L;


	public Airports() throws RemoteException{
	}
	
	public List<AirportInfo> find_airports(Double lat, Double lon) throws RemoteException{
		AirportList airportList =null;
		try { 
			airportList = AirportList.parseFrom(new FileInputStream("AirportData/airports-proto.bin"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("The data file could not be read. Please fix your path, and try again." );
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("The data file could not be read. This might have occured due to an I/O error." );

		}	
		//The code below is going to take the airport list, iterate through each listing, and calculate the distance for said
		//listing to the city's latitude/longitude coordinates taken at the prompt. It will then store this distance along 
		List<Airport> airportInfoTable = airportList.getAirportList();
		ArrayList<AirportInfo> airportInfo = new ArrayList <AirportInfo>();
		for(int index =0; index<airportInfoTable.size();index++){
			lat = Math.toRadians(lat);
			lon = Math.toRadians(lon);
			Double airportLat = Math.toRadians(airportInfoTable.get(index).getLat());
			Double airportLon = Math.toRadians(airportInfoTable.get(index).getLon());
			
			
			Double distance = 60*Math.acos(((Math.sin(lat)*Math.sin(airportLat)) + (Math.cos(lat)*Math.cos(airportLat) *Math.cos(airportLon - lon)) ));
					
	airportInfo.add(index,new AirportInfo (airportInfoTable.get(index).getCode(), airportInfoTable.get(index).getName(), airportInfoTable.get(index).getLat(), airportInfoTable.get(index).getLon(), distance));
		} //Now we sort the list based on the distance, and create a loop to return a list of 5 closest airports.
		//sort the arrayList before returning it
		Collections.sort(airportInfo, new Comparator<AirportInfo>()
		{  @Override
			public int compare(AirportInfo a, AirportInfo b){
			return a.getDistance() - b.getDistance();
		}
		});
		ArrayList<AirportInfo> fiveAirports = new ArrayList <AirportInfo>();
		System.out.println("The 5 closest airports to the location are:");
		for(int i =0; i<5; i++){
			fiveAirports.add(airportInfo.get(i));
			System.out.println((i+1)+")"+airportInfo.get(i)+"\n");
		}

			
		//returns the five airports
		return fiveAirports ;
	}


//	@Override
//	public String find_airport(double lat, double lon) throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}


	@Override
	public int compareTo(AirportInfo o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int returnPortNum(int portNum) throws RemoteException
	{
		return portNum;
	}





	
}
