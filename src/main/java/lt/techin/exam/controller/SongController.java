package lt.techin.exam.controller;

import lt.techin.exam.entity.Song;
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

    @GetMapping(path = "/songs")
    public ResponseEntity<List<Song>> findAll() {
        return new ResponseEntity<>(songFavoriteService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/songs")
    public ResponseEntity<Song> saveProduct(@RequestBody Song song) {
        Song songToSave = songFavoriteService.save(song);
        return new ResponseEntity<>(songToSave, HttpStatus.CREATED);
    }




}











