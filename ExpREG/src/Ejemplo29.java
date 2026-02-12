import java.util.Scanner;
import java.util.regex.*;

// REFERENCIA INVERSA

public class Ejemplo29 {
	public static void main(String[] args) {
		// Remplaza cualquier letras a y sus dos siguientes
		String texto = "Me llamo Moira";
		System.out.println(texto.replaceAll("a..", "AAA"));
		
	}
}