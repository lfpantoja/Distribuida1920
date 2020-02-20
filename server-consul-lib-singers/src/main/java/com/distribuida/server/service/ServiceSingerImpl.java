package com.distribuida.server.service;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.server.conf.DbProducer;
import com.distribuida.server.model.Singer;

@ApplicationScoped
public class ServiceSingerImpl implements ServiceSinger{
	
	@Inject private DbProducer conn;
	private PreparedStatement pst;
	public static final String SELECT_SINGER = "SELECT * FROM singer ORDER BY id;";
	public static final String SELECT_SINGER_ID = "SELECT * FROM singer WHERE id = ?";
	
	@Override
	public List<Singer> listSingers() {
		List<Singer> albums = new ArrayList<Singer>();
		
		try {
			Connection con = conn.getDataSource().getConnection();
			PreparedStatement pst = con.prepareStatement(SELECT_SINGER);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Singer album = new Singer();
				album.setId(rs.getInt(1));
				album.setFirstName(rs.getString(2));
				album.setLastName(rs.getString(3));
				album.setBirthDate(rs.getDate(4));
				
				albums.add(album);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albums;
	}

	@Override
	public Singer getSinger(Integer id) {
		Singer album = new Singer();
		try {
			Connection con = conn.getDataSource().getConnection();
			pst = con.prepareStatement(SELECT_SINGER_ID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				album.setId(rs.getInt(1));
				album.setFirstName(rs.getString(2));
				album.setLastName(rs.getString(3));
				album.setBirthDate(rs.getDate(4));
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}
	
}
