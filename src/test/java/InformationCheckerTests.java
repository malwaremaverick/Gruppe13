import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InformationCheckerTests {
 @Test
    public void controlAge_ageWithinAcceptableRangeIsHandledCorrectly() {
    int result = InformationChecker.controlAge(30);
    int lowerBoundResult = InformationChecker.controlAge(0);
    int upperBoundResult = InformationChecker.controlAge(120);

    Assertions.assertEquals(30, result);
    Assertions.assertEquals(0, lowerBoundResult);
    Assertions.assertEquals(120, upperBoundResult);
 }
}
