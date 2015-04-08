/**
 * Created by DagInge on 4/7/2015.
 */
public class CPU {

    private Process activeProcess;

    public CPU(){
        activeProcess = null;
    }

    public Process getActiveProcess() {
        return activeProcess;
    }

    public void setActiveProcess(Process activeProcess) {
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
