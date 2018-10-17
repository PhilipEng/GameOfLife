package gameoflife.board;


public class Pawn {
	public PawnColour colour;
	//TODO: x y positions need to be put into a 2 part vector
	public int xPos;
	public int yPos;
	public boolean isMarried;
	public int numberChildren;
	
	public Pawn(PawnColour colour, int xPos, int yPos) {
		this.colour = colour;
		this.xPos = xPos;
		this.yPos = yPos;
		this.isMarried = false;
		this.numberChildren = 0;
	}
	
	public void updatePawn(boolean isMarried, int numChildren) {
		this.isMarried = isMarried;
		this.numberChildren = numChildren;
	}
	
	//TODO: setPosition() method
	
	
}
