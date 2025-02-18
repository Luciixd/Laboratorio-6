/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class Usuario {

    private static final String USUARIO_CORRECTO = "admin";
    private static final String CONTRASEÑA_CORRECTA = "1234";

    public static boolean autenticar() {
        Scanner scanner = new Scanner(System.in);
        int intentos = 3;

        while (intentos > 0) {
            System.out.print("Ingrese usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese contraseña: ");
            String contraseña = scanner.nextLine();

            if (usuario.equals(USUARIO_CORRECTO) && contraseña.equals(CONTRASEÑA_CORRECTA)) {
                System.out.println("¡Login exitoso! Bienvenido al sistema.");
                return true;
            } else {
                intentos--;
                System.out.println("Usuario o contraseña incorrectos. Intentos restantes: " + intentos);
            }
        }
        System.out.println("Demasiados intentos fallidos. Saliendo del sistema...");
        return false;
    }
    
}
