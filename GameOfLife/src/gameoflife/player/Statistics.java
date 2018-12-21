package gameoflife.player;

public class Statistics {
	private boolean isWorking;
	private boolean isEducated;
	private boolean isMarried;
	private int numChildren;
	private boolean isRetired;
	private int retirementPos;
	
	
	/**
	 * Statistics Constructor
	 */
	public Statistics() {
		this.isWorking = false;
		this.isEducated = false;
		this.isMarried = false;
		this.numChildren = 0;
		this.isRetired = false;
		this.retirementPos = 0;
	}
	
	/**
	 * Sets working status to true
	 */
	public void gotJob() {
		this.isWorking = true;
	}
	
	/**
	 * Sets Education to true
	 */
	public void educate() {
		this.isEducated = true;
	}
	
	/**
	 * Sets Maritial status to true
	 */
	public void getMarried() {
		this.isMarried = true;
	}
	
	/**
	 * Increases number of children owned by the player. Limits number of children to 5.
	 * @param numberBabies number of Babies to add to the children of player
	 */
	public void addChildren(int numberBabies) {
		if(this.isMarried()) {
			this.numChildren += numberBabies;
			if( this.numChildren > 5) this.numChildren = 5;
		}
	}
	
	/**
	 * Sets retirement status to true
	 */
	public void Retire() {
		this.isRetired = true;
	}
	
	/**
	 * Working Status getter
	 * @return Returns Working status
	 */
	public boolean isWorking() {
		return this.isWorking;
	}
	
	/**
	 * Education Status Getter
	 * @return Returns Education Status 
	 */
	public boolean isEducated() {
		return this.isEducated;
	}
	
	/**
	 * Maritial status Getter
	 * @return Returns Marital status
	 */
	public boolean isMarried() {
		return this.isMarried;
	}
	
	/**
	 * Number of Children Getter
	 * @return Returns number of Children
	 */
	public int getNumChildren() {
		return this.numChildren;
	}
	
	/**
	 * Retirement status getter
	 * @return Returns Retirement Status
	 */
	public boolean isRetired() {
		return this.isRetired;
	}

	/**
	 * Gets Retirement Position
	 * @return Returns Retirements Status
	 */
	public int getRetirementPos() {
		return retirementPos;
	}

	/**
	 * Sets retirement Position
	 * @param retirementPos Position player retired
	 */
	public void setRetirementPos(int retirementPos) {
		this.retirementPos = retirementPos;
	}
	
}
