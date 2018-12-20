package gameoflife.board.objects;


public class Pawn {
	private PawnColour colour;
	private int spaceNum;		// Current board space number
	
	// Possible option for future development:
	//	- Have the Pawn show the number of children and 
	//	  the marriage status of the player 
	private boolean isMarried;
	private int numberChildren;
	
	public Pawn(PawnColour colour) {
		this.colour = colour;
		this.isMarried = false;
		this.numberChildren = 0;
	}
	
	public void setSpaceNum(int spaceNumber) {
		this.spaceNum = spaceNumber;
	}
	
	public void iterateSpaceNum() {
		this.spaceNum++;
	}
	
	// Update the pawn to have the current isMarried and numChildren
	public void updatePawn(boolean isMarried, int numChildren) {
		this.isMarried = isMarried;
		this.numberChildren = numChildren;
	}

	public PawnColour getColour() {
		return colour;
	}

	public int getSpaceNum() {
		return spaceNum;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public int getNumberChildren() {
		return numberChildren;
	}
}
