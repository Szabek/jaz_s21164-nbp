package pl.pjatk.jazs21164nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jazs21164nbp.model.Archive;
import pl.pjatk.jazs21164nbp.model.NbpRoot;
import pl.pjatk.jazs21164nbp.model.Rate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class StatisticsService {

    private RestTemplate restTemplate;
    private static final String BASE_URL = "http://api.nbp.pl/api/exchangerates/rates/a/";

    public StatisticsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Archive calculateStatisticsInRange(String startDate, String endDate, String currency) {
        NbpRoot nbpRoot = getStatistics(startDate, endDate, currency);
        double averageExchangeRate = calculateAverage(nbpRoot.getRates());
        return new Archive(currency, startDate, endDate, averageExchangeRate, LocalDateTime.now());
    }

    public NbpRoot getStatistics(String  startDate, String endDate, String currency) {
        return restTemplate.
                getForObject(BASE_URL + currency + "/" + startDate + "/" + endDate + "/?format=json", NbpRoot.class);
    }

    public double calculateAverage(List<Rate> rateList) {
        double sum = 0.0;
        for (Rate rate : rateList) {
            double rateMid = rate.getMid();
            sum += rateMid;
        }
        return sum / rateList.size();
    }
}
