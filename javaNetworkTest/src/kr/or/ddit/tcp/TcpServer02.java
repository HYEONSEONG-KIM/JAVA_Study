package kr.or.ddit.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TcpServer02 {

	public static void main(String[] args) throws IOException {
	
		// 서버 소켓을 만들고 대기 중에 클라이언트가 접속해 오면 소켓을 만들어서
		// 메세지를 받는 쓰레드와 메시지를 보내는 쓰레드
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 준비중 입니다...");
		System.out.println("---------------------------------------------------");
		
		Socket socket = server.accept();
		
		ArrayList<Socket> socketList = new ArrayList<>();
		
		
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
	
		sender.start();
		receiver.start();
	
	}

}
