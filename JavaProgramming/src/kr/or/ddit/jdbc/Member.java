package kr.or.ddit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import e_oop.ScanUtill;

public class Member {
	
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DBConnection db = new DBConnection();
	public Member(){
		con = db.getCont();
	}
	
	public static void main(String[] args) {
	
		Member member = new Member();
		
		
		
		
		while(true){
			
			System.out.print("1.입력\t2.리스트\t3.수정\t4.삭제\t5.종료 =>");
			int input = ScanUtill.nextInt();

			if(input == 1){
				member.inputMember();
			}else if(input == 2){
				member.listMember();
			}else if(input == 3){
				member.update();
			}else if(input == 4){
				member.delete();
			}else if(input == 5){
				break;
			}
		}
		System.out.println("종료되었습니다");
		System.exit(0);
		
	}

	public void inputMember() {
	
		try {
			String sql = "INSERT INTO MEMBER(MEM_ID,MEM_PASS,MEM_NAME,MEM_HP,MEM_MAIL)"
					+ " VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			System.out.print("ID>");
			String id = ScanUtill.nextLine();
			System.out.print("pass>");
			String pass = ScanUtill.nextLine();
			System.out.print("name>");
			String name = ScanUtill.nextLine();
			System.out.print("hp>");
			String hp = ScanUtill.nextLine();
			System.out.print("mail>");
			String mail = ScanUtill.nextLine();
			
			ps.setObject(1, id);
			ps.setObject(2, pass);
			ps.setObject(3, name);
			ps.setObject(4, hp);
			ps.setObject(5, mail);
			
			int result = ps.executeUpdate();
			if(result != 0){
				System.out.println("삽입되었습니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listMember(){
		
		try {
			String sql = "SELECT MEM_ID ID,MEM_NAME 이름,MEM_HP 전화번호 FROM MEMBER";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData meta= rs.getMetaData();
			int cnt = meta.getColumnCount();
			
			for(int i = 1; i <= cnt; i++){
				System.out.print(meta.getColumnName(i) + "\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i = 1; i <= cnt; i++){
				System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(){
		try {
			String sql = "DELETE FROM MEMBER WHERE MEM_ID = ?";
			ps = con.prepareStatement(sql);
			System.out.print("삭제하려는 ID>");
			String id = ScanUtill.nextLine();
			ps.setObject(1, id);
			
			int result = ps.executeUpdate();
			if(result != 0){
				System.out.println("삭제되었습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(){
		
		try {
			String sql = "UPDATE MEMBER SET MEM_ID = ?,"
					+ "MEM_NAME = ?,"
					+ "MEM_HP = ?"
					+ " WHERE MEM_ID = ?";
			ps = con.prepareStatement(sql);
			
			System.out.print("수정할 ID>");
			String updateID = ScanUtill.nextLine();
			
			System.out.print("ID>");
			String id = ScanUtill.nextLine();
			
			System.out.print("NAME>");
			String name = ScanUtill.nextLine();
			
			System.out.print("HP>");
			String hp = ScanUtill.nextLine();
			
			ps.setObject(1, id);
			ps.setObject(2, name);
			ps.setObject(3, hp);
			ps.setObject(4, updateID);
			
			int result = ps.executeUpdate();
			
			if(result != 0){
				System.out.println("수정되었습니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}










