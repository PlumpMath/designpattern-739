package c;

import java.util.ArrayList;

import java.util.ArrayList;
/**
 * The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies. 
 * Implementing the composite pattern lets clients treat 
 * individual objects "Graphic" and compositions "CompositeGraphic" uniformly
 * @author 971174
 *
 */
interface Graphic{
	void print();
}
class CompositeGraphic implements Graphic{
	ArrayList<Graphic> glist = new ArrayList<Graphic>();
	public void print(){
		for (Graphic g: glist) {
			g.print();
		}
	}
	public void add(Graphic g){
		glist.add(g);
	}
}

class Ellipse implements Graphic{
	public void print(){
		System.out.println("Elllipse");
	}
}
public class CompositeTest {
    public static void main(String[] args) {
        //Initialize four ellipses
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();
 
        //Initialize three composite graphics
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();
 
        //Composes the graphics
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);
 
        graphic2.add(ellipse4);
 
        graphic.add(graphic1);
        graphic.add(graphic2);
 
        //Prints the complete graphic (four times the string "Ellipse").
        graphic.print();
    }
}
