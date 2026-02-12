import java.util.Scanner;
import java.util.regex.*;

public class Ejemplo26 {
	public static void main(String[] args) {
		String texto = "Prueba9x$"; // contraseña
		String regex = "(?=.*[A-ZÑ])(?=.*[a-zñ])(?=.*\\d)(?=.+[$*-+&!?%]).{8,}"; // min 8 
		// Comprueba condiciones = CORREO
		
			
		// Comprobar que toda la cadena cumple la expresion.
		boolean res1 = texto.matches(regex); //
		if (texto.matches(regex)) {
			System.out.println("La contraseña es segura");
		} else {
			System.out.println("Contraseña débil");
		}
		System.out.println("Coincide? " + res1); // .* que la cadena sigue aunque acabe// .+ 1 o muchos
		
	}
}