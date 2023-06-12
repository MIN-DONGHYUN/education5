package com.jpa.app.service;

import java.util.List;

import com.jpa.app.domain.Guestbook;

public interface InterGuestService {
	public void insertGuest(Guestbook entity) throws Exception;
	public void updateGuest(Guestbook entity) throws Exception;
	public void deleteGuest(long num) throws Exception;
	
	public List<Guestbook> listGuest() throws Exception;
	public Guestbook viewGuest(long num) throws Exception;
}
