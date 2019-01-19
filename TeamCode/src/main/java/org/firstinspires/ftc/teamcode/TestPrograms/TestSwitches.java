package org.firstinspires.ftc.teamcode.TestPrograms;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.CompRobot;
import org.firstinspires.ftc.teamcode.VuforiaFunctions;

@TeleOp(name = "TestSwitches")
public class TestSwitches extends LinearOpMode
{
    CompRobot compRobot;

    public void runOpMode()
    {
        compRobot = new CompRobot(hardwareMap, this);
        boolean switchSample = compRobot.getSwitchSample().getState();
        boolean switchDelay = compRobot.getSwitchDelay().getState();
        boolean switchDepot = compRobot.getSwitchDepot().getState();
        //boolean switchCrater = compRobot.getSwitchCrater().getState();
        boolean switchDummy = compRobot.getSwitchDummy().getState();

        telemetry.addData("sample switch",switchSample);
        telemetry.addData("delay switch",switchDelay);
        telemetry.addData("depot switch",switchDepot);
        telemetry.addData("dummy switch",switchDummy);
        telemetry.update();
        sleep(10000);
    }
}