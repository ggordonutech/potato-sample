package tests.com.utech.potato.lib;

import com.google.inject.AbstractModule;
import com.utech.potato.lib.IPriceMachine;

public class IOCContainer extends AbstractModule {

	private class MockPriceMachine implements IPriceMachine {

		private int constant = 1;
		public MockPriceMachine(int constant) {
			this.constant = constant;
		}
		@Override
		public float getPriceOfPotato(float weight) {
			// TODO Auto-generated method stub
			return weight * IPriceMachine.PRICE_PER_POUND * constant;
		}
		
	}
	@Override
	protected void configure() {
		bind(IPriceMachine.class).toInstance(new MockPriceMachine(3));
		
	}

}
