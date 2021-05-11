package kr.or.ddit.mvc.dao;

import java.util.List;

import kr.or.ddit.mvc.vo.BoardVO;

public interface IBoardDao {

	/**
	 * 게시물 작성을 위한 메서드
	 * @param boardVo
	 * @return
	 */
	public int insertBoard(BoardVO boardVo);
	
	/**
	 * 게시물 조회를 위한 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 게시글 보기를 위한 메서드
	 * @param boardNum
	 * @return
	 */
	public BoardVO showBoard(int boardNum);
	
	/**
	 * 제목 일부를 입력하여 게시물 검색
	 * @param title
	 * @return
	 */
	public List<BoardVO> titleSearch(String title);
	
	/**
	 * 게시물 수정을 위한 메서드
	 * @param boardVo
	 * @return
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * 게시물 삭제를 위한 메서드
	 * @param boardNum
	 * @return
	 */
	public int deleteBoard(int boardNum);
	
	/**
	 * 게시물 조회수 증가를 위한 메서드
	 * @return
	 */
	public int cntCreate(int boardNum);
	
	
}
