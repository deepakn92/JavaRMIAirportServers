import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.regex.Pattern;;
//By Deepak Nalla
// 8/19/2016
public class Client {

	public static void main(String args[]) {
		
		try {
			int port = 0;
			String url ="";
			boolean portSet =false;
			
		// basic argument count check
		if (args.length < 3 ) {
		System.err.println(
		"usage: java Client  rmiport(default is 1099 which you can enter) stringPlacename stringStateInitials... \n");
		System.exit(1);
		}
		try{ //check for integer type
			port=Integer.parseInt(args[0]);
			portSet=true;}
		
				catch(NumberFormatException e)
		{		}
			 //check to see if args[0] is a string and args[1] and so on..
			//We are assuming rmiregistryserver is going to be localhost always as based on our implementation
			 
			 if (args[2].length()>=3){ //checks case if state initials are longer than two letters
			
				 System.out.print("Please enter a State name with at most 2 letter- initials ");
				 System.exit(1);			 }
		 if(args.length>3){
			 System.out.print("\n Too many arguments. Need to enter town/place name in double quotes if it is more than one word, which is always in my implementation. Try again: usage: java Client rmihost(optional) rmiport(optional) stringPlacename stringStateInitials \n");
			 System.exit(1);
		 }

		
		
		if(!portSet){ //set port to defined rmi port 1099
			Registry registry = LocateRegistry.getRegistry(1099);
		 url = "//localhost" + ":" + "/Places";}
		 
			 Registry registry = LocateRegistry.getRegistry(port);
			 url = "//localhost" + ":" +port + "/Places";
	
		
		System.out.println("looking up " + url);
		// look up the remote object named “Places”

		PlaceInterface Places = (PlaceInterface)registry.lookup(url);  
		PlaceInfo place = Places.find_place(args[1], args[2]);
		System.out.print(Places.find_place(args[1], args[2]));

//port for airport server is set because there wasn't a way for me to bring the port number from airportServer back to the client as it was an int, and not a remote object. Only possible way would be to take it as a static value.
//Actually implemented it -- Well tried to but could not get it to work.^^
		int port2 = 1099;         //AirportServer.returnPortNum();
		String url2 = "//localhost" + ":" + port2 + "/Airports";
		System.out.println("looking up " + url2);
	   
		AirportInterface Airports = (AirportInterface)Naming.lookup(url2);  
		System.out.print(Airports.find_airports(place.lat,place.lon));
		// call the remote method and print the return
		} catch(Exception e) {
		System.out.println("SampleClient exception: " + e);
		}
		}
		}