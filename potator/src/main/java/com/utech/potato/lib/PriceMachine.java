package com.utech.potato.lib;

public class PriceMachine  implements IPriceMachine{
	

	public float getPriceOfPotato(float weight) {
		return weight * PRICE_PER_POUND;
	}

}
