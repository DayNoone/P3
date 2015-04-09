/**
 * Created by DagInge on 4/7/2015.
 */
public class IO {
    private final Queue ioQueue;
    private Process activeProcess;
    private int longestQueue;

    public int getLongestQueue() {
        return longestQueue;
    }

    public IO(Queue ioQueue){
        activeProcess = null;
        this.ioQueue = ioQueue;
    }

    public Process getActiveProcess() {
        return activeProcess;
    }

    public void setActiveProcess(Process activeProcess) {
        this.activeProcess = activeProcess;
        if(activeProcess != null){

        }
    }

    public boolean hasActiveProcess(){
        if (activeProcess == null){
            return false;
        }else{
            return true;
        }
    }

    public void insert(Process p){
        if (this.ioQueue.getQueueLength() > this.longestQueue){
            this.longestQueue = this.ioQueue.getQueueLength();
        }
        this.ioQueue.insert(p);
    }
}
