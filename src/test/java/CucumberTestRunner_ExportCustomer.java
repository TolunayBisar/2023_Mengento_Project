import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features ="classpath:features/export_customers.feature",

        plugin = {

                "pretty",
                "html:target/cucumber-report.html"
        },
        tags = "@customerModule"
)

public class CucumberTestRunner_ExportCustomer {
}
