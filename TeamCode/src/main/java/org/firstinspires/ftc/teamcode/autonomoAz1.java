/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


//Agradecimientos especiales
// Kalena Lugo

//ELECTROSHARKS SOS DE LA B
//AUDAZ MORISTE EN MADRID


@Autonomous(name="Autonomo Alianza Azul Arriba")

public class autonomoAz1 extends LinearOpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor shootMotor;
    DcMotor intakeMotor;
    CRServo servoShooter1, servoShooter2;


    @Override
    public void runOpMode() {

        leftDrive = hardwareMap.get(DcMotor.class, "mi");
        rightDrive = hardwareMap.get(DcMotor.class, "md");
        shootMotor = hardwareMap.get(DcMotor.class, "mc");
        servoShooter1 = hardwareMap.get(CRServo.class, "s1");
        servoShooter2 = hardwareMap.get(CRServo.class, "s2");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        shootMotor.setDirection(DcMotorSimple.Direction.FORWARD);



        waitForStart();



        if (opModeIsActive()) {

            leftDrive.setPower(1.0);
            rightDrive.setPower(1.0);
            sleep(800);

            leftDrive.setPower(1.0);
            rightDrive.setPower(0.0);
            sleep(400);

            leftDrive.setPower(1.0);
            rightDrive.setPower(1.0);
            sleep(200);

            servoShooter1.setPower(1.0);
            servoShooter2.setPower(1.0);
            intakeMotor.setPower(1.0);
            shootMotor.setPower(1.0);
            sleep(5000);

            leftDrive.setPower(0.0);
            rightDrive.setPower(1.0);
            servoShooter1.setPower(0.0);
            servoShooter2.setPower(0.0);
            intakeMotor.setPower(0.0);
            shootMotor.setPower(0.0);
            sleep(400);

            leftDrive.setPower(1.0);
            rightDrive.setPower(1.0);
            sleep(500);

            leftDrive.setPower(0.0);
            rightDrive.setPower(1.0);
            sleep(500);

            leftDrive.setPower(1.0);
            rightDrive.setPower(1.0);
            intakeMotor.setPower(1.0);
            sleep(1500);


            leftDrive.setPower(-1.0);
            rightDrive.setPower(-1.0);
            intakeMotor.setPower(0.0);
            sleep(1500);

            leftDrive.setPower(0.0);
            rightDrive.setPower(1.0);
            sleep(500);

            leftDrive.setPower(1.0);
            rightDrive.setPower(1.0);
            sleep(500);

            leftDrive.setPower(0.0);
            rightDrive.setPower(1.0);
            sleep(300);

            servoShooter1.setPower(1.0);
            servoShooter2.setPower(1.0);
            intakeMotor.setPower(1.0);
            shootMotor.setPower(1.0);
            sleep(5000);

            leftDrive.setPower(-1.0);
            rightDrive.setPower(-1.0);
            servoShooter1.setPower(0.0);
            servoShooter2.setPower(0.0);
            intakeMotor.setPower(0.0);
            shootMotor.setPower(0.0);
            sleep(1000);





        }
    }
}
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

// Agradecimientos especiales
// Kalena Lugo

@Autonomous(name="Autonomo Alianza Azul Arriba")
public class autonomoAz1 extends LinearOpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor shootMotor;
    DcMotor intakeMotor;

    CRServo servoShooter1, servoShooter2;

    @Override
    public void runOpMode() {

        // 1. Mapeo de Hardware
        leftDrive = hardwareMap.get(DcMotor.class, "mi");
        rightDrive = hardwareMap.get(DcMotor.class, "md");
        shootMotor = hardwareMap.get(DcMotor.class, "mc");
        intakeMotor = hardwareMap.get(DcMotor.class, "mr");
        servoShooter1 = hardwareMap.get(CRServo.class, "s1");
        servoShooter2 = hardwareMap.get(CRServo.class, "s2");

        // IMPORTANTE: Si tu robot se va a la izquierda al ir hacia adelante,
        // invierte estos valores (pon FORWARD en leftDrive y REVERSE en rightDrive).
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        shootMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        // Frenar los motores cuando la potencia sea 0 (ayuda a la precisión)
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        if (opModeIsActive()) {

            // --- PASO 1: Ir hacia adelante por ~1.50 metros ---
            leftDrive.setPower(1.0);
            rightDrive.setPower(1.0);
            // El tiempo dependerá de tus motores y ruedas. 1500ms suele ser un buen punto de partida.
            sleep(1500);

            // Detener el chasis un momento para estabilizar la inercia
            leftDrive.setPower(0.0);
            rightDrive.setPower(0.0);
            sleep(300);

            // --- PASO 2: Girar 90 grados a la izquierda ---
            // Para girar a la izquierda: motor derecho va hacia adelante, motor izquierdo hacia atrás.
            leftDrive.setPower(1.0);
            rightDrive.setPower(-1.0);
            // Ajusta este tiempo (aprox 600-900ms) hasta que el giro sea exactamente de 90 grados.
            sleep(750);

            // Detener el chasis
            leftDrive.setPower(0.0);
            rightDrive.setPower(0.0);
            sleep(300);

            // --- PASO 3: Disparar (Shooter, Servos e Intake) ---
            shootMotor.setPower(1.0);
            intakeMotor.setPower(1.0);
            servoShooter1.setPower(1.0);
            servoShooter2.setPower(1.0);
            // Mantener todo encendido por 5 segundos para asegurar que salgan las pelotas
            sleep(5000);

            // --- PASO 4: Apagar todo y terminar ---
            shootMotor.setPower(0.0);
            intakeMotor.setPower(0.0);
            servoShooter1.setPower(0.0);
            servoShooter2.setPower(0.0);

            // Pausa final antes de que el opMode se detenga por completo
            sleep(500);
        }
    }
}