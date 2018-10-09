package gameoflife.cards;

public class HouseCard extends Card {
	final private String house_type;
	final private int purchase_price;
	final private int sale_price_red;
	final private int sale_price_black;

	public HouseCard(String house_type, int purchase_price, int sale_price_red, int sale_price_black) {
		this.house_type = house_type;
		this.purchase_price = purchase_price;
		this.sale_price_red = sale_price_red;
		this.sale_price_black = sale_price_black;
	}

	// Method prints details of the career card to the screen
	public void printDetails() {
		System.out.println();
		System.out.println(this.house_type);
		System.out.println("Purchase Price:    " + this.purchase_price);
		System.out.println("Spin for Sale Price");
		System.out.println("Spin Red:       " + this.sale_price_red);
		System.out.println("Spin Black:     " + this.sale_price_black);
	}

	public int getSale_price(int spinner_val) {
		if ((spinner_val % 2) == 0) {
			return sale_price_black;
		} else {
			return sale_price_red;
		}
	}

	public String getHouse_type() {
		return house_type;
	}

	public int getPurchase_price() {
		return purchase_price;
	}

	public int getSale_price_red() {
		return sale_price_red;
	}

	public int getSale_price_black() {
		return sale_price_black;
	}

}
