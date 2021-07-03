package pl.pjatk.jazs21164nbp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jazs21164nbp.model.Archive;
import pl.pjatk.jazs21164nbp.service.ArchiveService;
import pl.pjatk.jazs21164nbp.service.StatisticsService;

@RestController
public class StatisticsController {

    private StatisticsService statisticsService;
    private ArchiveService archiveService;

    public StatisticsController(StatisticsService statisticsService, ArchiveService archiveService) {
        this.statisticsService = statisticsService;
        this.archiveService = archiveService;
    }

    @GetMapping("calculate/{currency}")
    ResponseEntity<Archive> getAverage(@PathVariable String currency, @RequestParam String startDate, @RequestParam String endDate) {
        Archive statistics = statisticsService.calculateStatisticsInRange(startDate, endDate, currency);
        return ResponseEntity.ok(archiveService.addArchive(statistics));
    }

}
