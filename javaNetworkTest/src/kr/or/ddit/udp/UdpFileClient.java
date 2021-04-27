package kr.or.ddit.udp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

// 클라이언트는 서버에 접속하면  'D:/D_Other/테스트.png' 파일을 서버로 전송
// 클라이언트가 보낸 파일 파일 데이터를 받아서 'D:/D_Other/테스트_복사본.png'파일로 저장
public class UdpFileClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		DatagramPacket inpacket,outPacket;
		BufferedInputStream bis;
		File inFile = null;
		
		JFileChooser fileChooser = new JFileChooser();
		
		// 파일 선택창에 나타날 폴더 설정
		fileChooser.setCurrentDirectory(new File("D:/D_Other"));
		
		int result = fileChooser.showOpenDialog(new JPanel());	// 열기용
		
		// 파일 선택창에서 '선택한 파일 정보' 가져오기
		if(result == JFileChooser.APPROVE_OPTION){	// 열기버튼 또는 저장버튼을 클릭하면...
			inFile = fileChooser.getSelectedFile();
			
		}
		
		
		DatagramSocket socket = new DatagramSocket();
//		File file = new File("D:/D_Other/테스트.png");
//		
//		if(!file.exists()){
//			System.out.println("파일이 존재하지 않습니다");
//			return;
//		}
		
		InetAddress address = InetAddress.getByName("127.0.0.1");
		
		
	
		bis = new BufferedInputStream(
				new FileInputStream(inFile));
	
		
		byte[] data = new byte[1024];
		int len = 0;
		
		while((len = bis.read(data)) > 0){
			outPacket = new DatagramPacket(data, len, address, 8888);
			socket.send(outPacket);
		}
		
		System.out.println("파일전송 끝...");
		
	}

}













