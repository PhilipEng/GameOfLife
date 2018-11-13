package gameoflife.player;

public class Statistics {
	private boolean isWorking;
	private boolean isEducated;
	private boolean isMarried;
	private int numChildren;
	private boolean isRetired;
	
	public Statistics() {
		this.isWorking = false;
		this.isEducated = false;
		this.isMarried = false;
		this.numChildren = 0;
		this.isRetired = false;
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
		if(this.checkMarriage()) {
			this.numChildren += numberBabies;
			if( this.numChildren > 4) this.numChildren = 4;
		}
	}
	
	public void Retire() {
		this.isRetired = true;
	}
	
	public boolean checkJobStatus() {
		return this.isWorking;
	}
	
	public boolean checkEducation() {
		return this.isEducated;
	}
	
	public boolean checkMarriage() {
		return this.isMarried;
	}
	
	public int getNumChildren() {
		return this.numChildren;
	}
	
	public boolean checkRetirementStatus() {
		return this.isRetired;
	}
	
}