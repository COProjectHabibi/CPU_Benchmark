package com.example.co_project.testbanch;

import com.example.co_project.benchmark.IBenchmark;
import com.example.co_project.benchmark.CPUFixedPoint;
import com.example.co_project.logging.ConsoleLogger;
import com.example.co_project.logging.ILogger;
import com.example.co_project.logging.TimeUnit;
import com.example.co_project.timing.ITimer;
import com.example.co_project.timing.Timer;

public class TestCPUFixedVsFloatingPoint {
	private static int option = 2;
	private static int workload = 100;
	public static double time;
	public static double MOPS;


	public TestCPUFixedVsFloatingPoint() {}


	public static void setOption(int op) {
		option = op;
		System.out.println(option);
	}
	public static void setWorkload(int work) {
		workload = work;
		System.out.println(workload);
	}
	public int getOption() {
		return option;
	}
	public int getWorkload() {
		return workload;
	}



	public static void main(String[] args) {
		//System.out.println(workload + option);
		ITimer timer = (ITimer) new Timer();
		ILogger log =  new ConsoleLogger();
		TimeUnit timeUnit = TimeUnit.Nano;

//		IBenchmark bench= new CPUFixedPoint();
//		bench.initialize(workload);		//get workload
//		bench.warmUp();
//
//
//		double time1 = timer.start();
//		bench.run(option);	// get option 0 1 2
//		bench.getResult();
//		double time2 = timer.stop();
//		time = time2 - time1;
//		log.writeTime("Finished in", (long) time, timeUnit);
//		log.write("Result is", bench.getResult());
//
//		int OP = ((CPUFixedPoint) bench).getOP();
//		MOPS = (OP * workload * 1000.0 ) / time  ;
//		//System.out.println("workload " + workload + " option " +option+ " Mops "+ MOPS + " time " + time);
//
//		log.write("MOPS: ",MOPS);
//
//		//bench.clean();
//		log.close();
    }

	public static double getTime() {
		System.out.println(time);
		return time;
	}
	public static double getMOPS() { System.out.println(MOPS); return MOPS;}

}
