package pl.kambu.currencyrest.logging;

import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Service
public class LoggerService {
    private LoggerRepository loggerRepository;


    public LoggerService(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    public void addLog(Logger log) {
        loggerRepository.save(log);
    }

    public void toLog(String message) throws UnknownHostException {
        Logger logger = new Logger(LocalDateTime.now().toString(), InetAddress.getLocalHost().getHostAddress(), message);
        loggerRepository.save(logger);
    }

}
