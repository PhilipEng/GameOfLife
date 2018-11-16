package gameoflife.board.spaces;

public class Space {
	
	private SpaceType type;
	private int spaceNum;
	private boolean branch;		// Only true for SpaceType.STOP_SCHOOL and SpaceType.STOP_FAMILY
	private boolean merge;		// True if space merges after branch path
	private int nextSpaceNum;  	// Always 0 if branch and merge are false
	private int xpos;
	private int ypos;
	
	public Space(int spaceNum, int spaceType, int spaceBranch, int xpos, int ypos) {
		
		this.type = getSpaceType(spaceType);
		this.spaceNum = spaceNum;
		this.branch = checkBranch(this.type, spaceBranch);
		this.merge = checkMerge(this.branch, spaceBranch);
		this.nextSpaceNum = spaceBranch;
		this.xpos = xpos;
		this.ypos = ypos;
	}

	private SpaceType getSpaceType(int spaceType) {
		
		SpaceType type = null;

		switch(spaceType) {
		case 1:
			type = SpaceType.START_CAREER;
			break;
		case 2:
			type = SpaceType.START_COLLEGE;
			break;
		case 3:
			type = SpaceType.PAYDAY;
			break;
		case 4:
			type = SpaceType.ACTION;
			break;
		case 5:
			type = SpaceType.HOLIDAY;
			break;
		case 6:
			type = SpaceType.SPIN_TO_WIN;
			break;
		case 7:
			type = SpaceType.BABY;
			break;
		case 8:
			type = SpaceType.TWINS;
			break;
		case 9:
			type = SpaceType.HOUSE;
			break;
		case 10:
			type = SpaceType.STOP_GRADUATE;
			break;
		case 11:
			type = SpaceType.STOP_MARRIAGE;
			break;
		case 12:
			type = SpaceType.STOP_SCHOOL;
			break;
		case 13:
			type = SpaceType.STOP_FAMILY;
			break;
		case 14:
			type = SpaceType.STOP_BABY;
			break;
		case 15:
			type = SpaceType.STOP_HOLIDAY;
			break;
		case 16:
			type = SpaceType.RETIRE;
			break;
		}
		//Need to report error if value does not match a space type
		return type;
	}
	
	private boolean checkBranch(SpaceType type, int spaceBranch) {
		if(((type == SpaceType.STOP_SCHOOL) || (type == SpaceType.STOP_FAMILY)) && (spaceBranch != 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkMerge(boolean branch, int spaceBranch) {
		if(branch) {
			return false; //The space is a branch so cannot be a merge.
		} else {
			if(spaceBranch != 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	public SpaceType getType() {
		return this.type;
	}

	public int getSpaceNum() {
		return this.spaceNum;
	}

	public boolean isBranch() {
		return this.branch;
	}

	public boolean isMerge() {
		return this.merge;
	}

	public int getNextSpaceNum() {
		return this.nextSpaceNum;
	}
	
	public void printDetails() {
		System.out.println("\nPrinting space details:");
		
		System.out.println("Space type: " +this.type);
		System.out.println("Space number: " +this.spaceNum);
		if(branch) {
			System.out.println("This is a branch space");
			System.out.println("Branch Value: " +this.nextSpaceNum);
		}
		if(merge) {
			System.out.println("This is a merge space");
			System.out.println("Merge Value: " +this.nextSpaceNum);
		}
		System.out.println("Space Position: Xpos:" +this.xpos +" Ypos: " +this.ypos);

		
		
	}

}
