package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "SwitchAutoDepotV1")
public class SwitchAutoDepotV1 extends LinearOpMode
{
    CompRobot compRobot;
    VuforiaFunctions vuforiaFunctions;
    private float rightSensorDepth = 2;
    private float frontSensorDepth = 2;

    public void runOpMode()
    {
        compRobot = new CompRobot(hardwareMap, this);
        vuforiaFunctions = new VuforiaFunctions(this, hardwareMap);
        //boolean switchSample = compRobot.getSwitchSample().getState();
        boolean switchSample = false;
        boolean switchDepot = true;
        boolean switchCrater = true;
        /*boolean switchDepot = compRobot.getSwitchDepot().getState();
        boolean switchCrater = compRobot.getSwitchCrater().getState(); */
        waitForStart();
        compRobot.climbDown();
        sleep(100);

        if (switchSample)
        {
            compRobot.driveStraight(10, .5f); //adjust distance when integrating code
            //sample
        }
        if (switchDepot)
        {
            if (!switchSample)
            {
                compRobot.driveStraight(25, .8f); //might need to change something to make sure gets to
                                                                //same spot with and without sampling
            }
                while (compRobot.getFrontDistSens().getDistance(DistanceUnit.INCH) > 20 && compRobot.getFrontRightDistSens().getDistance(DistanceUnit.INCH) > 20)
                {
                    compRobot.driveMotors(.4f, .4f);
                }
                compRobot.stopDriveMotors();
                compRobot.deployMarker();
        }
        if (switchCrater)
        {
            if (!switchDepot)
            {
                if (!switchSample) //if statement for if we did sample
                {
                    compRobot.driveStraight(25, .8f);
                }
                else
                {
                    compRobot.driveStraight(15, .8f); //adjust after sampling is made
                }
                while (compRobot.getFrontDistSens().getDistance(DistanceUnit.INCH) > 20 && compRobot.getFrontRightDistSens().getDistance(DistanceUnit.INCH) > 20)
                {
                    compRobot.driveMotors(.4f, .4f);
                }
                compRobot.stopDriveMotors();
            }
            compRobot.driveStraight(-5, 1);
            compRobot.pivotenc(155, .5f);

            compRobot.driveStraight(16, .6f);

            compRobot.pivotenc(-20, .5f); //9 works but its far from the wall

            sleep(250);
        }
        //hugwall stil is struggling to turn back!! fix this and figure out why the 25 degree turn isn't 25 degrees
        compRobot.hugWallToRight(3 + rightSensorDepth, 7 + rightSensorDepth, 22, 48);
        compRobot.driveStraight(24, .8f);
        telemetry.addData("Stopped", null);
        telemetry.update();

        compRobot.stopDriveMotors();
    }
}
