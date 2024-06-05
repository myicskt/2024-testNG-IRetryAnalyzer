package testng.util;
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
	
	
}
