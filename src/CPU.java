/**
 * Created by DagInge on 4/7/2015.
 */
public class CPU {

    private final Queue cpuQueue;
    private Process activeProcess;
    private int longestQueue;
    private int totalQueueLength = 0;
    private long timeProcessed;
    private long start, end;
    private Process lastActiveProcess;

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

    public Process getActiveProcess() {
        return activeProcess;
    }

    public void setActiveProcess(Process activeProcess, long clock) {
        if (activeProcess != null){
            lastActiveProcess = activeProcess;
            activeProcess.setTimePutInCPU(clock);
            this.start = clock;
            activeProcess.setTimeSpentInReadyQueue(activeProcess.getTimeSpentWaitingForCpu() + clock - activeProcess.getTimePutInReadyQueue());
        }else{
            lastActiveProcess.setTimeSpentInCpu(lastActiveProcess.getTimeSpentInCpu() + clock - lastActiveProcess.getTimePutInCPU());
            this.end = clock;
            long runtime = this.end - this.start;
            this.timeProcessed += runtime;
        }
        this.activeProcess = activeProcess;
    }

    public void saveQueueLength() {
        totalQueueLength += cpuQueue.getQueueLength();
    }

    public int getTotalQueueLength() {
        return totalQueueLength;
    }

    public int getLongestQueue() {
        return longestQueue;
    }

    public long getTimeProcessed() {
        return timeProcessed;
    }
}
