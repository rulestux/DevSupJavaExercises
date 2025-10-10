package entities;

import java.time.LocalDateTime;

public class LogEntry {

    private String username;
    private LocalDateTime moment;

    public LogEntry(String username, LocalDateTime moment) {
        this.username = username;
        this.moment = moment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntry object = (LogEntry) o;

        return !(username != null ? !username.equals(object.username) : object.username != null);
    }
}
