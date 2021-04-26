package kr.or.ddit.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.xml.ws.handler.MessageContext.Scope;


/*
 * 	UDP방식 : 비연결 지향, 신뢰성 없음, 데이터가 순서대로 도착한다는 보장이 없음
 * 			그렇지만 TCP방식보다 속도가 빠름
 * 
 * 	DatagramSocket객체와 DatagramPacket객체를 이용해서 통신
 * 	- DatagramSocket : 데이터의 송신과 수신에 관련된 작업을 수행 (우체부)
 * 	- DatagramPacket : 실제 주고 받는 데이터와 관련된 작업을 수행 (소포나 편지)
 * 		==> 수신을 위한 생성자와 송신을 위한 생성자를 따로 제공함 (매개변수의 개수가 다름)
 * 
 * 
 * 	TCP의 경우에는 스트림을 이용해서 송수신을 했지만,
 * 	UDP의 경우에는 데이터그램을 이용해서 송수신함
 * 
 */


public class UdpServer {

	public static void main(String[] args) {

		try {
			// 통신할 포트번호를 지정하여 소켓을 생성
			DatagramSocket socket = new DatagramSocket(8888);
			
			// 송신용 패킷과 수신용 패킷 객체 변수 선언
			DatagramPacket outpacket, inpacket;
			
			System.out.println("서버 실행 중...");
			
			while(true){
				// 데이터가 저장될 byte형 배열 선언 == 보통 배열의 크기는 512byte 이상으로 설정
				byte[] bMsg = new byte[1024];
				
				// 수신용 패킷 객체 생성
				// 		=> 수신된 데이터가 저장될 byte형 배열, 배열의 길이를 지정해서 생성
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 데이터를 수신 => receive()메서드 이용
				//		이 메서드는 데이터가 올 때까지 기다림
				//		수신된 데이터의 패킷정보는 지정한 패킷변수에 저장됨
				
				socket.receive(inpacket);
				
				// 수신받은 패킷에서 상대방의 주소, 포트번호등을 알 수 있음
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();
				
				System.out.println("상대방의 IP정보 : " + address);
				System.out.println("상대방의 Port번호 : " + port);
				System.out.println();
				
				// 상대방이 보낸 메세지 출력
				// 수신된 데이터는 수신용 패킷을 생성할 때 지정한 byte형 배열에 저장되고, 
				// 		inpacket.getData()메서드로 가져올 수도 있음
				// - 실제 수신된 데이터의 길이는 inpacket.getLength()메서드로 가져옴

				// byte형 배열을 이용하는 방법 => 수신받은byte형 배열의 값들을 문자열로 변한
				// String msg = new String(bMsg, 0, inpacket.getLength());
				
				// getDate()메서드를 이용하는 방법
				String msg = new String(inpacket.getData(), 0, inpacket.getLength());
				
				System.out.println("상대방이 보낸 메세지 : " + msg);
				System.out.println();
				
				//------------------------------------------------------------------------
				
				// 상대방에게 메세지 보내기(수신받은 메세지를 그대로 송신)
				
				// 송신한 메세지를 byte형 배열로 변환
				byte[] sendMsg = msg.getBytes();
				
				// 송신용 패킷객체 생성
				// 	=>  송싱할 데이터가 저장된 byte배열, 송신할 데이터의 길이(배열의 길이),
				//		상대방 주소정보, 상대방 port번호
				//		위 4가지를 지정해서 객체를 생성
				outpacket = new DatagramPacket(sendMsg, sendMsg.length, address, port); 
			
			
				// 송신하기 => send()메서드 이용
				socket.send(outpacket);
				
				System.out.println("송신 완료...");
				
			}	// while문 끝...
			
			
			
			
		} catch (Exception e) {
		
		}
	}

}
































