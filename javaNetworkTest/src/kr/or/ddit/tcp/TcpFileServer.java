package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpFileServer {

	private ServerSocket server;
	private Socket socket;
	private DataInputStream dis;
	private BufferedOutputStream bos;
	
	private void serverStart() throws IOException{
		
		File file = new File("D:/D_Other/연습용");
		
		if(!file.exists()){
			file.mkdirs();	//없으면 폴더 생성
		}
		try {
			// 바이트, 문자 =>  
			// data => 
			
			server = new ServerSocket(7776);
			System.out.println("대기중...");
			socket = server.accept();
			
			System.out.println("파일 다운로드 시작...");
			
			// 소켓을 이용한 수신용 스트림 객체 생성
			dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			String fileName = dis.readUTF();
			
			File saveFile = new File(file, fileName);
			
			// 파일 저장용 스트림 객체 생성
			bos =  new BufferedOutputStream(
					new FileOutputStream(saveFile)
					);
			
			// 소켓으로 데이터를 수신 받아서 파일로 저장
			byte[] temp = new byte[1024];
			int len = 0;
			
			while((len = dis.read(temp)) > 0){
				
				bos.write(temp, 0 ,len);
				
			}
			bos.flush();
			System.out.println("파일 다운로드 완료...");
		
			
			/*int c;
			
			while((c = dis.read()) != -1){
				bos.write(c);
			}*/
		} catch (Exception e) {
			
			System.out.println("다운로드 실패");
		
		}finally{
			if(bos != null) try{bos.close();}catch (Exception e) {}
			if(dis != null) try{dis.close();}catch (Exception e) {}
			if(socket != null) try{socket.close();}catch (Exception e) {}
		}
		
		bos.close();
		dis.close();
		socket.close();
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		/*
		 *	서버와 클라이언트가 접속이 완료되면
		 *	클라이언트가 'D:/D_Other/펭귄.jpg' 파일을 서버로 전송
		 *	서버는 클라이언트가 전송한 파일을 받아서 'D:/D_Other/연습용' 폴더에 저장
		 */
		
		
		new TcpFileServer().serverStart();
		
	}

}
