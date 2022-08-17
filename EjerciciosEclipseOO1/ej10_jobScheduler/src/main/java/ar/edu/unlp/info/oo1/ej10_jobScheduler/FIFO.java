package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class FIFO extends JobScheduler {

	@Override
	protected JobDescription next() {
		JobDescription nextJob = null;
		nextJob = this.getJobs().get(0);
		this.unschedule(nextJob);
		return nextJob;
	}

}
