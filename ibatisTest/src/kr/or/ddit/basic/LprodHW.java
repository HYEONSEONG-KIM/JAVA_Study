package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.util.BuildedSqlMapClient;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


/*
 * 	LPROD테이블에 새로운 데이터를 추가하는 프로그래을 작성
 * 	
 * 	lprod_gu 와 lprod_nm은 직접 입력받아서 처리
 * 	lprod_id는 현재의 lprod_id 값들 중에서 제일 큰 값보다 1크게
 * 
 * 	입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리
 * 
 */

public class LprodHW {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	/*	
		
		Charset charSet = Charset.forName("UTF-8");
		Resources.setCharset(charSet);*/
		
		
		try {
			/*Reader r = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(r);
			
			r.close();*/
			SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
			List<LprodVO> lprod = smc.queryForList("lprod.getAllLprod"); 
			
			
			System.out.println("lprod_gu입력");
			String lprodGu;
			while(true){
				boolean flag = false;
				System.out.print(">> ");
				lprodGu = sc.next();
				
				for(int i = 0; i < lprod.size(); i++){
					if(lprod.get(i).getLprod_gu().equals(lprodGu)){
						System.out.println("입력하신 코드는 이미 존재합니다. 다시 입력하여 주세요");
						break;
					}else if(!lprod.get(i).getLprod_gu().equals(lprodGu) && i == lprod.size() -1){
						flag = true;
					}
				}
				
				if(flag){
					break;
				}
			}
			
			System.out.print("lprod_nm 입력>> ");
			String lprodNm = sc.next();
			
			int lprodId = 0;
			
			for(int i = 0 ; i < lprod.size();i++){
				if(lprodId < lprod.get(i).getLprod_id()){
					lprodId = lprod.get(i).getLprod_id();
				}
			}
			
			lprodId += 1;
			
			LprodVO lprodVo = new LprodVO();
			lprodVo.setLprod_gu(lprodGu);
			lprodVo.setLprod_nm(lprodNm);
			lprodVo.setLprod_id(lprodId);
			
			Object obj = smc.insert("lprod.insertLprod", lprodVo);
			if(obj == null){
				System.out.println("insert 작업 성공");
			}else{
				System.out.println("insert 작업 실패");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
