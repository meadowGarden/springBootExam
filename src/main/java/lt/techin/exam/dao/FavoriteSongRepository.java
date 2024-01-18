package lt.techin.exam.dao;

import lt.techin.exam.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FavoriteSongRepository extends JpaRepository<SongEntity, UUID> {
}
