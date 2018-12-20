package gameoflife.board.spaces;

public class Space {
	
	private SpaceType type;
	private int spaceNum;
	private boolean branch;		// Only true for SpaceType.STOP_SCHOOL and SpaceType.STOP_FAMILY
	private boolean merge;		// True if space merges after branch path
	private int nextSpaceNum;  	// Always 0 if branch and merge are false
	private int xpos;
	private int ypos;
	
	/**
	 * Space Constructor
	 * @param spaceNum Number of Space, defined by CSV file
	 * @param spaceType Space Type, defined by CSV file
	 * @param spaceBranch Space Branch value, defined by CSV file
	 * @param xpos xpos relative to elements in CSV file
	 * @param ypos ypos relative to elements in CSV file
	 */
	public Space(int spaceNum, int spaceType, int spaceBranch, int xpos, int ypos) {
		
		this.type = getSpaceType(spaceType);
		this.spaceNum = spaceNum;
		this.branch = checkBranch(this.type, spaceBranch);
		this.merge = checkMerge(this.branch, spaceBranch);
		this.nextSpaceNum = spaceBranch;
		this.xpos = xpos;
		this.ypos = ypos;
	}

	/**
	 * Returns SpacetType corresponding to int index of spaceType
	 * @param spaceType int index of spaceType, as seen in CSV file elements
	 * @return Returns SpaceType object
	 */
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
		return type;
	}
	
	/**
	 * Checks if the SpaceType has a branch value
	 * @param type SpaceType object
	 * @param spaceBranch Branch value
	 * @return Boolean, true if it is a branch space
	 */
	private boolean checkBranch(SpaceType type, int spaceBranch) {
		if(((type == SpaceType.STOP_SCHOOL) || (type == SpaceType.STOP_FAMILY)) && (spaceBranch != 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if the space is a merge space
	 * 
	 * If space is branch it cannot be merge.
	 * @param branch Boolean for branch
	 * @param spaceBranch int SpaceBranch, as seen in CSV file
	 * @return returns boolean true if is merge space
	 */
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

	/**
	 * Returns SpaceType
	 * @return Returns SpaceType
	 */
	public SpaceType getType() {
		return this.type;
	}

	/**
	 * Returns SpaceNum of Space
	 * @return Returns SpaceNum of Space
	 */
	public int getSpaceNum() {
		return this.spaceNum;
	}

	/**
	 * returns branch boolean
	 * @return Returns branch boolean
	 */
	public boolean isBranch() {
		return this.branch;
	}

	/** 
	 * Returns merge boolean
	 * @return Return merge boolean
	 */
	public boolean isMerge() {
		return this.merge;
	}

	/**
	 * Returns spaceNum of next space
	 * @return Returns spaceNum of next space
	 */
	public int getNextSpaceNum() {
		return this.nextSpaceNum;
	}
	
	/**
	 * Returns xpos
	 * @return Returns xpos
	 */
	public int getxpos() {
		return this.xpos;
	}
	
	/**
	 * Returns ypos
	 * @return Returns ypos
	 */
	public int getypos() {
		return this.ypos;
	}
	
	/**
	 * Print's details of a Space.
	 * 
	 * Print Spaces type, number, and branch/merge value, and spaces position
	 */
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
