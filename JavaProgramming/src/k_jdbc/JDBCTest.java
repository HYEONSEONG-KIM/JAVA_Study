package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {
		
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		String sql = "SELECT * FROM CART WHERE CART_MEMBER = 'a001'";
		List<Object> param = new ArrayList<>();
//		param.add("a001");
//		List<Map<String, Object>> list = new ArrayList<>();
//		list = jdbc.selectOne(sql, param);
		Map<String, Object> row = jdbc.selectOne(sql);
		
		for(String Key : row.keySet()){
			System.out.print(Key + " : " + row.get(Key) + "\t");
		}System.out.println();
		
		sql = "DELETE FROM DEPART WHERE DEP_CODE = '123'";
//		param.add("123");
//		param.add("123");
		
		int result = jdbc.update(sql);
		System.out.println(result);
		
		/*for(int i = 0; i < list.size(); i++){
			Map<String, Object> map = list.get(i);
			for(String key : map.keySet()){
				System.out.print(map.get(key) + "\t");
			}
			System.out.println();
		}*/
		
		/*sql = "SELECT MEM_ID, MEM_NAME FROM MEMBER";
		list = jdbc.selectList(sql);
		for(int i = 0; i < list.size(); i++){
			Map<String, Object> map = list.get(i);
			for(String key : map.keySet()){
				System.out.print(map.get(key) + "\t");
			}
			System.out.println();
		}*/
		
		
	}

}
