package com.distribuida.service;

import java.util.List;
import com.distribuida.model.Singer;;

public interface ServiceSinger {
	public Singer addSinger(Singer e);
	public void deleteSinger(Integer id);
	public Singer getSinger(Integer id);
	public List<Singer> listSingers();
	public Singer updateSinger(Singer e);
}
