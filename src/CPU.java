/**
 * Created by DagInge on 4/7/2015.
 */
public class CPU {

    private final Queue cpuQueue;
    private Process activeProcess;
    private int longestQueue;
    private long timeProcessed;
    private long start, end;

    public CPU(Queue cpuQueue){
        activeProcess = null;
        timeProcessed = 0;
        this.cpuQueue = cpuQueue;
        this.longestQueue = 0;
    }

    public boolean hasActiveProcess(){
        if (activeProcess == null){
            return false;
        }else{
            return true;
        }
    }

    public void insertQueue(Process p, long clock){
        this.cpuQueue.insert(p);
        p.setTimePutInReadyQueue(clock);
        p.increaseNofTimesInReadyQueue();
        if (cpuQueue.getQueueLength() > this.longestQueue){
            this.longestQueue = cpuQueue.getQueueLength();
        }
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

        activeProcess.setTimeSpentInReadyQueue(activeProcess.getTimePutInReadyQueue() + clock - activeProcess.getTimePutInReadyQueue());
    }

    public Process getActiveProcess() {
        return activeProcess;
    }

    public int getLongestQueue() {
        return longestQueue;
    }

    public long getTimeProcessed() {
        return timeProcessed;
    }
}
