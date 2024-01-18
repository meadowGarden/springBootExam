package lt.techin.exam.service;

import lt.techin.exam.entity.Song;
import lt.techin.exam.entity.SongEntity;

import java.util.List;

public interface ISongFavoriteService {
    List<Song> findAll();
    Song save(Song song);
    void delete(SongEntity songEntity);

}
