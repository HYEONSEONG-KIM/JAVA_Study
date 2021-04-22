package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {

	public static void main(String[] args) throws IOException {
		
		// TCP소켓 통신을 하기 위해 ServerSocket객체를 생성
		ServerSocket server = new ServerSocket(7777);
		
		System.out.println("서버가 접속을 기다립니다");
		
		// accept()메서드 => 클라이언트에서 연결 요청이 올 때까지 계속 기다림
		//				=> 연결 요청이 오면 새로운 Socket객체를 생성해서 클라이언트의 Socket과 연결
		Socket socket = server.accept();
		
		// accept()메서드 이후의 명령은 통신 연결이 완료된 이후의 작업을 기술
		System.out.println("클라이언트와 연결되었습니다");
		System.out.println();
		
		System.out.println("연결된 상대방의 정보 출력하기");
		System.out.println("IP : " + socket.getInetAddress().getHostAddress());
		System.out.println("Port : " + socket.getPort());
		System.out.println();
		
		System.out.println("연결된 자신의 정보 출력");
		System.out.println("IP : " + socket.getLocalSocketAddress());
		System.out.println("Port : " + socket.getLocalPort());
		System.out.println();
		
		// 클라이언트에게 메시지 보내기
		// Socket의 OutputStream 객체를 구해서 전송
		// (Socket의 getOutputStream() 메서드 이용)
		
		OutputStream out = socket.getOutputStream();
		// Writer형태의 문자기반으로 보낼수 있지만 data전송으로 쉽게
		DataOutputStream dos = new DataOutputStream(out);
		
		// 클라이언트에게 메세지 보내기(클라이언트로 출력한다고 생각)
		dos.writeUTF("환영합니다!!어서오세요~!!");
		System.out.println("메세지를 보냈습니다");
		
		// 소켓과 스트림 객체 닫기
		dos.close();
		socket.close();
		server.close();
		
	}

}
