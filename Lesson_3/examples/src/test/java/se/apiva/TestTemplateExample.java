package se.apiva;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestInvocationProvider.class)
public class TestTemplateExample {

    @TestTemplate
    public void testAdd(Calculator calculator){
        var result = calculator.add(1, 2);

        assertEquals(3, result);
    }

}
