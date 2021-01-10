package com.springdataone.lookify.services;

import com.springdataone.lookify.models.Song;
import com.springdataone.lookify.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
    // returns all the songs
    public List<Song> allSongs(){
        return songRepository.findAll();
    }
    // creates a song
    public Song createSong(Song s) {
        return songRepository.save(s);
    }
    // retrieves a song
    public Song findSong(Long id) {
        Optional<Song> songToFind = songRepository.findById(id);
        if (songToFind.isPresent())
            return songToFind.get();
        else
            return null;
    }
    // updates a song
    public Song updateSong(Song s){
        s.setTitle(s.getTitle());
        s.setArtist(s.getArtist());
        s.setRating(s.getRating());
        return songRepository.save(s);
    }
    // deletes a song
    public void deleteSong(Long id){
        songRepository.deleteById(id);
    }
    // retrieves a song list based on artist name
    public List<Song> findSongList(String artistName) {
        List<Song> songList = songRepository.findByArtistContaining(artistName);
        if (songList.isEmpty())
            return null;
        else
            return songList;
    }
    // retrieves the top 10 songs ordered by rating
    public List<Song> findTopten(){
        List<Song> topTen = songRepository.findTop10ByOrderByRatingDesc();
        if (topTen.isEmpty())
            return null;
        else
            return topTen;
    }
}
