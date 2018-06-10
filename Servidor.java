import java.io.*;
import java.net.*;


public class Servidor{


	public static void main(String s[]){
		while(true){
		try{
			ServerSocket serversocket = new ServerSocket(5555);
			Socket socket = serversocket.accept();
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			Recursos r = new Recursos(socket);
			output.writeObject(r);
			serversocket.close();
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
}