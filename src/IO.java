/**
 * Created by DagInge on 4/7/2015.
 */
public class IO {
    private final Queue ioQueue;
    private Process activeProcess;
    private int longestQueue;
    private Process lastActiveProcess;
    private int totalQueueLength = 0;

    public IO(Queue ioQueue){
        activeProcess = null;
        this.ioQueue = ioQueue;
    }

    public Process getActiveProcess() {
        return activeProcess;
    }

    public void setActiveProcess(Process activeProcess, long clock) {
        this.activeProcess = activeProcess;
        if(activeProcess != null){
            activeProcess.setTimeSpentWaitingForIo(activeProcess.getTimeSpentWaitingForIo() + clock - activeProcess.getTimePutInIoQueue());
            lastActiveProcess = activeProcess;
            activeProcess.setTimePutInCPU(clock);

        }else{
            lastActiveProcess.setTimeSpentInIo(lastActiveProcess.getTimeSpentInIo() + clock-lastActiveProcess.getTimePutInIo());
        }
    }

    public boolean hasActiveProcess(){
        if (activeProcess == null){
            return false;
        }else{
            return true;
        }
    }

    public void insertQueue(Process p, long clock){
        this.ioQueue.insert(p);
        p.setTimePutInIoQueue(clock);
        p.increaseNofTimesInIoQueue();

        if (this.ioQueue.getQueueLength() > this.longestQueue){
            this.longestQueue = this.ioQueue.getQueueLength();
        }

    }

    public void saveQueueLength() {
        totalQueueLength += ioQueue.getQueueLength();
    }

    public int getTotalQueueLength() {
        return totalQueueLength;
    }

    public int getLongestQueue() {
        return longestQueue;
    }
}
