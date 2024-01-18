package lt.techin.exam.entity;

public class ObjectMapper {
    public static SongEntity songToSongEntity(Song song) {
        return SongEntity.builder()
                .id(song.getId())
                .author(song.getAuthor())
                .title(song.getTitle())
                .build();
    }

    public static Song songEntityToSong(SongEntity songEntity) {
        return Song.builder()
                .id(songEntity.getId())
                .author(songEntity.getAuthor())
                .title(songEntity.getTitle())
                .build();
    }

    public static SongToDisplay songToSongToDisplay(Song song) {
        return SongToDisplay.builder()
                .author(song.getAuthor())
                .title(song.getTitle())
                .build();
    }


}
