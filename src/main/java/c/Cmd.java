package c;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

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
  
    
}


}