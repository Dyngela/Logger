package kroely.logger.log;

import kroely.logger.amqp.LogRequest;
import kroely.logger.exception.ExceptionHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class LogService {

    LogRepository logRepository;

    public AppListResponse getAppNames() {
        try {
            return new AppListResponse(logRepository.findAllAppName());
        } catch (Exception e) {
            throw new ExceptionHandler("Getting app names is not working " + e.getMessage());
        }
    }

    public List<Log> getAll() {
        try {
            return logRepository.findAll();
        } catch (Exception e) {
            throw new ExceptionHandler("Getting all is not working " + e.getMessage());
        }
    }

    public Log getLogById(Long id) {
        try {
            return logRepository.findById(id).orElseThrow(() -> new ExceptionHandler("Log not found"));
        } catch (Exception e) {
            throw new ExceptionHandler("Getting log by id is not working " + e.getMessage());
        }
    }

    public List<Log> getLogsByAppName(String name) {
        try {
            return logRepository.findAllByApp(name);
        } catch (Exception e) {
            throw new ExceptionHandler("Getting app names is not working " + e.getMessage());
        }
    }

    public void create(LogRequest log) {
        try {
            Log newLog = new Log(null, log.getMessage(), log.getUserId(), log.getApp(), LocalDate.now());
            logRepository.save(newLog);
        } catch (Exception e) {
            throw new ExceptionHandler("Log creation did not work: " + e.getMessage());
        }
    }

}
