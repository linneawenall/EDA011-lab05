import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class OneTurtle1000steps {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawRandomFigure");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle (w, 350, 350);
		Random rand = new Random ();
		double x1 = 250;
		double y1 = 250;
		double x2 = 350;
		double y2 = 350;
		t1.penDown();
		t2.penDown();
		double distance = (int) Math.hypot((x1 - x2), (y1 - y2));
		while (distance >=50){
			t1.forward(rand.nextInt(10)+1);
			t1.left(rand.nextInt(360)+1);
			t2.forward(rand.nextInt(10)+1);
			t2.left(rand.nextInt(360)+1);
			SimpleWindow.delay(10);
			distance = (int) Math.hypot((t1.getX()- t2.getX() ), (t1.getY () - t2.getY()));
		}
	}

}
