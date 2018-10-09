package gameoflife.board;


public class Pawn {
	public PawnColour colour;
	//TODO: x y positions need to be put into a 2 part vector
	public int xPos;
	public int yPos;
	public PawnType type;
	
	public Pawn(PawnColour colour, int xPos, int yPos) {
		this.colour = colour;
		this.xPos = xPos;
		this.yPos = yPos;
		this.type = PawnType.SINGLE;
	}
	
	public void setPawnTypeMarried() {
		this.type = PawnType.MARRIED;
	}
	
	public void setPawnTypeChildren(int numberChildren) {
		if(numberChildren == 1)  this.type = PawnType.ONECHILD;
		else if(numberChildren == 2) this.type = PawnType.TWOCHILD;
		else if(numberChildren == 3) this.type = PawnType.THREECHILD;
	}
	
	//TODO: setPosition() method
	
	
}
