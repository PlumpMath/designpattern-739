package s;

/** 
 * Allows algorithms to be selected at *runtime*. But once selected its fairly stable, where as in state pattern the 
 * state keeps on changing one after the another.
 * 
 * The classes that implement a concrete strategy should implement this.
 * The Context class uses this to call the concrete strategy. 
 */
interface Strategy{
	int execute(int a, int b); 
}

/** Implements the algorithm using the strategy interface */
class Add implements Strategy {
    public int execute(int a, int b) {
        System.out.println("Called Add's execute()");
        return a + b;  // Do an addition with a and b
    }
};
 
class Subtract implements Strategy {
    public int execute(int a, int b) {
        System.out.println("Called Subtract's execute()");
        return a - b;  // Do a subtraction with a and b
    }
};
class StrategyContext{
	Strategy s;
	public StrategyContext(Strategy s){
		this.s = s;
	}
	public int executeStrategy(int a, int b){
		return s.execute(a, b);
	}
}
public class StrategyTest {

	public static void main(String[] args) {
		StrategyContext stp = new StrategyContext(new Add()); 
		System.out.println(stp.executeStrategy(12, 11));
		
		stp = new StrategyContext(new Subtract());
		System.out.println(stp.executeStrategy(12, 11));
	}

}
