package com.utech.potato.lib;

public interface IPriceMachine {
	float PRICE_PER_POUND = 35.0f; 
	
	float getPriceOfPotato(float weight);

}
