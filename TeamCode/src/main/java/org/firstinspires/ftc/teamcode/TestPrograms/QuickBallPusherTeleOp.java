package org.firstinspires.ftc.teamcode.TestPrograms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TestServoQuickBallPusherTeleOp", group = "Test")
public class QuickBallPusherTeleOp extends OpMode
{
    
    Servo servo;
    double servoPos = 0;
    @Override
    public void init()
    {
        servo = hardwareMap.servo.get("SamplingServo");
        servo.setDirection(Servo.Direction.FORWARD);
    }

    @Override
    public void loop()
    {
        if (gamepad2.right_trigger > .2f)
        {
            servoPos += .0038;
            if (servoPos > 1)
                servoPos = 1;
        }
        else if (gamepad2.right_bumper)
        {
            servoPos -= .0038;
            if (servoPos < 0)
                servoPos = 0;
        }
        servo.setPosition(servoPos);
        telemetry.addData("ServoPos :", servoPos);
        telemetry.addData("ActualPos :", servo.getPosition());
        telemetry.addData("Servo Dir", servo.getDirection());
        telemetry.update();
    }
}
