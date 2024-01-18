package lt.techin.exam.service.impl;

import lombok.extern.slf4j.Slf4j;
import lt.techin.exam.dao.FavoriteSongRepository;
import lt.techin.exam.entity.ObjectMapper;
import lt.techin.exam.entity.Song;
import lt.techin.exam.entity.SongEntity;
import lt.techin.exam.exception.SongNotFoundException;
import lt.techin.exam.service.ISongFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SongFavoriteService implements ISongFavoriteService {

    private final FavoriteSongRepository favoriteSongRepository;

    @Autowired
    public SongFavoriteService(FavoriteSongRepository favoriteSongRepository) {
        this.favoriteSongRepository = favoriteSongRepository;
    }

    @Override
    public List<Song> findAll() {
        final List<SongEntity> listSongs = favoriteSongRepository.findAll();
        return listSongs.stream()
                .map(ObjectMapper::songEntityToSong)
                .collect(Collectors.toList());
    }

    @Override
    public Song save(Song song) {
//        final SongEntity songEntity = songToSongEntity(song);
        final SongEntity songEntity = ObjectMapper.songToSongEntity(song);
        songEntity.setId(String.valueOf(UUID.randomUUID()));
        final SongEntity savedSongEntity = favoriteSongRepository.save(songEntity);
        return ObjectMapper.songEntityToSong(savedSongEntity);
    }

    @Override
    public void delete(SongEntity songEntity) {
        Optional<SongEntity> songToDelete = favoriteSongRepository.findById(songEntity.getId());

        if (songToDelete.isPresent()) {
            favoriteSongRepository.delete(songEntity);
        } else {
            throw new SongNotFoundException("no favourites to delete");
        }
    }


}
