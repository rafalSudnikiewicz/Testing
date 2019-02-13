package pl.sda.advanced.introduction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GamepadControllerTest {

    @Mock
    private MobileRobot robot;

    private GamepadController controller;

    @Before
    public void setUp(){
        controller = new GamepadController(robot);
    }

    @Test
    public void controllingTest(){
        double xAxis=4.5;
        double yAxis=6.7;
         final int ANALOG_TO_RPM_RATIO = 100;
        controller.analogPositionChanged(xAxis,yAxis);

//        verify(robot,times(1)).move(xAxis*ANALOG_TO_RPM_RATIO,yAxis*ANALOG_TO_RPM_RATIO);
        verify(robot,times(1)).move(anyDouble(),anyDouble());

    }
}