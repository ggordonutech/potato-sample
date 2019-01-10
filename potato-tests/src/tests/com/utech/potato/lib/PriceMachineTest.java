package tests.com.utech.potato.lib;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.utech.potato.lib.IPriceMachine;

public class PriceMachineTest {
	
	private IPriceMachine machine;
	
	private static Injector injector;
	
	@BeforeAll
	public static void beforeAll() {
		injector = Guice.createInjector(new IOCContainer());
	}
	
	@BeforeEach
	public void beforeEach() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//machine = (IPriceMachine)Class.forName("com.utech.potato.lib.PriceMachine").newInstance();
		machine = injector.getInstance(IPriceMachine.class);
		
	}
	
	
	@Test
	public void shouldCalculateWightInPounds() 
			throws ClassNotFoundException, 
			InstantiationException, 
			IllegalAccessException {
		
		
		assertNotNull(machine);
		assertEquals(3*IPriceMachine.PRICE_PER_POUND,machine.getPriceOfPotato(3));
		
	}

}
