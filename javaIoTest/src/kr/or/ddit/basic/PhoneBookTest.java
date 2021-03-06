package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Q. 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
 *	Map을 이용하여 '전화번호 정보'를 관리하는 프로그램을 작성 
 *	(Map의 구조는 Key값으로 '이름'데이터를 사용, value 값으로는 Phone클래스의 인스턴스)
 *
 *	-- 추가 조건
 *	1) '6. 전화번호 저장' 메뉴를 추가
 *		(저장 파일명 : 'phoneData.dat')
 *	2) 프로그램이 시작될 때 저장파일명이 있으면 그 데이터를 읽어와 Map에 셋팅
 *
 *	3) 프로그램이 종료될 때 Map의 데이터가 변경되거나, 추가 또는 삭제된 자료가 있으면 
 *		저장 후 종료되도록 함
 *
 *	아래의 메뉴를 처리하는 프로그램 완성
 *	실행예시)
 *		메 뉴
 *  1. 전화번호 등록
 *  2. 전화번호 수정
 *  3. 전화번호 삭제
 *  4. 전화번호 검색
 *  0. 프로그램 종료
 *  ----------------------
 *  번호 입력 >>1
 *  
 *  새롬게 등록할 전화번호 정보를 입력
 *  이름>> 홍길동
 *  전화번호>> 010-1111-1111
 *  주소>> 대전시 중구 대흥동
 *  
 *  '홍길동' 전화번호 등록 완료!!
 *  
 *  
 *      메 뉴
 *  1. 전화번호 등록
 *  2. 전화번호 수정
 *  3. 전화번호 삭제
 *  4. 전화번호 검색
 *  0. 프로그램 종료
 *  ----------------------
 *  번호 입력 >> 1
 *  
 *  새롭게 등록할 전화번호 정보를 입력하세요.
 *  이름>> 홍길동
 *  '홍길동'은 이미 등록된 사람입니다
 */





public class PhoneBookTest {

	public static boolean savsState;
	Scanner sc = new Scanner(System.in);
	int input;
	Map<String, Phone> phList = new HashMap<>();
	
	public static void main(String[] args) {
		
		PhoneBookTest pb = new PhoneBookTest();
		pb.start();
		
		
	}

	private void start() {
		try{
			FileInputStream fis = new FileInputStream("D:/D_Other/연습용/phoneData.dat");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			try {
				
				Object obj;
				
				while((obj = ois.readObject()) != null){
					Phone ph = (Phone)obj;
					phList.put(ph.getName(), ph);
				}
				
			}catch (EOFException e) {
				System.out.println("객체 읽기 작업 완료...");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			 ois.close();
			}
		}catch(Exception e){
			
		}
		
		
		
		while(true){
			selectMenu();
		}
	}

	private void selectMenu() {
		
		System.out.println();
		System.out.println("   메  뉴           ");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 저장");
		System.out.println("0. 프로그램 종료");
		System.out.println("----------------------");
		System.out.print("번호 입력>>");
		input = sc.nextInt();
		
		switch(input){
		case 1 : phInsert();
				break;
				
		case 2 : phUpdate();
				break;
				
		case 3 : phDelete();
				break;
		
		case 4 : phRead();
				break;
		
		case 5 : phSave();
				break;
				
		case 0 : programExit();
		}
		
	}

	private void programExit() {
		sc.nextLine();
		if(savsState){
			System.out.println("변경사항이 있습니다 저장 하시겠습니까??");
			System.out.print("1.예\t2.아니오 >>");
			int input = Integer.parseInt(sc.nextLine());
			
			switch (input) {
			case 1 : phSave();
					System.exit(0);
			case 2 : System.exit(0);
			}
		}
		else{
			System.exit(0);
		}
	}

	private void phSave() {
		
		if(savsState){
			try {
				FileOutputStream fos = new FileOutputStream("D:/D_Other/연습용/phoneData.dat");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				
				for(String key : phList.keySet()){
					oos.writeObject(phList.get(key));
				}
				oos.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				savsState = false;
			}
			System.out.println("전화번호 저장이 완료되었습니다");
		}else{
			System.out.println("변경사항이 없습니다");
		}
	}

	private void phRead() {
		sc.nextLine();
		if(phList ==null){
			System.out.println("전화번호부가 비어있습니다");
			return;
		}
		Set<String> set = phList.keySet();
		
		int squence = 1;
		
		System.out.println("=================================================");
		System.out.printf("%s\t|%s\t|%-15s\t|%s", "번호" , "이름", "전화번호", "주소");
		System.out.println();
		System.out.println("-------------------------------------------------");
		for(String key : set){
			String name = phList.get(key).getName();
			String tel = phList.get(key).getTel();
			String addr = phList.get(key).getAddr();
			
			System.out.printf("%d\t|", squence);
			System.out.printf("%s\t|", name);
			System.out.printf("%s\t|", tel);
			System.out.printf("%s\t", addr);
			System.out.println();
			
			squence++;
		}
		System.out.println("=================================================");
		
	}

	private void phDelete() {
		boolean flag = false;
		sc.nextLine();
		System.out.print("삭제하고자 하는 전화번호 주인의 이름을 입력하세요>>");
		String name = sc.nextLine();
		
		Set<String> set = phList.keySet();
		
		for(String key : set){
			if(key.equals(name)){
				flag = true;
				break;
			}
		}
		
		if(!flag){
			System.out.println("입력하신 이름의 정보는 없습니다");
			return;
		}
		
		phList.remove(name);
		savsState = true;
		System.out.println("삭제가 완료되었습니다");

	}

	private void phUpdate() {
		
		boolean flag = false;
		sc.nextLine();
		System.out.print("수정하고자 하는 전화번호 주인의 이름을 입력하세요>>");
		String name = sc.nextLine();
		
		
		/*if(!phList.containsKey(name)){
			System.out.println("입력하신 이름의 정보는 없습니다");
			return;
		}*/
		
		
		Set<String> set = phList.keySet();
		for(String key : set){
			if(key.equals(name)){
				flag = true;
				break;
			}
		}
		
		if(!flag){
			System.out.println("입력하신 이름의 정보는 없습니다");
			return;
		}
		
		System.out.print("변경할 번호 입력>>");
		String tel = sc.nextLine();
		System.out.print("변경할 주소 입력>>");
		String addr = sc.nextLine();
		
		phList.put(name, new Phone(name, addr, tel));
		savsState = true;
		System.out.println("수정이 완료 되었습니다");
		
		
	}

	private void phInsert() {
		sc.nextLine();
		Set<String> set = phList.keySet();
		
		System.out.println("새롭게 등록할 전화번호 정보를 입력");
		
		System.out.print("이름>>");
		
		String name = sc.nextLine();
		
	
		
		for(String key : set){
			if(key.equals(name)){
				System.out.println("'" + name + "' 은 이미 등록된 사람입니다");
				return;
			}
		}
		
		
		System.out.print("전화번호>>");
		String tel = sc.nextLine();
		System.out.print("주소>>");
		String addr = sc.nextLine();
		
		phList.put(name, new Phone(name, addr, tel));
		savsState = true;
		System.out.println("'" + name + "' 전화번호 등록 완료");
	}

}

class Phone implements Serializable{
	private String name;
	private String addr;
	private String tel;
	
	
	public Phone(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
}