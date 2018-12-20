package gameoflife.cards;

public class HouseCard extends Card {
	final private String houseType;
	final private int purchasePrice;
	final private int salePriceRed;
	final private int salePriceBlack;

	public HouseCard(String houseType, int purchasePrice, int salePriceRed, int salePriceBlack) {
		this.houseType = houseType;
		this.purchasePrice = purchasePrice;
		this.salePriceRed = salePriceRed;
		this.salePriceBlack = salePriceBlack;
	}

	// Method prints details of the career card to the screen
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
	
	// If spinner value is even, return the Black Sale Price, else return Red
	public int getSalePrice(int spinner_val) {
		if ((spinner_val % 2) == 0) {
			return salePriceBlack;
		} else {
			return salePriceRed;
		}
	}

	public String getHouseType() {
		return houseType;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getSalePriceRed() {
		return salePriceRed;
	}

	public int getSalePriceBlack() {
		return salePriceBlack;
	}

}
