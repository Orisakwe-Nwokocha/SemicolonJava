public class Time2Enhanced {
    private int hour;
    private int minute;
    private int second;

    public Time2Enhanced() {
        this(0, 0, 0);
    }
    
    public Time2Enhanced(int hour) {
        this(hour, 0, 0);
    }
    
    public Time2Enhanced(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Time2Enhanced(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }

        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        } 
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time2Enhanced(Time2Enhanced time) {
        this(time.hour, time.minute, time.second);
    }

    public void setTime(int hour, int minute, int second) {
       if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }

        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        } 
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;        
        
    }
    
    public void setHour(int hour) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        
         this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
                
        this.minute = minute;    
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        this.second = second;    
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getSecondsSinceMidnight() {
        return (getHour()* 3600) + (getMinute() * 60) + getSecond();
    }
    
    public void tick() {
        second++;
        if (second >= 60) {
            second = 0;
            minute++;
            
            if (minute >= 60) {
                minute = 0;
                hour++;
                
                if (hour >= 24) hour = 0;
            }
        }
    }
    
    public void incrementMinute() {
        minute++;
        if (minute >= 60) {
            minute = 0;
            hour++;
            
            if (hour >= 24) hour = 0;
        }
    }
    
    public void incrementHour() {
        hour++;
        if (hour >= 24) hour = 0;
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
    
    public String toString() {
        return String.format("%02d:%02d:%02d %s", (getHour() == 0 || getHour() == 12 ? 12 : getHour() % 12), getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}