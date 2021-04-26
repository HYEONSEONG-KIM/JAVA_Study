package kr.or.ddit.udp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpFileServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			
			DatagramSocket socket = new DatagramSocket(8888);
			
			DatagramPacket outpacket, inpacket;
			DataOutputStream dis;
			
			System.out.println("서버 실행중...");
			dis = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("D:/D_Other/테스트_복사본.png")));
			
			byte[] data = new byte[1024];
			inpacket = new DatagramPacket(data, data.length);
			
			
			while(true){
				
			socket.receive(inpacket);
				
			byte[] temp = new byte[1024];
			temp = inpacket.getData();
			
			dis.write(data,0,data.length);
			
			dis.flush();
				
			
			
			
			
			}
		
				
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
