package SalesforceSystemTest;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
     //   features = "src/test/resources/features/ChargeBackTestSuite1"
      // features = "src/test/resources/features/ChargeBack"
         features = "src/test/resources/features"

        //     features = "src/test/resources/features/Refund"

)
 public class CucumberTestSuite {

 }



