package kr.or.ddit.basic;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

/*
 * 	회원 관리하는 프로그램을 작성
 * 	(MYMEMBER테이블 이용)
 * 
 * 	아래 메뉴의 기능을 모두 구현(CRUD구현)
 * 	-- 작업 선택 --
 * 	1. 자료 추가
 * 	2. 자료 삭제
 * 	3. 자료 수정
 * 	4. 전체 자료 수정
 * 	5. 자료 수정2
 * 	0. 작업 끝
 * 	-------------------
 * 	작업선택 >>
 * 
 * 	// 처리 조건
 * 	1) 자료 추가에서 회원 ID는 중복되지 않도록 처리
 * 	2) 자료 수정에서 '회원ID'는 변경 금지
 * 	3) 자료 삭제는 '회원ID'를 입력 받아서 처리
 * 	4) 자료 수정2에서는 변경할 컬럼을 선택해서 수정할 수 있도록 함
 * 		(변경할 컬럼은 1개만 선택할 수 있음)
 */

public class JdbcTest06 {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "PC21";
	String password = "java";
	
	ArrayList<String> memIdList;
	int input;
	String sql;
	

	public static void main(String[] args) {
		
		new JdbcTest06().start();
		
	}

	// 프로그램 시작
	private void start() {
		
		//con = DBUtil.getConnection();
		//con = DBUtil2.getConnection();
		con = DBUtil3.getConnection();
		
		
		selectMenu();
		
	}
	
	// 메뉴 선택
	private void selectMenu() {
		
		while(true){
			
			System.out.println();
			System.out.println("---작업 선택---");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("5. 자료 수정2");
			System.out.println("6. 엑셀 저장");
			System.out.println("0. 작업 끝");
			System.out.print("작업 선택 >>");
			
			input = Integer.parseInt(sc.nextLine());
			
			switch(input){
				case 1 : dataInsert();
					break;
				case 2 : dataDelete();
					break;
				case 3 : dataUpdate();
					break;
				case 4 : dataSelect();
					break;
				case 5 : dataUdate2();
					break;
				case 6 : saveXls();
					break;
				case 0 : System.exit(0);
					break;
			
			}
		}
	}
	
