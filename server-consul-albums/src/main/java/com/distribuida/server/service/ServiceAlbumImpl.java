package com.distribuida.server.service;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.server.conf.DbProducer;
import com.distribuida.server.model.Album;

@ApplicationScoped
public class ServiceAlbumImpl implements ServiceAlbum{
	
	@Inject private DbProducer conn;
	private PreparedStatement pst;
	public static final String SELECT_SINGER = "SELECT * FROM album ORDER BY id;";
	public static final String SELECT_SINGER_ID = "SELECT * FROM album WHERE id = ?";
	
	@Override
	public List<Album> listAlbums() {
		List<Album> albums = new ArrayList<Album>();
		
		try {
			Connection con = conn.getDataSource().getConnection();
			PreparedStatement pst = con.prepareStatement(SELECT_SINGER);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Album album = new Album();
				album.setId(rs.getInt(1));
				album.setSingerId(rs.getInt(2));
				album.setTitle(rs.getString(3));
				album.setReleaseDate(null);
				
				albums.add(album);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albums;
	}

	@Override
	public Album getAlbum(Integer id) {
		Album album = new Album();
		try {
			Connection con = conn.getDataSource().getConnection();
			pst = con.prepareStatement(SELECT_SINGER_ID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				album.setId(rs.getInt(1));
				album.setSingerId(rs.getInt(2));
				album.setTitle(rs.getString(3));
				album.setReleaseDate(null);
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}
	
}
