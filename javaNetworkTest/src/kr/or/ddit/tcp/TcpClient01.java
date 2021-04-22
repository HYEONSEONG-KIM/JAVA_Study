package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {

		// 현재 자신 컴퓨터를 나타내는 방법
		// 1) 원래의 IP주소 : ex) 192.168.44.xx
		// 2) 지정된 IP주소 : 127.0.0.1
		// 3) 원래의 컴퓨터 이름 : ex)PC21
		// 4) 지정된 컴퓨터 이름 : localhost
		
		String serverIp = "localhost";
		System.out.println(serverIp + "서버에 연결 중 입니다...");
		System.out.println();
		
		// 서버의 IP주소와 Port번호를 지정하여 Socket객체를 생성
		// Socket객체는 생성이 완료되면 지정된 서버로 요청신호를 자동으로 보냄
		Socket socket = new Socket(serverIp,7777);
		
		// 서버와 연결된 이후에 처리될 내용을 기술(서버가 대기하고 있지 않으면 이부분은 실행 되지않고 에러 메세지 출력)
		
		//InputStream객체를 생성(Socket 이용)
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		// 서버에서 보내온 자료를 읽어온다고 생각
		System.out.println("서버에서 보내온 메세지 : " + dis.readUTF());
		System.out.println();
		
		System.out.println("연결을 종료합니다");
		
		// 스트림 닫기
		dis.close();
		socket.close();
	}
	
	
	

}
