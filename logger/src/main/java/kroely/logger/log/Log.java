package kroely.logger.log;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Logs")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Long id;

    @Column(name = "message")
    String message;

    @Column(name = "user_id")
    String userId;

    @Column(name = "app")
    String app;

    @Column(name = "created_at")
    LocalDate createdAt;
}
