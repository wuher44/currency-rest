package pl.kambu.currencyrest.logging;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String localDateTime;
    private String ipAddress;
    private String logMessage;

    public Logger() {
    }


    public Logger(String localDateTime, String ipAddress, String logMessage) {
        this.localDateTime = localDateTime;
        this.ipAddress = ipAddress;
        this.logMessage = logMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }


}
