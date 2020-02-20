package com.distribuida.gateway.service;

import java.util.List;

import com.distribuida.gateway.model.Singer;

public interface ServiceSinger {
	public Singer getSinger(Integer id);
	public List<Singer> listSingers();
}
