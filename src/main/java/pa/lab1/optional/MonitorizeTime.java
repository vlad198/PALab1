package pa.lab1.optional;

public class MonitorizeTime {

    private long start;
    private long end;

    /**
     * Default Constructor
     */
    MonitorizeTime() {
        start = end = 0;
    }

    /**
     * set start time
     */
    public void setStart() {
        this.start = System.nanoTime();
    }

    /**
     * set end time
     */
    public void setEnd() {
        this.end = System.nanoTime();
    }

    /**
     * Calculate time between start and end variables
     *
     * @return time between those variables
     */
    public long getTimeBetween() {
        return end - start;
    }
}
