package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "!FinalDepot")
public class AutonomousFinalDepot extends LinearOpMode
{
    private CompRobot compRobot;
    VuforiaFunctions vuforiaFunctions;
    private float rightSensorDepth = 2;

    public void runOpMode()
    {
        char pos = '?';
        boolean isCenterGold = false;
        boolean isRightGold = false;
        boolean seenSomething = false;
        compRobot = new CompRobot(hardwareMap, this);
        vuforiaFunctions = new VuforiaFunctions(this, hardwareMap);
        waitForStart();
        sleep(1000);

        if(vuforiaFunctions.getTfod().getRecognitions().size() == 1)
        {
            seenSomething = true;
            if(vuforiaFunctions.getTfod().getRecognitions().get(0).getLabel().equals(vuforiaFunctions.LABEL_GOLD_MINERAL))
            {
                isCenterGold = true;
                pos = 'c';
            }
            else
                isCenterGold = false;
        }
        else if(vuforiaFunctions.getTfod().getRecognitions().size() >= 2)
        {
            pos = vuforiaFunctions.getPositionOfGoldInTwoObjects();
        }

        compRobot.climbDown();
        compRobot.pivotenc(5, .5f);

        if (pos == '?')
        {
            if(vuforiaFunctions.getTfod().getRecognitions() != null)
                seenSomething = true;
                if(vuforiaFunctions.getTfod().getRecognitions().size() == 1)
                {
                    if(vuforiaFunctions.getTfod().getRecognitions().get(0).getLabel().equals(vuforiaFunctions.LABEL_GOLD_MINERAL))
                    {
                        isRightGold = true;
                        pos = 'r';
                    }
                    else
                        isRightGold = false;
                }
                else if (vuforiaFunctions.getTfod().getRecognitions().size() >= 2)
                {
                    pos = vuforiaFunctions.getPositionOfGoldInTwoObjects();
                }
        }

        if(seenSomething && pos == '?')
        {
            if (!isRightGold && !isCenterGold)
                pos = 'l';
        }

        telemetry.addData("Will go in ", pos);
        telemetry.addData("Total recognitions ", vuforiaFunctions.getTfod().getRecognitions().size());
        telemetry.addData("2 Closest Recs: ", vuforiaFunctions.getTwoClosestRecognitions());
        telemetry.update();

        sleep(1000);
        switch (pos)
        {
            case 'l':
                compRobot.driveStraight(4, .7f);
                compRobot.pivotenc(35, .5f);
                compRobot.driveStraight(28, .7f);
                compRobot.pivotenc(-60, .5f);
                compRobot.driveStraight(20, .7f);
                break;
            case 'r':
                compRobot.driveStraight(4, .7f);
                compRobot.pivotenc(-35, .5f);
                compRobot.driveStraight(28, .7f);
                compRobot.pivotenc(60, .5f);
                compRobot.driveStraight(20, .7f);
                break;
            default:
                compRobot.driveStraight(25, .8f);
                while (compRobot.getFrontDistSens().getDistance(DistanceUnit.INCH) > 18 && compRobot.getFrontRightDistSens().getDistance(DistanceUnit.INCH) > 18)
                {
                    compRobot.driveMotors(.4f, .4f);
                }
                compRobot.stopDriveMotors();
        }
        compRobot.deployMarker();
        compRobot.driveStraight(-5, 1);

        switch (pos)
        {
            case 'l':
                compRobot.pivotenc(165, .5f);
                break;
            case 'r':
                compRobot.pivotenc(145, .5f);
            default:
                compRobot.pivotenc(155, .5f);
                compRobot.driveStraight(16, .6f);
                compRobot.pivotenc(9, .5f);
        }

        compRobot.hugWallToRight(4 + rightSensorDepth, 8 + rightSensorDepth, 22, 60);
        compRobot.driveStraight(6, .8f);

        while (!isStopRequested())
        {
            compRobot.stopDriveMotors();
        }
    }
}



