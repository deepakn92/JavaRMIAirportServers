import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
//By Deepak Nalla
//8/19/2016

public class AirportServer {
//	private static int port = 0;

public static void main(String args[]) {
if (args.length != 1) {
System.err.println("usage: java SampleServer rmi_port. Enter a valid port. Default Rmi port is 1099-You may enter this.");
System.exit(1);
}
	try {
	// first command-line arg: the port of the rmiregistry
	int port =  Integer.parseInt(args[0]); 
	// create the URL to contact the rmiregistry
	Registry registry = LocateRegistry.getRegistry(port);
	//setPortNum(port);
	String url = "//localhost:" + port + "/Airports";
	System.out.println("binding " + url);
	// register it with rmiregistry

	registry.rebind(url, new Airports());
	 registry.rebind("Airports", new Airports());
	System.out.println("server " + url + " is running...");
	}
	catch (Exception e) {
	System.out.println("Airports server failed:" +
	e.getMessage());
	
	}}}
//	public static void setPortNum(int port){
//	 AirportServer.port = port;
//	}
//	public static int returnPortNum()
//	{
//		return AirportServer.port;
//	}
//	
//	}