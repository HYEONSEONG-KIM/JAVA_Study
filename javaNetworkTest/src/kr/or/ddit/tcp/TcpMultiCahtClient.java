package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

//kr.or.ddit.tcp.TcpMultiCahtClient
public class TcpMultiCahtClient {
	
	public static void main(String[] args) {
		
		new TcpMultiCahtClient().clientStart();
	}
	
	private void clientStart(){
		Socket socket = null;
		try {
			String serverIp = "sem-pc";
			socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다...");
			ClicentSender sender = new ClicentSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
			//------------------------------------------------
			
			
			
			
		} catch (Exception e) {
		}
	}
	
	// -------------------------------------------------
	// 메세지 전송용 쓰레드
	class ClicentSender extends Thread{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private String name;
		private Scanner scan;
		
		public ClicentSender(Socket socket) {
			this.socket = socket;
			scan = new Scanner(System.in);
		
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				
				// dos가 null이란 것은 socket 객체에서 스트림을 못받아 온거므로 socket이 끊어진 상태
				if(dos != null){
					// 클라이언트용 프로그램은 처음 실행하면 서버에 접속하고 접속에 성공하면
					// 첫번째로 이름을 입력받아 전송, 이름의 중복여부를 feedBack으로 받아서 확인
					System.out.print("대화명 : ");
					String name = scan.nextLine();
					
					while(true){
						dos.writeUTF(name);	// 대화명 전송
						
						// 대화명 중복 여부의 feedback을 응답으로 받음
						String feedBack = dis.readUTF();
						if("이름중복".equals(feedBack)){
							System.out.println(name + "은 대화명이 중복됩니다");
							System.out.println("다른 대화명을 입력하세요");
							System.out.print("대화명 : ");
							name = scan.nextLine();
						}else{
							this.name = name;
							System.out.println(name + " 대화명으로 대화방에 입장했습니다");
							break;
						}
					}	// while문 끝...
				}
			} catch (Exception e) {
			}
		
		}	// 생성자 끝...
		
		@Override
		public void run() {
			try {
				while(dos != null){
					// 키보드로 입력한 메세지를 서버로 전송
					dos.writeUTF("[ " + name +"]" + scan.nextLine() );
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	// 메세지 수신용 쓰레드
	class ClientReceiver extends Thread{
		private Socket socket;
		private DataInputStream dis;

		// 생성자
		public ClientReceiver(Socket socket){
			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
			}
		}
		
		@Override
		public void run() {
			try{
				while(dis != null){
					// 서버로부터 받은 메세지를 화면에 출력
					System.out.println(dis.readUTF());
				}
				
			}catch(Exception e){}
			
		}
	}
}





































