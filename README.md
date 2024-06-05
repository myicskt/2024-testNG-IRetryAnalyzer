1. IRetryAnalyzer using: @Test(retryAnalyzer=Retry.class)
step 1: implements IRetryAnalyzer
*****************************************************
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Retry implements IRetryAnalyzer {
private int retrycount =0;
private final int maxcount=5;
public boolean retry(ITestResult result) {
		if(retrycount<maxcount) {
			retrycount++;
			return true;
		}
		return false;
	}

}
SETP 2: Add on specific test paramiter 
***************************************
  @Test(retryAnalyzer=Retry.class)
	public void test3() {
	Assert.assertTrue(false, "test case 3 is failed");	
	}
******************************************************************
2. IRetryAnalyzer using: IAnnotationTransformer
*******************************************************************
step 1: implements IRetryAnalyzer
        same as above ...
step 2: implements IAnotationTransformer
*****************************************
  import java.lang.reflect.Constructor;
  import java.lang.reflect.Method;
  import org.testng.IAnnotationTransformer;
  import org.testng.annotations.ITestAnnotation;
  public class AnnotationTransformer implements IAnnotationTransformer {

  public void transform(
    		ITestAnnotation annotation,
    		Class testClass,
    		Constructor testConstructor,
    		Method testMethod){
		//set the annotation class (The class where IRetryAnalyzer)
		annotation.setRetryAnalyzer(Retry.class);
    }

  step 3: add the listener tag in suite 
  **************************************
   <suite name="Suite">
  	  <listeners>
  		  <listener class-name="testng.util.AnnotationTransformer" />
  	  </listeners>
  	<test thread-count="5" name="Test">
  		<classes>
  			<class name="testng.util.BrowserFactory" />
  		</classes>
  	</test> <!-- Test -->
  </suite> 
	
	
}
