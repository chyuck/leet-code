package solutions;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeImportanceTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new EmployeeImportance();

        var employees = Arrays.asList(
            new EmployeeImportance.Employee(1, 5, Arrays.asList(2, 3)),
            new EmployeeImportance.Employee(2, 3, Collections.emptyList()),
            new EmployeeImportance.Employee(3, 3, Collections.emptyList()));

        // act
        var result = solution.getImportance(employees, 1);

        // assert
        Assert.assertEquals(11, result);
    }
}
