/**
 * This class contains a lot of public variables that can be updated
 * by other classes during a simulation, to collect information about
 * the run.
 */
public class Statistics
{
	/** The number of processes that have exited the system */
	public long nofCompletedProcesses = 0;
	/** The number of processes that have entered the system */
	public long nofCreatedProcesses = 0;
	/** The total time that all completed processes have spent waiting for memory */
	public long totalTimeSpentWaitingForMemory = 0;
	/** The time-weighted length of the memory queue, divide this number by the total time to get average queue length */
	public long memoryQueueLengthTime = 0;
	/** The largest memory queue length that has occured */
	public long memoryQueueLargestLength = 0;

    /*
     Antall ferdige prosesser
     Antall opprettede prosesser
     Antall prosessskifter (som skyldes oppbrukt tidskvant)
     Antall utførte I/O-operasjoner
     Gjennomsnittlig gjennomstrømning (ferdige prosesser per sekund)
     Total tid CPU har brukt på å prosessere
     Total tid CPU har vært ledig
     Prosentvis hvor mye tid CPU har brukt på å prosessere (utilisasjon)
     Prosentvis hvor lenge CPU har vært ledig
     Størst forekommende samt
     gjennomsnittlig lengde på alle køer
     Hvor mange ganger en ferdige prosess gjennomsnittlig har blitt plassert i hver enkelt kø
        memory
         io
         cpu
     Gjennomsnittlig tid tilbrakt i systemet per ferdige prosess
     Gjennomsnittlig tid ventende på tilstrekkelig lagerplass per ferdige prosess
     Gjennomsnittlig tid ventende på CPU-kraft per ferdige prosess
     Gjennomsnittlig tid brukt i CPU per ferdige prosess
     Gjennomsnittlig tid ventende på I/O-kapasitet per ferdige prosess
     Gjennomsnittlig tid brukt i I/O per ferdige prosess
    */

	/**
	 * Prints out a report summarizing all collected data about the simulation.
	 * @param simulationLength	The number of milliseconds that the simulation covered.
	 */
	public void printReport(long simulationLength) {
		System.out.println();
		System.out.println("Simulation statistics:");
		System.out.println();
		System.out.println("Number of completed processes:                                "+nofCompletedProcesses);
		System.out.println("Number of created processes:                                  "+nofCreatedProcesses);
		System.out.println();
		System.out.println("Largest occuring memory queue length:                         "+memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                  "+(float)memoryQueueLengthTime/simulationLength);
		if(nofCompletedProcesses > 0) {
			System.out.println("Average # of times a process has been placed in memory queue: "+1);
			System.out.println("Average time spent waiting for memory per process:            "+
				totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
		}
	}
}
