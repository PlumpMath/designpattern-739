package c;

import java.util.ArrayList;

abstract class Logger{
	Logger next;
	public void setNext(Logger l){
		next= l;
	}
	public void debug(){
		 log();
		 if(next != null){
			 next.debug();
		 } 
	}
	public abstract void log();
}

class ConsoleLogger extends Logger{
	public void log() {
		System.out.println("logging Console logger");
	}
}
class FileLogger extends Logger{
	public void log() {
		System.out.println("logging File logger");
	}
}
class EmailLogger extends Logger{
	public void log() {
		System.out.println("logging Email logger");
	}
}
public class ChainOfResponsibilityTest {

	
	public static void main(String[] args) {
		Logger clog = new ConsoleLogger();
		
		Logger flog = new FileLogger();
		clog.setNext(flog);
		
		Logger elog = new EmailLogger();
		flog.setNext(elog);
		
		//using log
		clog.debug();
	}

}
