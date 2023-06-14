package com.jpa.app.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.app.domain.Board;
import com.jpa.app.model.InterBoardRepository;

@Service
public class BoardService implements InterBoardService {

	@Autowired
	private InterBoardRepository boardRepository;

	@Override
	public List<Board> listBoard(String searchType, String searchWord) throws Exception {
		
		List<Board> board_List = null;
		
		if( (!"subject".equals(searchType) && 
			 !"content".equals(searchType) &&
			 !"all".equals(searchType) &&
			 !"userName".equals(searchType)) ||
			searchWord.trim().length() == 0	) {
			board_List = boardRepository.findAll();
		}
		
		else {
			if("all".equals(searchType)) {
				board_List = boardRepository.findBySubjectContainingOrContentContaining(searchWord, searchWord);	
			}
			else if("subject".equals(searchType)) {
				board_List = boardRepository.findBySubjectContaining(searchWord);
			}
			else if("content".equals(searchType)) {
				board_List = boardRepository.findByContentContaining(searchWord);
			}
			else if("userName".equals(searchType)) {
				board_List = boardRepository.findByMember_UserNameContaining(searchWord);
			}
		}
		
		return board_List;
	}

	@Override
	public void insertBoard(Board dto) throws Exception {
		boardRepository.save(dto);
	}

	@Override
	public Board viewBoard(long num) throws Exception {

		Board dto = null;
		
		try {
			Optional<Board> board = boardRepository.findById(num);
			dto = board.get();
			dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
		} catch (NoSuchElementException e) {
			// board.get()에서 데이터가 존재하지 않는 경우
		} 
		
		return dto;
	}

	@Override
	public void updateBoard(Board dto) throws Exception {
		boardRepository.save(dto); // save : 행이 존재하면 update, 행이 없으면 insert 해줌
	}

	@Override
	public void deleteBoard(long num) throws Exception {
		boardRepository.deleteById(num);
	}

	@Override
	public void updateReadCount(long num) throws Exception {
		boardRepository.updateReadCount(num);
	}
	
	
}
