package c;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * behavioral design pattern in which an object is used to represent and encapsulate all the information needed to call a method 
 * at a later time. This information includes the method name, the object that owns the method and values for the method parameters
 * 
 * Client - source invoker
 * Command object which contains execute method or handler method
 * command manager is optional to maintain undo/redo states
 * @author 971174
 *
 */

class CommandSwitchOff{
	ReceiverLight light;
	public CommandSwitchOff(ReceiverLight light) {
		this.light = light;
	}

	//method name - turnOff, the object that owns the method "ReceiverLight" and values for the method parameters 'light'
	public void execute(){
		System.out.println("Command.execute() turnOff() ");
		light.turnOff();
	}
}

class ReceiverLight  {
	public void turnOff(){
		System.out.println("turn off ReceiverLight");
	}
} 
public class Cmd extends HttpServlet
{
	
	 

public void doGet(HttpServletRequest req, HttpServletResponse res){
	PrintWriter prn = null;
	try {
		prn = (PrintWriter)res.getWriter();
		  prn.println("hello");
		  
		  prn.flush();
		  prn.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

  
}

public static void main(String a[]){
	ReceiverLight light = new ReceiverLight();
	CommandSwitchOff cmd = new CommandSwitchOff(light);
    cmd.execute();
}


}