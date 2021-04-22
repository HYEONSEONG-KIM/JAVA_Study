package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		
		// InetAddress클래스 => IP주소를 다루기 위한 클래스
		
		// www.naver.com의 IP 정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		
		System.out.println("Host Name : " + naverIp.getHostName());
		System.out.println("Host Address : " + naverIp.getHostAddress());
		System.out.println("toString : " + naverIp.toString());	// 이름과 주소 동시에 반환
		System.out.println("---------------------------------------------------------");
		System.out.println();
		
		// 자신의 컴퓨터 IP 정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 com의 Host Name : " + localIp.getHostName());
		System.out.println("내 com의 Host Adress : " + localIp.getHostAddress());
		System.out.println("toString : " + localIp.toString());
		System.out.println("---------------------------------------------------------");
		System.out.println();
		
		// IP주소가 여러개인 호스트의 IP정보 가져오기
		InetAddress[] ipArrs = InetAddress.getAllByName("www.ddit.or.kr");
		
		for(InetAddress ip : ipArrs){
			System.out.println(ip.toString());
		}
		System.out.println("---------------------------------------------------------");
		System.out.println();
		
		
		
	}

}












