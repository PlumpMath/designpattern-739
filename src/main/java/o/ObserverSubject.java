package o;

import java.util.Observable;
import java.util.Observer;


class Model extends Observable{
	public void createChange(){
		System.out.println("Model.createChange() Model changed! so notifying observers");
		System.out.println("since change was not set it would not propagate calling notifyObservers()");
		notifyObservers();
		
		setChanged();
		System.out.println("After set changed  calling notifyObservers()");
		notifyObservers();
	}
}
class Subscriber implements Observer{
	
	public void update(Observable arg0, Object arg1) {
		System.out.println("Subscriber.update()");
	}
	
}
class Subscriber2 implements Observer{

	public void update(Observable arg0, Object arg1) {
		 System.out.println("Subscriber2.update()");
	}
	
}
public class ObserverSubject {

	public static void main(String[] args) {
		 Model m = new Model();
		 Subscriber2 s2 = new Subscriber2();
		 Subscriber s = new Subscriber();
		 m.addObserver(s);
		 m.addObserver(s2);
		 
		 
		 //fire
		 m.createChange();
	}

}
