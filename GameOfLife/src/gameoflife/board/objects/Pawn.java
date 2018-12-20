package gameoflife.board.objects;


public class Pawn {
	private PawnColour colour;
	private int spaceNum;
	private boolean isMarried;
	private int numberChildren;
	
	/**
	 * Pawn constructor.
	 * 
	 * 
	 * @param colour Colour selected for this pawn, of type PawnColour.
	 */
	public Pawn(PawnColour colour) {
		this.colour = colour;
		this.isMarried = false;
		this.numberChildren = 0;
	}
	
	/**
	 * Sets the spaceNumber of the Pawn
	 * @param spaceNumber Number index of space
	 */
	public void setSpaceNum(int spaceNumber) {
		this.spaceNum = spaceNumber;
	}
	
	/**
	 * Iterates the spaceNum by 1.
	 */
	public void iterateSpaceNum() {
		this.spaceNum++;
	}
	
	/** 
	 * Updates the maritial and child status of a Pawn
	 * @param isMarried Married Bool
	 * @param numChildren Number of Children player has
	 */
	public void updatePawn(boolean isMarried, int numChildren) {
		this.isMarried = isMarried;
		this.numberChildren = numChildren;
	}

	/**
	 * Gets the colour of a Pawn
	 * @return Returns colour of Pawn
	 */
	public PawnColour getColour() {
		return colour;
	}

	/**
	 * Gets space number of Pawn
	 * @return Returns Space Number
	 */
	public int getSpaceNum() {
		return spaceNum;
	}


	/**
	 * Gets maritial status of pawn
	 * @return Returns Boolean maritial status
	 */
	public boolean isMarried() {
		return isMarried;
	}

	/**
	 * Gets number of Children Pawn has
	 * @return Returns Number of Children
	 */
	public int getNumberChildren() {
		return numberChildren;
	}
	
}
