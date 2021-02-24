package pa.lab1.optional;

public class ContorizeTime {

    private long start;
    private long end;

    ContorizeTime() {
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
