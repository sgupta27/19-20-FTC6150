package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.ArrayList;
import java.util.List;

@Autonomous(name = "TensorFlowDecisionTree")
public class TensorFlowDecisionTree extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        VuforiaFunctions vuforiaFunctions = new VuforiaFunctions(this, hardwareMap);
        waitForStart();

        while (opModeIsActive())
        {
            //telemetry.addData("POS OF GOLD", vuforiaFunctions.getPositionOfGold());
            telemetry.update();
        }
    }
}
