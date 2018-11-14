package gameoflife.board.objects;


public class Pawn {
	private PawnColour colour;
	private int spaceNum;
	private Coordinate position;
	private boolean isMarried;
	private int numberChildren;
	
	public Pawn(PawnColour colour) {
		this.colour = colour;
		this.position = new Coordinate(0, 0);
		this.isMarried = false;
		this.numberChildren = 0;
	}
	
	public void setSpaceNum(int spaceNumber) {
		this.spaceNum = spaceNumber;
	}
	
	public void iterateSpaceNum() {
		this.spaceNum++;
	}
	
	public void setPosition(int x, int y) {
		position.setCoordinates(x, y);
	}
	
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

	public Coordinate getPosition() {
		return position;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public int getNumberChildren() {
		return numberChildren;
	}
	
}
