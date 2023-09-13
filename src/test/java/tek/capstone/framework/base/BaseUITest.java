package tek.capstone.framework.base;

import io.cucumber.java.After;  
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.capstone.framework.utilities.CommonUtility;

	public class BaseUITest extends CommonUtility{
		@Before
		public void setupTests() {
			super.SetupBrowser();
		}
		
		@After
		public void closeTests(Scenario scenario) {
			if(scenario.isFailed()) {
				byte[] screenshot = takeScreenShotAsBytes();
				scenario.attach(screenshot, "image/png", scenario.getName()+" scenario failed");
			}
			super.quitBrowser();
		}
		
		
		
		

	}