package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "TeleOp_Decode_Kai", group = "Linear Opmode")
public class BasicOpMode_Linear extends LinearOpMode {

    // DECLARACION DE VARIABLES
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private CRServo servoShooter1 = null;
    private CRServo servoShooter2 = null;
    private DcMotor shooterMotor = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Inicializando Robot...");
        telemetry.update();

        // MAPEEO DEL HARDWARE/
        leftFront = hardwareMap.get(DcMotor.class, "mi");
        rightFront = hardwareMap.get(DcMotor.class, "md");
        shooterMotor = hardwareMap.get(DcMotor.class, "mc");
        servoShooter1 = hardwareMap.get(CRServo.class, "s1");
        servoShooter2 = hardwareMap.get(CRServo.class, "s2");

        // CONFIGURACIÓN DE DIRECCIONES
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);

        // CONFIGURACIÓN DE FRENO
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "¡Listo para la Copa Ka'i!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // ==========================================
            // CONTROLADOR 1: CHASIS
            // ==========================================
            double y = -gamepad1.left_stick_y; // Avance
            double x = gamepad1.left_stick_x * 0.5; // Desplazamiento
            double rx = gamepad1.right_stick_x; // Rotación

            // Normalización de potencia
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);
            double frontLeftPower = (y + x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;

            // Modo lento con gatillo izquierdo
            double multiplier = (gamepad1.left_trigger > 0.3) ? 0.3 : 1.0;
            leftFront.setPower(frontLeftPower * multiplier);
            rightFront.setPower(frontRightPower * multiplier);

            // ==========================================
            // CONTROL DE SERVOS (GIRO INFINITO)
            // ==========================================
            // Giran mientras mantengas presionado A, se detienen al soltarlo
            if (gamepad1.a) {
                servoShooter1.setPower(1.0);  // Máxima potencia adelante
                servoShooter2.setPower(-1.0); // Sentido opuesto si están enfrentados
            } else {
                servoShooter1.setPower(0.0);  // Se detiene y queda fijo
                servoShooter2.setPower(0.0);
            }

            // shooter
            if (gamepad1.right_trigger > 0.1) {
                shooterMotor.setPower(-gamepad1.right_trigger);
            } else {
                shooterMotor.setPower(0.0);
            }

            // TELEMETRÍA
            telemetry.addData("Status", "Corriendo");
            telemetry.addData("Servos", "A: %s", (gamepad1.a ? "GIRANDO" : "PARADO"));
            telemetry.addData("Shooter Power", shooterMotor.getPower());
            telemetry.update();
        }
    }
}