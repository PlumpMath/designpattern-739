package m;

import java.util.ArrayList;

/**
 * Allows for the actions of each object set to vary independently of one
 * another. Colleagues should not know about each other, instead they should
 * communicate through some central point.
 * 
 * @url http://java.dzone.com/articles/design-patterns-mediator
 * @author 971174
 * 
 */
interface Mediator {
	public void send(String message, Colleague colleague);
}

// Colleage interface
abstract class Colleague {
	private Mediator mediator;

	public Colleague(Mediator m) {
		mediator = m;
	}

	// send a message via the mediator
	public void send(String message) {
		mediator.send(message, this);
	}

	// get access to the mediator
	public Mediator getMediator() {
		return mediator;
	}

	public abstract void receive(String message);

}

class AppMediator implements Mediator {
	ArrayList<Colleague> colleagues = new ArrayList<Colleague>();

	public void addMediator() {

	}

	public void addColleague(Colleague col) {
		colleagues.add(col);
	}

	@Override
	public void send(String message, Colleague colleague) {
		for (Colleague col : colleagues) {
			// don't sent to its own
			if (col != colleague) {
				col.receive(message);
			}
		}
	}

}

class ConcreteColleague extends Colleague {
	public ConcreteColleague(Mediator m) {
		super(m);
	}

	public void receive(String message) {
		System.out.println("Colleague Received: " + message);
	}

}

class MobileColleague extends Colleague {
	public MobileColleague(Mediator m) {
		super(m);
	}

	public void receive(String message) {
		System.out.println("Mobile Received: " + message);
	}

}

public class MediatorTest {
	 public static void main(String[] args) {
	      AppMediator mediator = new AppMediator(); 
	      
	     Colleague desktop = new ConcreteColleague(mediator);
	     Colleague mobile = new MobileColleague(mediator);
	     
	      mediator.addColleague(desktop);
	      mediator.addColleague(mobile);
 
	      desktop.send("Hello World");
	      mobile.send("Hello"); 
	      
	  }
}
