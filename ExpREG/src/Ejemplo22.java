import java.util.Scanner;
import java.util.regex.*;

public class Ejemplo22 {
	public static void main(String[] args) {
		String texto = "AbC abCdeFG abcdefghijkmnlopqrstu hfie"; 
		String regex = ".*^[^\\d]&.*"; // Comprueba si no acaba con un digito, & = final de la cadena
									   // opcionalmente preciddido de ninguno o varios caracteres
		
		// Hacer busqyueda y extraer los fragmentos que coinciden 
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (valor: " 
								+ concordancias.group() +")");
		}
			
		// Comprobar que toda la cadena cumple la expresion.
		boolean res1 = texto.matches(".*^[^\\d]&.*"); //
		System.out.println("Coincide? " + res1); // .* que la cadena sigue aunque acabe// .+ 1 o muchos
		
	}
}