package lt.techin.exam.controller;

import lt.techin.exam.entity.ObjectMapper;
import lt.techin.exam.entity.Song;
import lt.techin.exam.entity.SongEntity;
import lt.techin.exam.entity.SongToDisplay;
import lt.techin.exam.service.impl.SongFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/api")
public class SongController {

    private final SongFavoriteService songFavoriteService;

    @Autowired
    public SongController(SongFavoriteService songFavoriteService) {
        this.songFavoriteService = songFavoriteService;
    }

    @GetMapping(path = "/favourites")
    public ResponseEntity<List<SongToDisplay>> findAll() {
        final List<Song> songs = songFavoriteService.findAll();
        final List<SongToDisplay> songsToDisplay = songs.stream()
                .map(ObjectMapper::songToSongToDisplay)
                .toList();
        return new ResponseEntity<>(songsToDisplay, HttpStatus.OK);
    }

    @PostMapping(path = "/favourites")
    public ResponseEntity<List<SongToDisplay>> saveSong(@RequestBody Song song) {
        songFavoriteService.save(song);
        final List<Song> songs = songFavoriteService.findAll();
        final List<SongToDisplay> songsToDisplay = songs.stream()
                .map(ObjectMapper::songToSongToDisplay)
                .toList();
        return new ResponseEntity<>(songsToDisplay, HttpStatus.OK);
    }

    @DeleteMapping(path = "favourites")
    public ResponseEntity<List<SongToDisplay>> deleteSong(@RequestBody SongEntity songEntity) {
        songFavoriteService.delete(songEntity);
        final List<Song> songs = songFavoriteService.findAll();
        final List<SongToDisplay> songsToDisplay = songs.stream()
                .map(ObjectMapper::songToSongToDisplay)
                .toList();
        return new ResponseEntity<>(songsToDisplay, HttpStatus.OK);
    }

}