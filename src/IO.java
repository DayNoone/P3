/**
 * Created by DagInge on 4/7/2015.
 */
public class IO {
    private Process activeProcess;

    public IO(){
        activeProcess = null;
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
}
