import java.util.Scanner;
import java.util.regex.*;

// REFERENCIA INVERSA

public class Ejemplo27 {
	public static void main(String[] args) {
		// Elimina los espacios en blanco entre una letra seguida de un punto o una coma 
		String regex = "(\\w)(\\s+)([\\.,])"; // Los () hacen grupos para la referencia
		String texto = "Hola , esto esta regular";
		System.out.println(texto);
		System.out.println("Hola  , Esto está regular .".replaceAll(regex, "$1$3"));
		
	}
}