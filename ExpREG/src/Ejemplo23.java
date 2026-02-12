import java.util.Scanner;
import java.util.regex.*;

public class Ejemplo23 {
	public static void main(String[] args) {
		String texto = "AbC abCdeFG abcdefghijkmn adbg hfie"; 
		String regex = "(a|b)+"; // Comprueba si tiene A o B al menos una vez
		
		// Hacer busqyueda y extraer los fragmentos que coinciden 
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (valor: " 
								+ concordancias.group() +")");
		}
			
		// Comprobar que toda la cadena cumple la expresion.
		boolean res1 = texto.matches(".*(a|b)+.*"); //
		System.out.println("Coincide? " + res1); // .* que la cadena sigue aunque acabe// .+ 1 o muchos
		
	}
}