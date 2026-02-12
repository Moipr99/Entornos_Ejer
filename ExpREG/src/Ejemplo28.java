import java.util.Scanner;
import java.util.regex.*;

// REFERENCIA INVERSA

public class Ejemplo28 {
	public static void main(String[] args) {
		// Elimina los espacios en blanco entre una letra seguida de un punto o una coma 
		String regex = "(?i)(<titulo.*?>)(.+?)(</titulo>)"; // Los () hacen grupos para la referencia
		String texto = "<titulo>EJEMPLO_TEST</titulo>";
		String actualizado = texto.replaceAll(regex, "$2");
		
		System.out.println("Nuevo original: " + texto);
		System.out.println("Nuevo texto: " + actualizado);
		
	}
}