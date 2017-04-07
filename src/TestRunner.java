/**
 * Created by Nelson on 06.04.2017.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 * Initiates the parameterized tests and collect information on success/failure.
 */
final class TestRunner {
    /**
     * private constructor for TestRunner class.
     * It is private because as a helper class it should not have a public constructor.
     */
    private TestRunner() {
    }
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RendererTestParameterized.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
