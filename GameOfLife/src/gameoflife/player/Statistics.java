package gameoflife.player;

public class Statistics {
	private boolean isWorking;
	private boolean isEducated;
	private boolean isMarried;
	private int numChildren;
	private boolean isRetired;
	private int retirementPos;
	
	
	public Statistics() {
		this.isWorking = false;
		this.isEducated = false;
		this.isMarried = false;
		this.numChildren = 0;
		this.isRetired = false;
		this.retirementPos = 0;
	}
	
	public void gotJob() {
		this.isWorking = true;
	}
	
	public void educate() {
		this.isEducated = true;
	}
	
	public void getMarried() {
		this.isMarried = true;
	}
	
	public void addChildren(int numberBabies) {
		if(this.isMarried()) {
			this.numChildren += numberBabies;
			if( this.numChildren > 4) this.numChildren = 4;
		}
	}
	
	public void Retire() {
		this.isRetired = true;
	}
	
	public boolean isWorking() {
		return this.isWorking;
	}
	
	public boolean isEducated() {
		return this.isEducated;
	}
	
	public boolean isMarried() {
		return this.isMarried;
	}
	
	public int getNumChildren() {
		return this.numChildren;
	}
	
	public boolean isRetired() {
		return this.isRetired;
	}

	public int getRetirementPos() {
		return retirementPos;
	}

	public void setRetirementPos(int retirementPos) {
		this.retirementPos = retirementPos;
	}
	
}
