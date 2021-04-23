package kr.or.ddit.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient02 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// 소켓 객체를 생성해서 서버에 요청을 보내고, 서버와 연결이 완료되면
		// 해당 소켓을 전송용 쓰레드와 수신용 쓰레드에 넣어줌
		
		String serverIp = "192.168.44.26";
		
		try {
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다");
			System.out.println("-----------------------------------------------------");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
			}
}
