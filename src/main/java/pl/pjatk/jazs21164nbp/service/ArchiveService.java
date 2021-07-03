package pl.pjatk.jazs21164nbp.service;

import org.springframework.stereotype.Service;
import pl.pjatk.jazs21164nbp.model.Archive;
import pl.pjatk.jazs21164nbp.repository.ArchiveRepository;

@Service
public class ArchiveService {

    private ArchiveRepository archiveRepository;

    public ArchiveService(ArchiveRepository archiveRepository) {
        this.archiveRepository = archiveRepository;
    }

    public Archive addArchive(Archive archive) {

        return archiveRepository.save(archive);
    }

}
