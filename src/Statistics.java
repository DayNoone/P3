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

    public long processChangeRoundRobin = 0;

    public long nofCompletedIoProcesses = 0;

	public long cpuTimeProcessed = 0;

    public long longestCpuQueue = 0;

    public long longestIoQueue = 0;

    public long avgCpuQueue = 0;

    public long nofTimesInCpuQueue = 0;

    public long avgIoQueue = 0;

    public long nofTimesInIoQueue = 0;

    public long totalTimeSpentInSystem = 0;

    public long totalCpuWaitingTime = 0;

    public long totalProcessingTime = 0;

    public long totalIoWaitingTime = 0;

    public long totalIoProcessingTime = 0;
    /*
    Number of completed processes: 39
    Number of created processes: 48
    Number of (forced) process switches: 207
    Number of processed I/O operations: 753
    Average throughput (processes per second): 0.156
    Total CPU time spent processing: 199213 ms
    Fraction of CPU time spent processing: 79.6852%
    Total CPU time spent waiting: 50787 ms
    Fraction of CPU time spent waiting: 20.3148%
    Largest occuring memory queue length: 2
    Average memory queue length: 0.13544
    Largest occuring cpu queue length: 6
    Average cpu queue length: 1.753956
    Largest occuring I/O queue length: 6
    Average I/O queue length: 1.121616
    Average # of times a process has been placed in memory queue: 1
    Average # of times a process has been placed in cpu queue: 20.333334
    Average # of times a process has been placed in I/O queue: 14.256411
    Average time spent in system per process: 22772 ms
    Average time spent waiting for memory per process: 657 ms
    Average time spent waiting for cpu per process: 10104 ms
    Average time spent processing per process: 4465 ms
    Average time spent waiting for I/O per process: 4329 ms
    Average time spent in I/O per process: 3215 ms
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
        System.out.println("Number of (forced) process switches:                          "+processChangeRoundRobin);
        System.out.println("Number of processed I/O operations:                           "+nofCompletedIoProcesses);
        System.out.println("Average throughput (processes per second)                     "+nofCompletedProcesses/simulationLength*1000);
        System.out.println();
        System.out.println("Total cpu time spent processing                               "+cpuTimeProcessed+" ms");
        System.out.println("Fraction of CPU time spent processing                         "+String.format("%.2f", (float)cpuTimeProcessed/simulationLength*100)+"%");
        System.out.println("Total CPU time spent waiting:                                 "+(simulationLength-cpuTimeProcessed)+" ms");
        System.out.println("Fraction of CPU time spent waiting:                           "+String.format("%.2f", (float)(simulationLength-cpuTimeProcessed)/simulationLength*100)+"%");

        System.out.println();
        System.out.println("Largest occuring memory queue length:                         "+memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                  "+(float)memoryQueueLengthTime/simulationLength);
        System.out.println("Largest occuring cpu queue length:                            "+longestCpuQueue);
        System.out.println("Average cpu queue length:                                     "+avgCpuQueue);
        System.out.println("Largest occuring I/O queue length:                            "+longestIoQueue);
        System.out.println("Average I/O queue length:                                     "+avgIoQueue);
        if(nofCompletedProcesses > 0) {
			System.out.println("Average # of times a process has been placed in memory queue:  "
                    + 1);
            System.out.println("Average # of times a process has been placed in cpu queue:     "
                    + (float) nofTimesInCpuQueue / nofCompletedProcesses);
            System.out.println("Average # of times a process has been placed in I/O queue:     "
                    + (float) nofTimesInIoQueue / nofCompletedProcesses);
            System.out.println("Average time spent in system per process                       "
                    + (float) totalTimeSpentInSystem / nofCompletedProcesses + " ms");
			System.out.println("Average time spent waiting for memory per process:             "
                    + totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
            System.out.println("Average time spent waiting for cpu per process:                "
                    + totalCpuWaitingTime / nofCompletedProcesses + " ms");
            System.out.println("Average time spent processing per process:                     "
                    + totalProcessingTime / nofCompletedProcesses + " ms");
            System.out.println("Average time spent waiting for I/O per process:                "
                    + totalIoWaitingTime / nofCompletedProcesses + " ms");
            System.out.println("Average time spent in I/O per process:                         "
                    + totalIoProcessingTime / nofCompletedProcesses + " ms");
		}
	}
}
