package com.springdataone.lookify.repositories;

import com.springdataone.lookify.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    // this method retrieves all the songs from the database
    List<Song> findAll();
    //this method finds songs with  an artist containing the search string
    List<Song> findByArtistContaining(String artistName);
    //this method finds the top 10 songs ordered by rating
    List<Song> findTop10ByOrderByRatingDesc();
}
