package steps;
import static utils.Utils.acessarApp;
import static utils.Utils.driver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks { // faz ligações entre os cenarios

	@Before
	public void setUp() throws Exception {
		acessarApp();
	}

	@After
	public void fecharApp(Scenario cenario) {
		utils.Utils.gearScreenShot(cenario);
		driver.quit();
	}

}
