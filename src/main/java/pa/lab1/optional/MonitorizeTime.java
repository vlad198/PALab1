package pa.lab1.optional;

public class MonitorizeTime {

    private long start;
    private long end;

    MonitorizeTime() {
        start = end = 0;
    }


    public void setStart() {
        this.start = System.nanoTime();
    }

    public void setEnd() {
        this.end = System.nanoTime();
    }

    public long getTimeBetween() {
        return end - start;
    }
}
