package com.warfield.powermockitoExamples;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.warfield.powermockitoExamples.*")
public class MainTest {

    private Main mainMock;
    private Main main;

    @Before
    public void setUp(){
        System.out.println("setup done");
        mainMock = PowerMockito.mock(Main.class);
        main = new Main();

    }

    @Test
    public void testprivateVoidMethod(){
        try {
            PowerMockito.doNothing().when(mainMock,"privateVoidMethod",Mockito.anyString());
            mainMock.publicVoidMethod("from test");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("testprivateVoidMethod completed");
    }

    @Test
    public void testprivateMethod(){

        try {
            PowerMockito.when(mainMock,"privateMethod",Mockito.anyString()).thenReturn("mocked output");
            String publicMethodOutput = mainMock.publicMethod("from test");
            System.out.println(publicMethodOutput);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("testprivateMethod completed");
    }
}
