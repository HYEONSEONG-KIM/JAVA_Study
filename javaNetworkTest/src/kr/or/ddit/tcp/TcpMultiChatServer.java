package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	
		// 접속한 클라이언트 정보를 저장할 Map객체 변수 선언
		// 		==> Key값 : 접속한 사람 이름, value값 : 접속한 Socket객체
		private Map<String, Socket> clientMap;
		
		// 생성자
		public TcpMultiChatServer() {
			// clientMap을 동기화 처리가 되도록 생성
			clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
			
		}
		
		public static void main(String[] args) {
			
			new TcpMultiChatServer().serverStart();
			
		
		}
	// 서버 시작 메서드
	private void serverStart(){
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다...");
			
			while(true){
				socket = server.accept();	// 클라이언트의 접속을 기다림
				System.out.println("[ " + socket.getInetAddress() + " : " + socket.getPort()
							+ "] 에서 접속했습니다...");
				System.out.println();
				//--------------------------------------------------
				
				ServerReceiver serverThread = new ServerReceiver(socket);
				serverThread.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// serverStrat() 메서드 끝...
	}
	
	// clientMap에 저장된 전체 사용자에게 메세지를 전송할 메서드
	private void sendToAll(String msg){
		// clientMap의 데이터 개수만큼 반복(key값(이름) 개수만큼 반복)
		for(String name : clientMap.keySet()){
			try {
				// key값을 이용해서 그에 대응하는 socket객체를 구한 후 , 해당 Socket의 출력용 스트림객체를 사용
				DataOutputStream dos = 
						new DataOutputStream(clientMap.get(name).getOutputStream());
				dos.writeUTF(msg);
			} catch (Exception e) {
			}
		}
	}
	
	//----------------------------------------------------------
	// Inner Class로 서버에서 클라이언트로 메세지를 전송하는 Thread를 작성
	//  => outter class의 멤버변수를 자유롭게 사용하기 위해서...
	class ServerReceiver extends Thread{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		// 생성자
		public ServerReceiver(Socket socket){
			this.socket = socket;
			try {
				// 수신용
				dis = new DataInputStream(socket.getInputStream());
				
				// 송신용
				dos = new DataOutputStream(socket.getOutputStream());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		@Override
		public void run() {
			String name = "";
			try {
				// 클라이언트가 보내온 '사용자의 이름'이 중복되지 않을때 까지 반복
				while(true){
					// 클라이언트가 연결이 성공되면 첫번째로 '사용자의 이름'을 보냄
					// 서버에서는 이 '사용자의 이름'이 중복되는지 의 여부를 응답(feedBack)으로 클라이언트에게 보내줌
					name = dis.readUTF(); //이름
					
					if(clientMap.containsKey(name)){
						dos.writeUTF("이름중복");
					}else{	//이름이 중복되지 않을 때
						
						dos.writeUTF("OK");
						break;
					}
				}
				
				// 접속한 사람의 이름을 다른 전체 클라이언트에게 환영 메세지를 전송
				sendToAll("[ " + name + "] 님이 대화방에 입장했습니다.");
				
				// clientMap에 '사용자 이름'과 접속한 Socket 추가
				clientMap.put(name, socket);
				
				System.out.println("현재 접속자 수 : " + clientMap.size() + "명");
				
				// 한 클라이언트가 보낸 메세지를 받아서 전체 클라이언트에게 보냄
				while(dis != null){
					sendToAll(dis.readUTF());
				}
				
			} catch (Exception e) {
			}finally{
				//이 영역이 실행된다는 것은 클라이언트가 접속을 종료했다는 의미
				sendToAll("[ " + name + "] 님이 접속을 종료했습니다");
				
				// clientMap에서 삭제
				clientMap.remove(name);
				System.out.println("[ " + socket.getInetAddress() + " : " + socket.getPort()
						+ " ]에서 접속을 종료했습니다");
				
				System.out.println("현재 접속자 수 : " + clientMap.size() + "명");
				System.out.println();
				
			}
			
		
		}
		
		
	}
	
}
























