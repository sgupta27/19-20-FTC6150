package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Jeremy on 11/17/2017.
 */
@Disabled
@TeleOp(name = "CompTeleDev", group = "Tele")

public class CompTeleDev extends OpMode
{
    boolean isWingUp = true;
    boolean liftArmed = true;
    NewRobotFinal newRobot;

    public void init()
    {

        gamepad2.setJoystickDeadzone(.2f);//attachments
        gamepad1.setJoystickDeadzone(.2f);//driver
        newRobot = new NewRobotFinal(hardwareMap);
        newRobot.openOrCloseDoor(false);
    }

    public void start()
    {
        // newRobot.initEndGame(hardwareMap);
    }

    public void loop()
    {

        /**
         * ATTACHMENTS CONTROLLER FIRST
         * GAMEPAD 2
         */
        /*
        if (gamepad2.dpad_up)
        {
            if (liftArmed)
            {
                telemetry.addData("In calclift 1", null);
                newRobot.CalcLiftTarget(1);
                liftArmed = false;
            }
        }
        else if (gamepad2.dpad_down)
        {
            if (liftArmed)
            {   telemetry.addData("In calclift -1", null);
                newRobot.CalcLiftTarget(-1);
                liftArmed = false;
            }
        }
        else
        {
            telemetry.addData("Armedlift true", null);
            liftArmed = true;
        }


        telemetry.update();

*/
        newRobot.fineMoveLift(gamepad2.left_stick_y, 1);

        if (gamepad2.left_bumper)
            newRobot.fineAdjDoors(-.16f);
        else if (gamepad2.left_trigger > .2f)
            newRobot.fineAdjDoors(.16f);

        if (gamepad2.right_bumper)
            newRobot.getTailRelease().setPower(-1);//release
        else if (gamepad2.right_trigger > .2f)
            newRobot.getTailRelease().setPower(1);//retract
        else
            newRobot.getTailRelease().setPower(0f);

        if (gamepad2.a)
            newRobot.fineAdjGrabber(.04f);
        else if (gamepad2.b)
            newRobot.fineAdjGrabber(-.04f);

        if (gamepad2.y)
        {
            newRobot.fineAdjGrabberRotator(.008f);
        }
        else if (gamepad2.x)
        {
            newRobot.fineAdjGrabberRotator(-.008f);
        }

        /**
         *DRIVE CONTROLS
         * GAMEPAD 1
         */
        if (gamepad1.right_trigger > .4f)
            newRobot.driveMotors(gamepad1.left_stick_y / 2, gamepad1.right_stick_y / 2);
        else
            newRobot.driveMotors(gamepad1.left_stick_y, gamepad1.right_stick_y);

        telemetry.addData("LEFT POW= ", newRobot.getDriveLeftOne().getPower());
        telemetry.addData("RIGHt POW= ", newRobot.getDriveRightOne().getPower());

        if (gamepad1.y)
            newRobot.getWingMotor().setPower(1);//lift wing
        else if (gamepad1.b)
            newRobot.getWingMotor().setPower(-1f);
        else
            newRobot.getWingMotor().setPower(0f);

        telemetry.addData("LiftEnc", newRobot.getLiftMotor().getCurrentPosition());
        telemetry.addData("RightDriveEnc ", newRobot.getDriveRightOne().getCurrentPosition());
        telemetry.addData("LeftDriveEnc", newRobot.getDriveLeftOne().getCurrentPosition());
        telemetry.addData("Left Y", gamepad1.left_stick_y);
        telemetry.addData("Right y", gamepad1.right_stick_y);
        telemetry.update();
    }

    public void stop()
    {
        newRobot.stopAllMotors();
    }

}
