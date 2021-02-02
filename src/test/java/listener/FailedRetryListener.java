package listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 
 * Re-execute test up to 3 times when test fails
 * @author cloverli
 * @date 03/02/2021
 *
 */
public class FailedRetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        {
            IRetryAnalyzer retry = annotation.getRetryAnalyzer();
            if (retry == null) {
                annotation.setRetryAnalyzer(FailedRetryRunner.class);
            }
        }
    }
}
