package models.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class UserIP {
    private String ip;
    private LocalDateTime time;

    public UserIP() {
    }

    public UserIP(String ip) {
        this.ip = ip;
        this.time = LocalDateTime.now();
    }

    public UserIP(String ip, LocalDateTime time) {
        this.ip = ip;
        this.time = time;
    }
}
