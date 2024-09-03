package com.benq.spring.board.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.benq.spring.board.domain.BoardVO;

public interface BoardStore {

    int insertBoard(SqlSession session, BoardVO board);

    BoardVO selectOneByNo(SqlSession session, Integer boardNo);

    List<BoardVO> selectBoardList(SqlSession session, int currentPage);

    int getTotalCount(SqlSession session);

    int getTotalCount(SqlSession session, Map<String, String> searchMap);

    int deleteBoard(SqlSession session, Integer boardNo);

    int updateBoard(SqlSession session, BoardVO board);

    List<BoardVO> selectSearchList(SqlSession session, Map<String, String> searchMap, int currentPage, int recordCountPerPage);
}
