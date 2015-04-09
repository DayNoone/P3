/**
 * Created by DagInge on 4/7/2015.
 */
public class CPU {

    private final Queue cpuQueue;
    private Process activeProcess;

    public int getLongestQueue() {
        return longestQueue;
    }

    private int longestQueue;

    public long getTimeProcessed() {
        return timeProcessed;
    }

    private long timeProcessed;
    private long start, end;

    public CPU(Queue cpuQueue){
        activeProcess = null;
        timeProcessed = 0;
        this.cpuQueue = cpuQueue;
        this.longestQueue = 0;
    }

    public Process getActiveProcess() {
        return activeProcess;
    }

    public void setActiveProcess(Process activeProcess, long clock) {
        if (activeProcess != null){
            this.start = clock;
        }else{
            this.end = clock;
            long runtime = this.end - this.start;
            this.timeProcessed += runtime;
        }
        this.activeProcess = activeProcess;
    }

    public boolean hasActiveProcess(){
        if (activeProcess == null){
            return false;
        }else{
            return true;
        }
    }

    public void insertQueue(Process p){
        this.cpuQueue.insert(p);
        p.increaseNofTimesInReadyQueue();
        if (cpuQueue.getQueueLength() > this.longestQueue){
            this.longestQueue = cpuQueue.getQueueLength();
        }
    }
}
