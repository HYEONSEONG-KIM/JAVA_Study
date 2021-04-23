package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

// 소켓에서 메시지를 받아 화면에 출력하는 역할
public class Receiver extends Thread {
	
	private Socket socket;
	private DataInputStream dis;
	
	public Receiver(Socket socket) {
		this.socket = socket;
		
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(dis != null){
			try {
				System.out.println(dis.readUTF());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}





















