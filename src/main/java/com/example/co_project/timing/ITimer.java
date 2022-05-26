package com.example.co_project.timing;

public interface ITimer {

	/**
	 * Starts a new timer. <br>
	 * If called without a prior <b>stop</b>, it resets the current time loosing
	 * all time information.
	 * @return
	 */
	public long start();

	/**
	 * Stop and reset current timer.
	 * 
	 * @return Elapsed <b>nanoseconds</b> since <b>start</b> was invoked.
	 */
	public long stop();

	/**
	 * Pauses the running timer. Can be later resumed by calling <b>resume</b>.	 
	 * @return Elapsed <b>nanoseconds</b> since <b>start</b> was invoked.
	 */
	public long pause();
	
	/**
	 * Resumes the paused timer. <br>	 
	 * If timer is not paused it starts it.
     * @return
     */
	public double resume();

}
