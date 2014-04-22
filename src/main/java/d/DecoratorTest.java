package d;

class Window{
	public void draw(){
		System.out.println("Window.draw()");
	}
	public String getDescription(){
		return "Simple Window";
	}
}

abstract class WindowDecorator extends Window{
	Window w;
	public WindowDecorator(Window w){
		this.w = w;
	}
	public String getDescription(){
		return w.getDescription();
	}
}

class VerticalScrollbarWindowDecorator extends WindowDecorator{

	public VerticalScrollbarWindowDecorator(Window w) {
		super(w);
		 
	}
	public  String getDescription(){
		return super.getDescription()+", adding vertical scrollbars";
	}
}

class HorizontalScrollbarWindowDecorator extends WindowDecorator{

	public HorizontalScrollbarWindowDecorator(Window w) {
		super(w);
		 
	}
	public  String getDescription(){
		return super.getDescription()+", adding horizontal scrollbars";
	}
}

public class DecoratorTest {
	public static void main(String args[]) {
		Window w = new HorizontalScrollbarWindowDecorator(new VerticalScrollbarWindowDecorator(new Window()));
		System.out.println(w.getDescription());
		
	}
}
