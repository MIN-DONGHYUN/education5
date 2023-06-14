package com.jpa.app.service;

import java.util.List;
import com.jpa.app.domain.Board;

public interface InterBoardService {

	public void insertBoard(Board entity) throws Exception;
	public void updateBoard(Board entity) throws Exception;
	public void deleteBoard(long num) throws Exception;
	
	public List<Board> listBoard(String searchType, String searchWord) throws Exception;
	public Board viewBoard(long num) throws Exception;
	
	public void updateReadCount(long num) throws Exception;
}
