package runner;

//import org.junit.runner.RunWith;
	import org.testng.annotations.DataProvider;
	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	//import io.cucumber.junit.Cucumber;
		
	//@RunWith(Cucumber.class) //Junit execution

	
	@CucumberOptions(
		plugin = {"pretty", "html:target/dsalgo.html"}, //reporting purpose
		monochrome=false,  //console output color
		tags = "@tag", //tags from feature file
		features = {"src/test/resources/feature"}, //location of feature files
		glue= "stepdefinition") //location of step definition files
  
public class Runner extends AbstractTestNGCucumberTests{
	
	@Override 
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }
}
