package kroely.logger.amqp;

import kroely.logger.log.LogService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LogConsumer {

    private final LogService service;


    @RabbitListener(queues = "log", messageConverter = "Jackson2JsonMessageConverter")
    public void consumer(LogRequest logRequest) {
        System.out.println(logRequest);
        service.create(logRequest);
    }
}
