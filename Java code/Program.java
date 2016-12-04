import java.util.Scanner;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.io.IOException;
import java.net.DatagramPacket;
public class Program {

	public static void main(String[] args) throws IOException {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = scanner.nextLine();
		
		System.out.print("Source Port: ");
		int sourcePort = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Destination IP: ");
		String destinationIP = scanner.nextLine();
		
		System.out.print("Destination Port: ");
		int destinationPort = Integer.parseInt(scanner.nextLine());
		
		
		Channel channel = new Channel();
		channel.bind(sourcePort);
		channel.start(); // Start Receive
		System.out.println("Started.");
		
		InetSocketAddress address = new InetSocketAddress(destinationIP, destinationPort);
		
		while (true)
		{
		
			String msg = scanner.nextLine();
			
			if(msg.isEmpty())
				break;
		msg = name + " >> " + msg;
		
		channel.sendTo(address, msg);
		System.out.println(msg);
		}
		scanner.close();
		channel.stop();
		System.out.println("Closed.");
	}

}
