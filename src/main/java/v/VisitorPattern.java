package v;



/**
 * Suppose there was a CAD diagram consisting of a lot of elements. Then a requirement came to save the file in .txt format.
 * We can write a save() method in every element to serialize to .txt format. Now flexibility is required to save the diagram as 
 * .drg. Now we will need to create saveDrg() in every element. A better design pattern would be to create SaveTxt class and SaveDrg 
 * class for each concern.
 *  
 * Similarly a car has few parts body, wheel, engine and define methods which does a common action across all  car elements.
 * CarElementPrintAction and CarElementDoVisitorAction 
 * 
 * @author 971174
 *
 */

interface Visitable{
	void accept(ActionVisitor v);
}

interface ActionVisitor{
	void visit(Car c);
	void visit(Body b);
	void visit(Wheel w);
	void visit(Engine e);
}

class Car implements Visitable{
	
	public void accept(ActionVisitor c){
		c.visit(this);
		Visitable[] vlist= new Visitable[]{new Body(), new Wheel(), new Engine()};
		for (Visitable v : vlist) {
			v.accept(c);
		}
	}
}

class Body implements Visitable{
	public void accept(ActionVisitor c){
		c.visit(this);
	}
}
class Wheel implements Visitable{
	public void accept(ActionVisitor c){
		c.visit(this);
	}
}
class Engine implements Visitable{
	public void accept(ActionVisitor c){
		c.visit(this);
	}
}

class PrintCarAction implements ActionVisitor{

	public void visit(Car c) {
		 System.out.println("PrintCarAction.visit(car)"+c);
	}

	public void visit(Body b) {
		  System.out.println("PrintCarAction.visit(body)"+b);
	}

	public void visit(Wheel w) {
		System.out.println("PrintCarAction.visit(wheel)"+w);
	}

	public void visit(Engine e) {
		System.out.println("PrintCarAction.visit(engine) "+e);
	}
	
}
class CarElementDoVisitorAction implements ActionVisitor {
    public void visit(Wheel wheel) {      
        System.out.println("CarElementDoVisitorAction.Visiting " +" wheel");
    }
 
    public void visit(Engine engine) {
        System.out.println("CarElementDoVisitorAction.Visiting engine");
    }
 
    public void visit(Body body) {
        System.out.println("CarElementDoVisitorAction.Visiting body");
    }
 
    public void visit(Car car) {      
        System.out.println("CarElementDoVisitorAction.Visiting car");
    }
}
public class VisitorPattern {
	public static void main(String[] args) {
		PrintCarAction pca = new PrintCarAction();
		CarElementDoVisitorAction cepa = new CarElementDoVisitorAction();
		Car c = new Car();
		System.out.println("First action on car");
		c.accept(pca);
		System.out.println("Now another set of actions on Car by visiting each car element");
		c.accept(cepa);
	}

}
