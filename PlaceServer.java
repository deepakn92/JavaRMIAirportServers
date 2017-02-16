import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class PlaceServer {
public static void main(String args[]) {
if (args.length != 1) { //catch when no arguments
System.err.println("usage: java SampleServer rmi_port");
System.exit(1);
}
	int port =0;
	try {
	// first command-line arg: the port of the rmiregistry
try{
	port = Integer.parseInt(args[0]);	}
catch (NumberFormatException e)
{};
//Call rmiregistry from Terminal and then you can get the port below and attach it to a registry object
Registry registry = LocateRegistry.getRegistry(port); 
	String url = "//localhost:" + port + "/Places"; // create the URL to contact the rmiregistry
	System.out.println("binding " + url);
	registry.rebind(url, new Places(null,null));
	 registry.rebind("Places", new Places(null, null));

	// register it with rmiregistry
	//Naming.rebind(url, new Places(null, null));
	// Naming.rebind("Places", new Places(null, null));
	System.out.println("server " + url + " is running...");
	}
	catch (Exception e) {
	System.out.println("Sample server failed:" +
	e.getMessage());
	}
	}
	}