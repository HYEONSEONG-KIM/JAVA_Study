package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {

	Scanner sc = new Scanner(System.in);
	Map<Integer, Room> hotel = new HashMap<>();	
	int input;
	
	public static void main(String[] args) {
		
		Hotel hotel = new Hotel();
		hotel.start();
		
	}

	private void start() {
		
		setRood();
		
		System.out.println("*********************************************");
		System.out.println("호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************\n\n\n");
		
		while(true){
			selectMenu();
		}
		
	}

	private void selectMenu() {
		
		
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습까?");
		System.out.println("1.체크인     2.체크아웃     3.객실상태     4.업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>>");
		input = Integer.parseInt(sc.nextLine());
		
		switch(input){
		
		case 1 : checkIn();
				break;
		case 2 : checkOut();
				break;
		case 3 : roomState();
				break;
		case 4 : System.exit(0);
		
		}
	}

	private void roomState() {
		
		Set<Integer> set = hotel.keySet();
		
		List<Integer> keyList = new ArrayList<>(set);
		Collections.sort(keyList);
		
		System.out.println("=======================현재 객실 상태=======================");
		System.out.printf("%s\t|%s\t|%s\t", "방 번호", "방 종류", "투숙객 이름");
		System.out.println();
		System.out.println("----------------------------------------------");
		for(int key : keyList){
			int num = hotel.get(key).getRoomNum();
			String room = hotel.get(key).getRoomName();
			String person = hotel.get(key).getPersonName();
			
			if(person == null){
				person = "-";
			}
			
			System.out.printf("%d\t|" , num);
			System.out.printf("%s\t|" , room);
			System.out.printf("%s" , person);
			System.out.println();
		}
		System.out.println("========================================================\n");
	}

	private void checkOut() {
		
		boolean flag = false;
		
		System.out.println("체크아웃 할 객실 번호를 입려하세요");
		System.out.print("방번호 입력>>");
		input = Integer.parseInt(sc.nextLine());
	
		Set<Integer> set = hotel.keySet();
		
		for(int roomNum : set){
			if(roomNum == input){
				flag = true;
			}
		}
		
		
		if(!flag){
			System.out.println(input + "호 객실은 존재하지 않습니다\n");
			return;
		}
		
		if(hotel.get(input).getPersonName() == null){
			System.out.println(input + "호 객실에는 체크인 한 사람이 없습니다\n");
			return;
		}
		
		String person = hotel.get(input).getPersonName();
		hotel.get(input).setPersonName(null);
		System.out.println(input + "호 객실의 " +person + "님 체크아웃을 완료하였습니다\n");
	
	}

	private void checkIn() {
		
		boolean flag = false;
		
		System.out.println("----------------------------------------------");
		System.out.println("체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println("*201~209 : 싱글룸");
		System.out.println("*301~309 : 더블룸");
		System.out.println("*401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("객실 번호 입력>>");
		input = Integer.parseInt(sc.nextLine());
		System.out.println();
		
		Set<Integer> set = hotel.keySet();
		
		for(int roomNum : set){
			if(roomNum == input){
				flag = true;
			}
		}
		
		if(!flag){
			System.out.println(input + "호 객실은 존재하지 않습니다\n");
			return;
		}
		
		if(hotel.get(input).getPersonName() != null){
			System.out.println(input + "호 객실은 이미 예약 되었습니다\n");
			return;
		}
		
		System.out.print("누구를 체크인 하시겠습니까>>");
		String name = sc.nextLine();
		
		hotel.get(input).setPersonName(name);
		System.out.println("체크인이 완료되었습니다\n");
		
	}

	private void setRood() {
		
		for(int i = 201 ; i <= 209; i++){
			hotel.put(i, new Room(i, "싱글룸"));
		}
		
		for(int i = 301 ; i <= 309; i++){
			hotel.put(i, new Room(i, "더블룸"));
		}
		
		for(int i = 401 ; i <= 409; i++){
			hotel.put(i, new Room(i, "스위트룸"));
		}
	}

}


class Room {
	
	private int roomNum;
	private String roomName;
	private String personName;
	
	public Room(int roomNum, String roomName) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
	}

	public int getRoomNum() {
		return roomNum;
	}

	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", roomName=" + roomName
				+ ", personName=" + personName + "]";
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	
	
}