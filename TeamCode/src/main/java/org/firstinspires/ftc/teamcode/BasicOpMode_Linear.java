package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


//Agradecimientos especiales
// Kalena Lugo


@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
//@Disabled
public class BasicOpMode_Linear extends LinearOpMode {

    DcMotor motorIzquierdo;
    DcMotor motorDerecho;
    DcMotor motorCanon;
    DcMotor motorRecogida;
    private CRServo servoShooter1/* = null*/;
    private CRServo servoShooter2 /*= null*/;

    double y, x;
    boolean disparo, recogida;


    double poderIzquierdo, poderDerecho;

    @Override
    public void runOpMode() {

        motorIzquierdo = hardwareMap.get(DcMotor.class, "mi");
        motorDerecho = hardwareMap.get(DcMotor.class, "md");
        motorCanon = hardwareMap.get(DcMotor.class, "mc");
        motorRecogida = hardwareMap.get(DcMotor.class, "mr");
        servoShooter1 = hardwareMap.get(CRServo.class, "s1");
        servoShooter2 = hardwareMap.get(CRServo.class, "s2");

        motorIzquierdo.setDirection(DcMotor.Direction.REVERSE);
        motorDerecho.setDirection(DcMotor.Direction.FORWARD);
        motorCanon.setDirection(DcMotor.Direction.FORWARD);
        motorRecogida.setDirection(DcMotor.Direction.FORWARD);
        motorIzquierdo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorDerecho.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {
            y = -gamepad1.left_stick_y;
            x = gamepad1.right_stick_x;
            double multiplicador = gamepad1.left_bumper ? 0.3 : 1.0;
            poderIzquierdo = Range.clip(y + x, -1.0, 1.0) * multiplicador;
            poderDerecho = Range.clip(y - x, -1.0, 1.0) * multiplicador;

            motorIzquierdo.setPower(poderIzquierdo);
            motorDerecho.setPower(poderDerecho);

            if(gamepad1.right_trigger > 0.3){
                motorCanon.setPower(1.0);
            } else{
                motorCanon.setPower(0.0);
            }

            if (gamepad1.left_trigger > 0.25){

                motorRecogida.setPower(1.0);
            } else{
                motorRecogida.setPower(0.0);
            }

            if (gamepad1.a){
                servoShooter1.setPower(1.0);
                servoShooter2.setPower(-1.0);
            } else if(gamepad1.b){
                servoShooter1.setPower(-1.0);
                servoShooter2.setPower(1.0);
            } else{
                servoShooter1.setPower(0.0);
                servoShooter2.setPower(0.0);
            }
        }
    }
}

/*


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


//Agradecimientos especiales
// Kalena Lugo


@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
@Disabled
public class BasicOpMode_Linear extends LinearOpMode {

    DcMotor motorIzquierdo;
    DcMotor motorDerecho;
    DcMotor motorCanon;
    DcMotor motorRecogida;

    double movimiento, curva;
    boolean disparo, recogida;


    double poderIzquierdo, poderDerecho;

    @Override
    public void runOpMode() {

        motorIzquierdo = hardwareMap.get(DcMotor.class, "mI");
        motorDerecho = hardwareMap.get(DcMotor.class, "mD");
        motorCanon = hardwareMap.get(DcMotor.class, "mC");
        motorRecogida = hardwareMap.get(DcMotor.class, "mR");

        motorIzquierdo.setDirection(DcMotor.Direction.REVERSE);
        motorDerecho.setDirection(DcMotor.Direction.FORWARD);
        motorCanon.setDirection(DcMotor.Direction.FORWARD);
        motorRecogida.setDirection(DcMotor.Direction.FORWARD);



        waitForStart();



        while (opModeIsActive()) {

            movimiento = -gamepad1.left_stick_y;
            curva = gamepad1.right_stick_x;
            disparo = gamepad1.left_trigger_pressed;
            recogida = gamepad1.a;

            poderIzquierdo = Range.clip(movimiento + curva, -1.0, 1.0) ;
            poderDerecho = Range.clip(movimiento - curva, -1.0, 1.0) ;
            if(disparo){


                motorCanon.setPower(1.0);
            }

            if (recogida){

                motorRecogida.setPower(1.0);
            }




            motorIzquierdo.setPower(poderIzquierdo);
            motorDerecho.setPower(poderDerecho);

        }
    }
}

*/



/*

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "TeleOp_Decode_Kai", group = "Linear Opmode")
public class BasicOpMode_Linear extends LinearOpMode {

    // variabkrs
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private CRServo servoShooter1 = null;
    private CRServo servoShooter2 = null;
    private DcMotor shooterMotor = null;
    private DcMotor intakeMotor = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Inicializando Robot...");
        telemetry.update();

        //mapeo
        leftFront = hardwareMap.get(DcMotor.class, "mi");
        rightFront = hardwareMap.get(DcMotor.class, "md");
        shooterMotor = hardwareMap.get(DcMotor.class, "mc");
        intakeMotor = hardwareMap.get(DcMotor.class, "mr");
        servoShooter1 = hardwareMap.get(CRServo.class, "s1");
        servoShooter2 = hardwareMap.get(CRServo.class, "s2");

        // confg direcciones
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);

        // confg freno
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        telemetry.addData("Status", "listo");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Avance
            double x = gamepad1.left_stick_x * 0.5; // Desplazamiento
            double rx = gamepad1.right_stick_x; // Rotación en su propio eje

            // Normalización de potencia
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);
            double frontLeftPower = (y + x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;

            // Modo lento con gatillo izquierdo
            double multiplier = (gamepad1.left_trigger > 0.3) ? 0.3 : 1.0;
            leftFront.setPower(frontLeftPower * multiplier);
            rightFront.setPower(frontRightPower * multiplier);

            //servos
            if (gamepad1.a) {
                servoShooter1.setPower(1.0);
                servoShooter2.setPower(-1.0);
            } else {
                servoShooter1.setPower(0.0);
                servoShooter2.setPower(0.0);
            }

            // shooter
            if (gamepad1.right_trigger > 0.1) {
                shooterMotor.setPower(-gamepad1.right_trigger);
            } else {
                shooterMotor.setPower(0.0);
            }

            if (gamepad1.left_trigger > 0.1){
                intakeMotor.setPower(gamepad1.left_trigger);
            } else{
                intakeMotor.setPower(0);
            }

            // telemetria
            telemetry.addData("Status", "Corriendo");
            telemetry.addData("Servos", "A: %s", (gamepad1.a ? "GIRANDO" : "PARADO"));
            telemetry.addData("Shooter Power", shooterMotor.getPower());
            telemetry.update();
        }
    }
}

*/