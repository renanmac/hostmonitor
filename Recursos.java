import java.io.*;
import java.net.*;
import java.lang.management.ManagementFactory;

public class Recursos implements Serializable{ 
	InetAddress ip;
	String os;
	String arch;
	String user;
	String userhome;
	int proc;
	long jvmmem, maxmemory, freememory;

	public Recursos(Socket s){
	try{		
		com.sun.management.OperatingSystemMXBean mxbean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		ip = s.getInetAddress();
		os = System.getProperty("os.name");
		arch = System.getProperty("os.arch");
		user = System.getProperty("user.name");
		userhome = System.getProperty("user.home");
		jvmmem = Runtime.getRuntime().freeMemory();
		proc = mxbean.getAvailableProcessors();
		maxmemory = mxbean.getTotalPhysicalMemorySize();
		freememory = mxbean.getFreePhysicalMemorySize(); 
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}