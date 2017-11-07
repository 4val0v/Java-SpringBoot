package com.codingdojo.lookify.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {

    private SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
    
    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    
    public List<Song> topTen() {
    		return songRepository.findTop10ByOrderByRatingDesc();
    }
    
    public List<Song> searchByArtist(String artist) {
    		return songRepository.findByArtistContaining(artist);
    }

    public Song getSong(Long id) {
		return songRepository.findOne(id);
	}
    
    @Transactional
    public void addSong(Song song) {
    		songRepository.save(song);
    }
    
    @Transactional
    public void editSong(Song song) {
    		songRepository.save(song);
    }
    
    public void deleteSong(Long id) {
    		songRepository.delete(id);
    }
}

