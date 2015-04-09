/**
 * Created by DagInge on 4/7/2015.
 */
public class CPU {

    private Process activeProcess;

    public long getTimeProcessed() {
        return timeProcessed;
    }

    private long timeProcessed;
    private long start, end;

    public CPU(){
        activeProcess = null;
        timeProcessed = 0;
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
}
