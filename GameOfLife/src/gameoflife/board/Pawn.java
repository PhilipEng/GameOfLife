package gameoflife.board;


public class Pawn {
	public PawnColour colour;
	public Point coordinates;
	public boolean isMarried;
	public int numberChildren;
	
	public Pawn(PawnColour colour) {
		this.colour = colour;
		this.coordinates = new Point(0, 0);
		this.isMarried = false;
		this.numberChildren = 0;
	}
	
	public void updatePawn(boolean isMarried, int numChildren) {
		this.isMarried = isMarried;
		this.numberChildren = numChildren;
	}
	
	public void setCoordinates(int x, int y) {
		coordinates.setCoordinates(x, y);
	}
	
	//TODO: setPosition() method
	
	
}
