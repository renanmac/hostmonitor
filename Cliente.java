import java.io.*;
import java.net.*;

public class Cliente{
	
	public static void main(String s[]){
		try{
			Socket socket = new Socket("localhost", 5555);
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			Recursos info = (Recursos)input.readObject();
			System.out.println("Endereço ip: "+info.ip);
			System.out.println("Sistema operacional: "+info.os);
			System.out.println("Arquitetura: "+info.arch);
			System.out.println("Usuário: "+info.user);
			System.out.println("Diretório Home do Usuário: "+info.userhome);
			System.out.println("Número de processadores: "+info.proc);
			System.out.println("Memória disponível JVM: "+info.jvmmem);
			System.out.println("Memória Total: "+info.maxmemory);
			System.out.println("Memória Livre: "+info.freememory);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}