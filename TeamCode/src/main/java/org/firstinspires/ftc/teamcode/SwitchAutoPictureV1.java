package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Sahithi Thumuluri on 12/24/18.
 */

@Autonomous(name = "SwitchAutoPictureV1")
public class SwitchAutoPictureV1 extends LinearOpMode
{
    CompRobot compRobot;
    VuforiaFunctions vuforiaFunctions;

    public void runOpMode()
    {
        compRobot = new CompRobot(hardwareMap, this);
        vuforiaFunctions = new VuforiaFunctions(this, hardwareMap);
        float yawAngle = 90;
        float frontSensorDepth = 2;
        float rightSensorDepth = 2;
        float  yawAngleTurn;
        float distanceTraveled = 0;
        char pos = '?';
        //boolean switchSample = false;
        //boolean switchDelay = false;
        boolean switchSample = compRobot.getSwitchSample().getState();
        boolean switchDelay = compRobot.getSwitchDelay().getState();
        boolean switchDepot = compRobot.getSwitchDepot().getState();
        //boolean switchCrater = compRobot.getSwitchCrater().getState();
        //boolean switchDummy = compRobot.getSwitchCrater().getState();

        waitForStart();
        //compRobot.climbDown();
        sleep(100);

        if (switchSample)
        {
            //sample
            compRobot.driveStraight(5,.8f);
            /*if (switchDepot) //gonna need to edit these values when testing
            {
                switch (pos)
                {
                    case 'l':
                    {
                        compRobot.driveStraight(-10,.8f);
                        compRobot.pivotenc(60,.5f);
                        compRobot.driveStraight(-20,.8f);
                        compRobot.pivotenc(-35,.5f);
                    }
                    case 'c':
                    {
                        compRobot.driveStraight(-25,.8f);
                    }
                    case 'r':
                    {
                        compRobot.driveStraight(-10,.8f);
                        compRobot.pivotenc(-60,.5f);
                        compRobot.driveStraight(-20,.8f);
                        compRobot.pivotenc(35,.5f);
                    }
                }
            }
            else
            {
                compRobot.driveStraight(25,.8f);
            }*/
        }

        if (switchDelay)
        {
            compRobot.pivotenc(90,.6f); //JUST to test
            //sleep(2000);
        }
        if (switchDepot)
        {
            compRobot.driveStraight(-8, .8f); //just to test switches
        }
            /*(if (!switchSample)
            {
                compRobot.driveStraight(8, .8f);
            }
                compRobot.pivotenc(85, .8f); //100 worked about 2/3 of the time

                while (true)
                {
                    double frontDist = compRobot.getFrontDistance_IN();
                    if (frontDist <= 7 + frontSensorDepth)
                        break;
                    else
                        compRobot.driveStraight(10, .5f);
                    distanceTraveled = distanceTraveled + 10 ;
                    if (distanceTraveled >= 40)
                    {
                        break;
                    }
                }
                compRobot.stopDriveMotors();
                {
                    if (vuforiaFunctions.hasSeenTarget())
                    {
                        telemetry.addData(vuforiaFunctions.getCurrentNameOfTargetSeen(), null);
                        telemetry.addData("X (in): ", vuforiaFunctions.getXPosIn());
                        telemetry.addData("Y (in): ", vuforiaFunctions.getYPosIn());
                        telemetry.addData("X (ft): ", vuforiaFunctions.getXPosIn() / 12f);
                        telemetry.addData("Y (ft): ", vuforiaFunctions.getYPosIn() / 12f);
                        telemetry.addData("YAW ", vuforiaFunctions.getYawDeg());
                        telemetry.update();
                        sleep(100);
                        yawAngle = vuforiaFunctions.getYawDeg();
                        if (yawAngle < 0)
                        {
                            yawAngle = 180 + yawAngle;
                        }
                        yawAngleTurn = 100 - yawAngle;
                        compRobot.pivotenc(yawAngleTurn, .8f);
                    }
                    else
                    {
                        telemetry.addData("Such target is not in my sight!", null);
                        compRobot.pivotenc(45, .8f);
                    }

                    telemetry.update();
                }
                compRobot.hugWallToRight(3 + rightSensorDepth, 7 + rightSensorDepth, 22, 48);
                //The hug wall code in the method is a bit different than the one that was in the original auto file
                //make sure that it still runs as intended.

                telemetry.addData("Stopped", null);
                sleep(100);
                compRobot.deployMarker();
                telemetry.update();
        } */
        //if (switchCrater)
        //{
        //    compRobot.pivotenc(-90, .6f); //testing switches
        //}
            /*if (!switchDepot)
            {
                if (!switchSample)
                {
                    compRobot.driveStraight(48, .8f);
                }
                else
                {
                    compRobot.driveStraight(40, .8f);
                }
            }
            else
            {
                compRobot.driveStraight(-44, .5f);
                compRobot.pivotenc(-230, .8f);
                compRobot.driveStraight(30,.5f);
            }*/

/*        if (switchDummy)
        {
            compRobot.pivotenc(200, .5f);
        }
        compRobot.stopDriveMotors();
        */
    }
}
