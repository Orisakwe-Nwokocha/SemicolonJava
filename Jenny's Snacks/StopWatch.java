public class StopWatch {
    private long startTime;
    private long endTime;


    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start(long timeReset) {
        this.startTime = timeReset;
    }

    public void stop(long endTime) {
        this.endTime = endTime;
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }
}
