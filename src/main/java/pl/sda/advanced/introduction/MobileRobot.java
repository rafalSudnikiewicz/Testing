package pl.sda.advanced.introduction;

public class MobileRobot {
    public void move(double leftMotor, double rightMotor) {
        String message = String.format("Left motor is rotating at %f RPM\t Right motor is rotating at %f RPM", leftMotor, rightMotor);
        System.out.println(message);
    }
}
