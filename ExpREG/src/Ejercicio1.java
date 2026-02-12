import java.util.Scanner;
import java.util.regex.*;

// REFERENCIA INVERSA

public class Ejercicio1 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		/*Crea un programa que pida un nombre de usuario e indique si es válido de acuerdo al siguiente formato:
			Debe tener una longitud de entre 3 y 20 caracteres
			Debe empezar por un carácter alfabético, mayúscula o minúscula
			A partir del segundo carácter puede contener mayúsculas, 
			minúsculas, números, y caracteres especiales como _ # $ % ? = + - ))*/
		
		System.out.print("Introduce un nombre de usuario: ");
		String usuario = teclado.nextLine().trim();
		
		String regex = "^[A-Za-z][A-Za-z0-9_#$%?=+-]{2,19}"; // se puede = ^[A-Za-z][\\w#$%?=+-]{2,19}
		if(usuario.matches(regex)) {
			System.out.println("El nombre es valido");
		} else {
			System.out.println("Nombre NO valido");
		}
		
	}
}