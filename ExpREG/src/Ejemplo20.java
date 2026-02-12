import java.util.Scanner;
import java.util.regex.*;

public class Ejemplo20 {
	public static void main(String[] args) {
		String texto = "AbC abCdeFG abcdefghijkmnlopqrstu hfie";
		String regex = "[a-zA-Z]{5,10}"; // Comprueba un patron formado por un minimo de 5 letras hasta 10 (mayus/minus)
		
		// LOS [] buscan los caracteres dentro del rango y forma
		
		// Hacer busqyueda y extraer los fragmentos que coinciden 
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (valor: " 
								+ concordancias.group() +")");
		}
			
		// Comprobar que toda la cadena cumple la expresion.
		boolean res1 = texto.matches(".*[a-zA-Z]{5,10}.*"); //
		System.out.println("Coincide? " + res1); // .* que la cadena sigue aunque acabe// .+ 1 o muchos
		
	}
}