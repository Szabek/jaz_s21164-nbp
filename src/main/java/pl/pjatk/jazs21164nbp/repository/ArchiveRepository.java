package pl.pjatk.jazs21164nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.jazs21164nbp.model.Archive;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long> {

}
