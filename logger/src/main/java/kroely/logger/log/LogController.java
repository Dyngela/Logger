package kroely.logger.log;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/log/")
@RestController
@Log4j2
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LogController {

    LogService service;

    @GetMapping("/apps")
    public ResponseEntity<AppListResponse> getAllAppsName() {
        return ResponseEntity.ok(service.getAppNames());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Log>> getAllLogs() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Log> getLogById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLogById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Log>> getLogsByAppName(@PathVariable String name) {
        return ResponseEntity.ok(service.getLogsByAppName(name));
    }
}
