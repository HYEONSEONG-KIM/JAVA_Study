package kr.or.ddit.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 송신용, 수신용 패킷 객체 변수 선언
		DatagramPacket inPacket, outPacket;
		
		// 수신 받는 데이터가 저장될 byte형 배열 선언
		byte[] bMsg = new byte[1024];
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			// 접속할 곳의 주소 정보 객체 생성
			InetAddress address = InetAddress.getByName("127.0.0.1");
			
			while(true){
				// 전송할 메세지 입력
				System.out.println("보낼 메세지 입력 : ");
				String msg = scan.nextLine();
				
				if("/end".equals(msg)){	// 끝 메세지 지정
					break;
				}
				
				// 전송할 패킷 객체 생성
				outPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, 8888);
				
				// 전송하기
				socket.send(outPacket);
				
				//--------------------------------------------------------------------------
				
				// 서버에서 온 데이터 받아서 출력하기
				inPacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 수신하기
				socket.receive(inPacket);
				
				String receiveMsg = new String(bMsg).trim();
				
				System.out.println("서버의 응답 데이터 : " + receiveMsg);
				System.out.println();
				
				
			}// while문 끝...
			
			System.out.println("통신 끝...");
		} catch (Exception e) {
		}
	}

}














