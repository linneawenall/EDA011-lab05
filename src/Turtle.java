import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private double x = 0; // Sköldpaddans x-position
	private double y = 0; // Sköldpaddans y-position
	private boolean isPenDown; //om sköldpaddan ritar
	private SimpleWindow w; //fönstret den ska rita i
	private double rad;
	
	

	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;
		turnNorth();
		penUp();
	}

	/** Sänker pennan. */
	public void penDown() {
		this.isPenDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		this.isPenDown = false;
		
	
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo ((int) Math.round(x), (int) Math.round (y));
		x = x + n * Math.cos(rad);
		y = y - n * Math.sin(rad);
		if (this.isPenDown == true){
			w.lineTo ((int) Math.round(x), (int) Math.round (y));
		}
		//if (this.isPenDown == false) {
			//w.moveTo ((int) Math.round(x), (int) Math.round (y));
		//}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		double betaRad = Math.toRadians(beta);
		this.rad = betaRad + rad;
		
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		this.rad = (Math.PI)/2;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return ((int) Math.round (x));
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return ((int) Math.round (y));
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return ((int) Math.toDegrees(rad));
	}
}
