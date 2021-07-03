package pl.pjatk.jazs21164nbp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String currency;
    private String startDate;
    private String endDate;
    private double averageExchangeRate;
    private LocalDateTime timeStamp;

    public Archive() {
    }

    public Archive(String currency, String startDate, String endDate, double averageExchangeRate, LocalDateTime timeStamp) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.averageExchangeRate = averageExchangeRate;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getAverageExchangeRate() {
        return averageExchangeRate;
    }

    public void setAverageExchangeRate(double averageExchangeRate) {
        this.averageExchangeRate = averageExchangeRate;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
