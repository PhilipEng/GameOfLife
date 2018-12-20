package gameoflife.cards;

public class HouseCard extends Card {
	final private String houseType;
	final private int purchasePrice;
	final private int salePriceRed;
	final private int salePriceBlack;

	/**
	 * HouseCard Constructor
	 * 
	 * @param houseType Name of the House
	 * @param purchasePrice Cost of purchasing the house
	 * @param salePriceRed Sale Price given red number is spun
	 * @param salePriceBlack Sale Price given black number is spun
	 */
	public HouseCard(String houseType, int purchasePrice, int salePriceRed, int salePriceBlack) {
		this.houseType = houseType;
		this.purchasePrice = purchasePrice;
		this.salePriceRed = salePriceRed;
		this.salePriceBlack = salePriceBlack;
	}

	/**
	 * Method prints details of the career card to the screen
	 */
	public void printDetails() {
		System.out.println("---------------------------");
		System.out.println("  House Card Details  ");
		System.out.println("---------------------------");
		System.out.println(this.houseType);
		System.out.println("Purchase Price: €" + this.purchasePrice);
		System.out.println("  Spin for Sale Price: ");
		System.out.println("Spin Red:       €" + this.salePriceRed);
		System.out.println("Spin Black:     €" + this.salePriceBlack);
		System.out.println();
	}

	/**
	 * getSalePrice() spins spinner to determine sale price of house
	 * 
	 * @param spinner_val Value of the spinner spin() method
	 * @return Returns sale price int
	 */
	public int getSalePrice(int spinner_val) {
		if ((spinner_val % 2) == 0) {
			return salePriceBlack;
		} else {
			return salePriceRed;
		}
	}

	/**
	 * Gets houseType
	 * @return Returns houseType, the name of the house
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * Gets purchase price
	 * @return Returns purchase price
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * Gets salePriceRed
	 * @return Returns red Sale Price of house
	 */
	public int getSalePriceRed() {
		return salePriceRed;
	}

	/**
	 * Gets salePriceBlack
	 * @return Return black Sale Price of House
	 */
	public int getSalePriceBlack() {
		return salePriceBlack;
	}

}
