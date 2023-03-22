package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import example.project.domain.Scenario;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.io.*;

public class TestADS {

    @Test
    public void testPrintPath() {
        // fail();
        // delete the above line and implement this properly to test if ads.printPath() prints the ADSPath.
        // hint: see testHelloWorld() in our previous lab session.

        ADS ads = new ADS("dummy");
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        ads.printPath();

        // assertion
        assertEquals("dummy", bos.toString().trim());

        // undo the binding in System
        System.setOut(originalOut);

    }

    @Test
    public void testPredict() {
        // ADS ads = new ADS("dummy");
        ADS ads = mock();
        Scenario scenario = new Scenario("special scenario leading to the prediction of [0, 0]");
        when(ads.predict(scenario)).thenReturn(Arrays.asList(0, 0));

        List<Object> prediction = ads.predict(scenario); // the prediction will be null since the ADS is dummy.
        assertEquals(Arrays.asList(0, 0), prediction);
        // verify if ads.predict(scenario) has been called only once
        verify(ads, times(1)).predict(scenario);
        // verify if ads.printPath() has been never called
        verify(ads, times(0)).printPath();
    }

}