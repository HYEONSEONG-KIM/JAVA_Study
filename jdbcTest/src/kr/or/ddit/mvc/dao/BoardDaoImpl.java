package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.mvc.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardDaoImpl implements IBoardDao{

	private static BoardDaoImpl board;
	
	private BoardDaoImpl(){}
	
	public static BoardDaoImpl getInstance(){
		if(board == null){
			board = new BoardDaoImpl();
		}
		return board;
	}
	
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "insert into jdbc_board values(board_seq.nextVal, ?,?,sysdate,0,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, boardVo.getBoard_title());
			ps.setString(2, boardVo.getBoard_writer());
			ps.setString(3, boardVo.getBoard_content());
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> boardList = null;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "SELECT * FROM JDBC_BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			boardList = new ArrayList<>();
			
			while(rs.next()){
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("BOARD_NO"));
				boardVo.setBoard_title(rs.getString("BOARD_TITLE"));
				boardVo.setBoard_writer(rs.getString("BOARD_WRITER"));
				boardVo.setBoard_date(rs.getString("BOARD_DATE"));
				boardVo.setBoard_cnt(rs.getInt("BOARD_CNT"));
				boardVo.setBoard_content(rs.getString("BOARD_CONTENT"));
				
				boardList.add(boardVo);
			}
			
			
			
		} catch (SQLException e) {
		}finally{
			if(rs != null) try{ rs.close(); }catch(SQLException e){}
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		
		return boardList;
	}

	@Override
	public BoardVO showBoard(int boardNum) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO boardVo = null;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "SELECT * FROM JDBC_BOARD WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			String no = Integer.toString(boardNum);
			
			ps.setString(1, no);
			rs = ps.executeQuery();
			
			while(rs.next()){
			boardVo = new BoardVO();
			boardVo.setBoard_no(rs.getInt("BOARD_NO"));
			boardVo.setBoard_title(rs.getString("BOARD_TITLE"));
			boardVo.setBoard_writer(rs.getString("BOARD_WRITER"));
			boardVo.setBoard_date(rs.getString("BOARD_DATE"));
			boardVo.setBoard_cnt(rs.getInt("BOARD_CNT"));
			boardVo.setBoard_content(rs.getString("BOARD_CONTENT"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs != null) try{ rs.close(); }catch(SQLException e){}
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		
		
		return boardVo;
	}

	@Override
	public List<BoardVO> titleSearch(String title) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> boardList = null;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where BOARD_TITLE like '%" + title + "%'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			boardList = new ArrayList<>();
			
			while(rs.next()){
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("BOARD_NO"));
				boardVo.setBoard_title(rs.getString("BOARD_TITLE"));
				boardVo.setBoard_writer(rs.getString("BOARD_WRITER"));
				boardVo.setBoard_date(rs.getString("BOARD_DATE"));
				boardVo.setBoard_cnt(rs.getInt("BOARD_CNT"));
				boardVo.setBoard_content(rs.getString("BOARD_CONTENT"));
				
				boardList.add(boardVo);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			if(rs != null) try{ rs.close(); }catch(SQLException e){}
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		
		return boardList;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_title = ?, board_content = ? where board_no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, boardVo.getBoard_title());
			ps.setString(2, boardVo.getBoard_content());
			ps.setInt(3, boardVo.getBoard_no());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNum) {
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "delete from jdbc_board where board_no = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNum);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		return cnt;
	}

	@Override
	public int cntCreate(int boardNum) {
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_cnt = "
					+ "(select board_cnt+1 from jdbc_board where board_no = ?) where board_no = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNum);
			ps.setInt(2, boardNum);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("증가실패...");
			e.printStackTrace();
		}finally{
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		return cnt;
	}

}









