package lt.techin.exam.service.impl;

import lombok.extern.slf4j.Slf4j;
import lt.techin.exam.dao.FavoriteSongRepository;
import lt.techin.exam.entity.Song;
import lt.techin.exam.entity.SongEntity;
import lt.techin.exam.service.ISongFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .map(this::songEntityToSong)
                .collect(Collectors.toList());
    }

    @Override
    public Song save(Song song) {
        final SongEntity songEntity = songToSongEntity(song);
        songEntity.setId(String.valueOf(UUID.randomUUID()));
        final SongEntity savedSongEntity = favoriteSongRepository.save(songEntity);
        return songEntityToSong(savedSongEntity);
    }


    @Override
    public void delete(Song song) {
        final SongEntity songEntity = songToSongEntity(song);
        favoriteSongRepository.delete(songEntity);
        try {
            favoriteSongRepository.delete(songEntity);
        } catch (final EmptyResultDataAccessException e) {
            log.debug("trying to delete non-existing song", e);
        }
    }

    private SongEntity songToSongEntity(Song song) {
        return SongEntity.builder()
                .id(song.getId())
                .author(song.getAuthor())
                .title(song.getTitle())
                .build();
    }

    private Song songEntityToSong(SongEntity songEntity) {
        return Song.builder()
                .id(songEntity.getId())
                .author(songEntity.getAuthor())
                .title(songEntity.getTitle())
                .build();
    }

}
