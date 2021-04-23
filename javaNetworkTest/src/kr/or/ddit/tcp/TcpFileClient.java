package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpFileClient {

	private Socket socket;
	private BufferedInputStream bis;
	private DataOutputStream dos;
	
	private void clientStart() throws UnknownHostException, IOException{
		
		
		File file = new File("D:/D_Other/테스트.png");
		String fileName = file.getName(); //파일 이름 구하기
		
		if(!file.exists()){ //전송할 파일이 있는지 검사
			System.out.println(fileName + "파일이 없습니다");
			return;
		}
		socket = new Socket("localhost", 7776);
		System.out.println("파일전송 시작...");
		
		/*OutputStream out = socket.getOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);*/
		
		/*OutputStream out = socket.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		DataOutputStream d = new DataOutputStream(bos);
		
		OutputStream out2 = socket.getOutputStream();
		DataOutputStream d2 = new DataOutputStream(out2);
		BufferedOutputStream b2 = new BufferedOutputStream(d2);*/
		
		dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		
		
		// 이미지를 지정한 경로에서 파일을 읽어오는 코드
		bis = new BufferedInputStream(
			new FileInputStream(file)
			);
		
		
		
		// 서버와 연결되면 첫번째로 파일 이름을 전송
		dos.writeUTF(fileName);
		dos.flush();
		
		// 파일 내용을 읽어와 소켓을 통해서 전송
		
		byte[] temp = new byte[1024];
		int len = 0;
		
		while((len = bis.read(temp)) > 0){	// 파일 내용 읽기
			dos.write(temp, 0, len);				// 소켓으로 출력
		}
		
		dos.flush();
		System.out.println("파일 전송 끝...");
		/*int c;
		
		while((c = bis.read()) != -1){
			dos.write(c);
		}*/
		
		bis.close();
		dos.close();
		socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new TcpFileClient().clientStart();
	}

}










