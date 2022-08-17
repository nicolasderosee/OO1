package ar.edu.unlp.info.oo1.ejercicio10JobScheduler;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
	
	private String strategy;
	private List <JobDescription> jobs = new ArrayList<JobDescription>();
	
	
	public void schedule(JobDescription job) {	
		this.jobs.add(job);
	}
	
	public JobDescription next() {
		return null;
	}
}
