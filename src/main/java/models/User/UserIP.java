package models.User;

import java.time.LocalDateTime;

public class UserIP {
    private String ip;
    private LocalDateTime time;

    public UserIP() {}

    public UserIP(String ip) {
        this.ip = ip;
        this.time = LocalDateTime.now();
    }

    public UserIP(String ip, LocalDateTime time) {
        this.ip = ip;
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
