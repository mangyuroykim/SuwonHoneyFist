package com.benq.spring.board.service;

import java.util.List;
import java.util.Map;
import com.benq.spring.board.domain.BoardVO;

public interface BoardService {

    int insertBoard(BoardVO board);

    List<BoardVO> selectBoardList(int currentPage);

    /**
     * 검색한 게시글 전체 갯수 Service
     * @param searchMap 검색 조건
     * @return int
     */
    int getTotalCount(Map<String, String> searchMap);

    /**
     * 게시글 상세 조회 Service
     * @param boardNo
     * @return BoardVO
     */
    BoardVO selectOneByNo(Integer boardNo);

    /**
     * 게시글 삭제 Service
     * @param boardNo
     * @return int
     */
    int deleteBoard(Integer boardNo);

    /**
     * 게시글 수정 Service
     * @param board
     * @return int
     */
    int updateBoard(BoardVO board);

    /**
     * 게시글 검색 조회 Service
     * @param searchMap 검색 조건
     * @param currentPage 현재 페이지 번호
     * @param recordCountPerPage 페이지당 레코드 수
     * @return List<BoardVO>
     */
    List<BoardVO> selectSearchList(Map<String, String> searchMap, int currentPage, int recordCountPerPage);

    /**
     * 게시글 전체 갯수 Service
     * @return int
     */
    int getTotalCount();
}
