package kr.or.ddit.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpFileClientTeacher {

	public static void main(String[] args) {
		
		String fileName = "D:/D_Other/test.jpeg";
		String serverIp = "localhost";
		int port = 8888;
		
		File file = new File(fileName);
		if(!file.exists()){
			System.out.println("전송할 파일이 없습니다. 프로그램을 종료합니다");
			return;
		}
		
		long fileSize = file.length();
		long totalReadSize = 0;
		
		DatagramSocket socket = null;
		FileInputStream fis = null;
		try {
			socket = new DatagramSocket();
			InetAddress serverAdd = InetAddress.getByName(serverIp);
			
			// 첫번째로 파일의 길이 전송
			String str = String.valueOf(fileSize);	
			DatagramPacket dpacket = 
					new DatagramPacket(str.getBytes(), str.getBytes().length, serverAdd, port);
			socket.send(dpacket);
			//----------------------------------------------------
			
			fis = new FileInputStream(file);	// 파일을 읽어올 스트림 객체 생성
			byte[] buffer = new byte[1024];		// 파일을 한번에 읽어올 크기 설정
			int len = 0;
			
			// 파일의 내용을 읽어와 전송하기
			while((len = fis.read(buffer)) > 0){
				// 송신용 패킷객체 생성
				dpacket = new DatagramPacket(buffer, len, serverAdd, port);
				socket.send(dpacket);	// 전송 작업
				
				totalReadSize += len;
				System.out.println("진행상태: " + totalReadSize + " / " + fileSize + "Bytes");
		
			}
			System.out.println("파일 전송 완료");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally{
			if(fis != null)try{fis.close();} catch(IOException e){};
			if(socket != null)socket.close();
		}
		
		System.out.println("프로그램 종료...");
		
		
	}

}


















