package pl.pjatk.jazs21164nbp.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "Get average exchange rate",
            response = Archive.class,
            notes = "This method will return average exchange rate in date range")
    @GetMapping("calculate/{currency}")
    ResponseEntity<Archive> getAverage(
            @ApiParam(
                    name = "currency",
                    type = "String",
                    value = "some currency code",
                    example = "EUR",
                    required = true,
                    defaultValue = "GBP")
            @PathVariable String currency,
            @ApiParam(
                    name = "startDate",
                    type = "date",
                    value = "some date",
                    example = "2012-01-31")
            @RequestParam String startDate,
            @ApiParam(
                    name = "endDate",
                    type = "date",
                    value = "some date",
                    example = "2012-01-31")
            @RequestParam String endDate) {
        Archive statistics = statisticsService.calculateStatisticsInRange(startDate, endDate, currency);
        return ResponseEntity.ok(archiveService.addArchive(statistics));
    }

}
