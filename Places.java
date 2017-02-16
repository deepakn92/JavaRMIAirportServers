import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import PlaceData.PlaceDataProto.Place;
import PlaceData.PlaceDataProto.PlaceList;
//By Deepak Nalla
//8/19/2016

@SuppressWarnings("serial")

public class Places extends UnicastRemoteObject implements  PlaceInterface {

 public Places(String cityName, String stateName) throws RemoteException{
	}

@Override
public PlaceInfo find_place(String city, String state) throws RemoteException {
	PlaceList placeList = null;
	try { 
		placeList = PlaceList.parseFrom(new FileInputStream("PlaceData/places-proto.bin"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("The data file could not be read. Please fix your path, and try again." );
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("The data file could not be read. Please fix your path, and try again." );

	}
	List<Place> placeInfoTable
			=  placeList.getPlaceList();
	// Compare and find place that matches command line argument.
	for (Place place: placeInfoTable) {
		if(city.regionMatches(true, 0, place.getName(), 0, city.length())){ //place.getName().length())
//		this.lat=place.getLat();
//		this.lon= place.getLon();
			PlaceInfo placeInfo= new PlaceInfo(place.getName(),place.getState(),place.getLat(),place.getLon());
			System.out.println("\nSUCCESS\n"); //Lets user know search was a success
			return placeInfo;
		}	}
	System.out.println("\n No match found for the name of the place; TRY AGAIN. \n");
	return null;
	
	}}


	// *UN-NECESSSARY*TEST: Method that creates a List<Place> data structure to store the records
//public List<Place> createTable(PlaceList placeList){
//	List<Place> placeInfoTable;
//	placeInfoTable = placeList.getPlaceList();
////	for (Place place: placeInfoTable) { //For Testing purposes to try different place names.
////        System.out.println(place);}
//	return placeInfoTable;}




