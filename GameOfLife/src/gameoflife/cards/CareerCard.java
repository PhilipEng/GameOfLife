package gameoflife.cards;

/* 
 * Class for career cards. Used for regular career cards and college
 * career cards.
 */

public class CareerCard extends Card {
	final private String career;	// Career name
	final private int salary;		// Salary amount
	final private int bonusNumber;	// Bonus number
	
	// Variables of each career are decided at initialization and cannot be changed after
	public CareerCard(String career, int salary, int bonusNumber) {
		this.career = career;
		this.salary = salary;
		this.bonusNumber = bonusNumber;
	}
	
	// Method prints details of the career card to the screen
	public void printDetails() {
		System.out.println("---------------------------");
		System.out.println("  Career Card Details  ");
		System.out.println("---------------------------");
		System.out.println("Career:       " + this.career);
		System.out.println("Salary:      €" + this.salary);
		System.out.println("Bonus Number: " + this.bonusNumber);
		System.out.println();
	}
	
	// Getters
	
	public String getCareer() {
		return career;
	}

	public int getSalary() {
		return salary;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
