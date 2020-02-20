package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Singer;

public interface ServiceSinger {
	
	public Singer getSinger(Integer id);
	public List<Singer> listSingers();
	
//	public Singer addSinger(Singer e);
//	public void deleteSinger(Integer id);
//	public Singer updateSinger(Integer id, Singer e);
}
