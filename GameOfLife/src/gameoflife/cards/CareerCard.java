package gameoflife.cards;

/* 
 * Class for career cards. Used for regular career cards and college
 * career cards.
 */

public class CareerCard extends Card {
	final private String career;	// Career name
	final private int salary;		// Salary amount
	final private int bonusNumber;	// Bonus number
	
	/**
	 * Career Card Constructor
	 * 
	 * Variables of each career are decided at initialization and cannot be changed after
	 * @param career String career, name of career
	 * @param salary Salary of career
	 * @param bonusNumber Bonus Number for spinner bonuses
	 */
	public CareerCard(String career, int salary, int bonusNumber) {
		this.career = career;
		this.salary = salary;
		this.bonusNumber = bonusNumber;
	}
	
	/**
	 * Method prints details of the career card to the screen
	 */
	public void printDetails() {
		System.out.println("---------------------------");
		System.out.println("  Career Card Details  ");
		System.out.println("---------------------------");
		System.out.println("Career:       " + this.career);
		System.out.println("Salary:       €" + this.salary);
		System.out.println("Bonus Number: " + this.bonusNumber);
		System.out.println();
	}
	
	
	/**
	 * Gets career of Career Card
	 * @return Returns Career Card
	 */
	public String getCareer() {
		return career;
	}

	/**
	 * Gets salary of Career Card
	 * @return Returns salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * Gets bonus number
	 * @return Returns bonus number for spinner bonuses
	 */
	public int getBonusNumber() {
		return bonusNumber;
	}
}
