package tests.com.utech.potato.lib;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.utech.potato.lib.IPriceMachine;

public class PriceMachineTest {
	
	private IPriceMachine machine;
	
	private static Injector injector;
	
	@BeforeClass
	public static void beforeAll() {
		injector = Guice.createInjector(new IOCContainer());
	}
	
	@Before
	public void beforeEach() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//machine = (IPriceMachine)Class.forName("com.utech.potato.lib.PriceMachine").newInstance();
		machine = injector.getInstance(IPriceMachine.class);
		
	}
	
	
	@org.junit.Test
	public void shouldCalculateWightInPounds() 
			throws ClassNotFoundException, 
			InstantiationException, 
			IllegalAccessException {
		
		
		assertNotNull(machine);
		assertEquals(3*IPriceMachine.PRICE_PER_POUND,machine.getPriceOfPotato(3),0);
		
	}

}
