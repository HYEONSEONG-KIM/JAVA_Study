package kr.or.ddit.udp;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.file.Files;

public class UdpFileServerTeacher {

	public static void main(String[] args) {

		String fileName = "D:/D_Other/test_copy.jpeg";
		long fileSize;	// 전송받은 파일의 전체 길이를 저장할 변수 선언
		long totalReadSize = 0;	// 전송받은 데이터 길이를 누적할 변수 선언
		
		byte[] buffer = new byte[1024];
		
		FileOutputStream fos = null;
		DatagramSocket socket = null;
		
		try {

			System.out.println("서버 준비중...");
			socket = new DatagramSocket(8888);	// UDP소켓 객체 생성
			fos = new FileOutputStream(fileName);	// 파일 출력용 스트림 객체 생성
			
			// 첫번째 데이터 받기(전송될 파일의 전체 길이)
			DatagramPacket dpPacket = new DatagramPacket(buffer, buffer.length);
			socket.receive(dpPacket);
			
			String str = new String(buffer).trim();	// 문자열로 전송된 파일 길이를 문자열로 변환
			fileSize = Long.parseLong(str);
			
			System.out.println("다운로드 시작...");
			int len = 0;	// 수신받은 데이터 길이가 저장될 변수
			while(true){
				socket.receive(dpPacket);
				len = dpPacket.getLength();
				fos.write(buffer, 0, len);
				
				totalReadSize += len;
				
				System.out.println("진행상태 : " + totalReadSize +" / " + fileSize + "Bytes");
				if(totalReadSize == fileSize){
					break;
				}
			}
			fos.flush();
			
			System.out.println("파일 전송 완료...");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(fos != null)try {fos.close();} catch (Exception e2) {}
			if(socket != null) socket.close();
		}
		System.out.println("프로그램 종료...");
		
	}

}


