	private void saveXls() {
		List<Map<String,String>> allMember = new ArrayList<>();
		
		sql = "SELECT * FROM MYMEMBER";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();
			int col = meta.getColumnCount();
			Map<String,String> mem;
			
			while(rs.next()){
				mem = new HashMap<>();
				for(int i = 1; i <= col; i++){
					mem.put(meta.getColumnName(i), rs.getString(i));
				}
					allMember.add(mem);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		excel(allMember);
		
		
		
	}

	private void excel(List<Map<String, String>> allMember) {
		
		XSSFWorkbook xssfwb = null;
		XSSFSheet xssfsheet = null;
		XSSFRow xssfRow = null;
		XSSFCell xssfCell = null;
		
		try {
			int rowNo = 0;
			xssfwb = new XSSFWorkbook();
			xssfsheet = xssfwb.createSheet("MyMember");
			
			XSSFFont font = xssfwb.createFont();
			font.setFontHeightInPoints((short)20);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setBold(true);
			font.setColor(new XSSFColor(Color.decode("#457ba2")));
					
			CellStyle cellstyle = xssfwb.createCellStyle();
			xssfsheet.setColumnWidth(0,(xssfsheet.getColumnWidth(0))+(short)2048);
			
			cellstyle.setFont(font);
			cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			
			xssfRow = xssfsheet.createRow(rowNo++);
			xssfCell = xssfRow.createCell((short)0);
			
			CellStyle tableCellStyle = xssfwb.createCellStyle();
			tableCellStyle.setBorderTop((short)3);
			tableCellStyle.setBorderBottom((short)5);
			tableCellStyle.setBorderLeft((short)3);
			tableCellStyle.setBorderRight((short)3);
		
			
			
			
			
			Set<String> key = allMember.get(0).keySet();
			List<String> keyList = new ArrayList<>();
			keyList.add("MEM_ID");
			keyList.add("MEM_NAME");
			keyList.add("MEM_PASS");
			keyList.add("MEM_TEL");
			keyList.add("MEM_ADDR");
			
			
			int cell_key = 0;
			for(String key_s : keyList){
				xssfCell = xssfRow.createCell((short)cell_key);
				xssfCell.setCellValue(key_s);
				xssfCell.setCellStyle(tableCellStyle);
				cell_key++;
			}
			
			tableCellStyle.setBorderTop((short)5);
			tableCellStyle.setBorderBottom((short)5);
			tableCellStyle.setBorderLeft((short)5);
			tableCellStyle.setBorderRight((short)5);
			
			
			for(int i = 0; i < allMember.size(); i++){
				cell_key = 0;
				xssfRow = xssfsheet.createRow(rowNo++);
				
				for(String key_s : keyList){
					xssfCell = xssfRow.createCell((short)cell_key);
					xssfCell.setCellValue(allMember.get(i).get(key_s));
					xssfCell.setCellStyle(tableCellStyle);
					cell_key++;
				}
				
			}
			
			
			
			
			File file = new File("D:/D_Other/test.xlsx");
			FileOutputStream fos = null;
			fos = new FileOutputStream(file);
			xssfwb.write(fos);
			
			System.out.println("엑셀파일 저장 성공!!");
			if(fos != null) fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void dataUdate2() {
		idList();
		
		System.out.println("");
		System.out.println("변경할 ID를 입력하세요 >>");
		String id;
		
		// id존재여부
		while(true){
			
			boolean flag = false;
			id = sc.nextLine();
			for(int i = 0; i < memIdList.size(); i++){
				if(memIdList.get(i).equals(id)){
					flag = true;
					break;
				}
			}
			
			if(flag){
				break;
			}else{
				System.out.println("입력하신" + id + "는 존재하지 않습니다");
				return;
			}
		}
		
		System.out.println("변경할 정보를 선택하세요");
		System.out.println("1.패스워드");
		System.out.println("2.이름");
		System.out.println("3.전화번호");
		System.out.println("4.주소");
		System.out.print(">> ");
		input = Integer.parseInt(sc.nextLine());
		
		String sqlStr = "";
		String inputStr = "";
		switch(input){
			case 1 : 
				System.out.print("새 패스워드 입력>>");
				inputStr = sc.nextLine();
				sqlStr = "MEM_PASS = '" + inputStr +"'";
				break;
			case 2 : 
				System.out.print("새 이름 입력>>");
				inputStr = sc.nextLine();
				sqlStr = "MEM_NAME = '" + inputStr +"'";
				break;
			case 3 : 
				System.out.print("새 전화번호 입력>>");
				inputStr = sc.nextLine();
				sqlStr = "MEM_TEL = '" + inputStr +"'";
				break;
			case 4 : 
				System.out.print("새 주소 입력>>");
				inputStr = sc.nextLine();
				sqlStr = "MEM_ADDR =  '" + inputStr +"'";
				break;
		}
		
		sql = "UPDATE MYMEMBER SET " + sqlStr + " WHERE MEM_ID = '" + id +"'";
		System.out.println(sql);
		
		try {
			ps = con.prepareStatement(sql);
			int result = ps.executeUpdate();
			
			if(result > 0){
				System.out.println("수정이 완료되었습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 데이터 조회
	private void dataSelect() {
		sql = "SELECT * FROM MYMEMBER";
		List<Map<String, String>> memInfo = new ArrayList<>();
		Map<String, String> map;
				
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData meta = rs.getMetaData();
			int col = meta.getColumnCount();
		
			while(rs.next()){
				map = new HashMap<>();
				for(int i = 1; i <= col; i++){
					map.put(meta.getColumnName(i),rs.getString(i));
				
				}
				memInfo.add(map);
			}
			
			System.out.println();
			System.out.printf("%-10s\t%-10s\t%s\t%-10s\t%s", "회원ID", "패스워드", "이름", "전화번호", "주소");
			System.out.println();
			System.out.println("=======================================================================");
			for(int i = 0; i < memInfo.size(); i++){
				
				System.out.printf("%-10s\t", memInfo.get(i).get("MEM_ID"));
				System.out.printf("%-10s\t", memInfo.get(i).get("MEM_PASS"));
				System.out.printf("%s\t", memInfo.get(i).get("MEM_NAME"));
				System.out.printf("%-10s\t", memInfo.get(i).get("MEM_TEL"));
				System.out.printf("%s\t", memInfo.get(i).get("MEM_ADDR"));
				System.out.println();
				if(i != memInfo.size() - 1)
				System.out.println("----------------------------------------------------------------------");
				
			}
			System.out.println("=======================================================================");

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	// 데이터 수정
	private void dataUpdate() {
		
		idList();
		
		System.out.println("");
		System.out.println("변경할 ID를 입력하세요 >>");
		String id;
		
		// id존재여부
		while(true){
			
			boolean flag = false;
			id = sc.nextLine();
			for(int i = 0; i < memIdList.size(); i++){
				if(memIdList.get(i).equals(id)){
					flag = true;
					break;
				}
			}
			
			if(flag){
				break;
			}else{
				System.out.println("입력하신" + id + "는 존재하지 않습니다");
				return;
			}
		}
		
		
		
		System.out.print("비밀번호를 입력하세요 >>");
		String pass = sc.nextLine();
		
		System.out.print("변경할 이름을 입력하세요>>");
		String name = sc.nextLine();
		
		System.out.print("변경할 전화번호를 입력하세요>>");
		String ph = sc.nextLine();
		
		System.out.print("변경할 주소를 입력하세요>>");
		String addr = sc.nextLine();
		
		sql = "UPDATE MYMEMBER SET MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ?"
				+ " WHERE MEM_ID = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, name);
			ps.setString(3, ph);
			ps.setString(4, addr);
			ps.setString(5, id);
			
			int result = ps.executeUpdate();
			
			if(result > 0){
				System.out.println("수정되었습니다");
			}else{
				System.out.println("수정에 실패하였습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// 데이터 삭제
	private void dataDelete() {
		
		System.out.println();
		System.out.print("삭제할 ID를 입력하세요 >>");
		String id = sc.nextLine();
		
		sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			int result = ps.executeUpdate();
			
			if(result > 0){
				System.out.println("입력하신 " + id + "가(이) 삭제 되었습니다");
			}else{
				System.out.println("입력하신 " + id + "는(은) 존재하지 않거나 올바르지 않습니다");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 데이터 추가
	private void dataInsert() {
		
		idList();
		System.out.println();
		
		try {
			
			System.out.print("ID를 입력하세요 >>");
			String id; 
			
			// 입력한 id가 중복되는지 체크
			while(true){
				boolean flag = false;
				id = sc.nextLine();
				for(int i = 0; i < memIdList.size(); i++){
					if(memIdList.get(i).equals(id)){
						System.out.println("입력하신 ID는 이미 존재합니다");
						System.out.print("다시 ID를 입력하세요 >>");
						flag = true;
						break;
					}
				}
				if(!flag){
					break;
				}
			}
			
			System.out.print("비밀번호를 입력하세요 >>");
			String pass = sc.nextLine();
			
			System.out.print("이름을 입력하세요>>");
			String name = sc.nextLine();
			
			System.out.print("전화번호를 입력하세요>>");
			String ph = sc.nextLine();
			
			System.out.print("주소를 입력하세요>>");
			String addr = sc.nextLine();
			
			sql = "INSERT INTO MYMEMBER VALUES(?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, ph);
			ps.setString(5, addr);
			
			int result = ps.executeUpdate();
			
			if(result > 0){
				System.out.println("회원정보가 추가 되었습니다");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void idList(){
		memIdList = new ArrayList<>();
		try {
			sql = "SELECT MEM_ID FROM MYMEMBER";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 현재 테이블의 회원ID 리스트에 담기
			while(rs.next()){
				memIdList.add(rs.getString("MEM_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}


















