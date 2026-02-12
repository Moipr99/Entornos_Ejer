import java.util.Scanner;
import java.util.regex.*;

public class Ejemplo19 {
	public static void main(String[] args) {
		String texto = "AbC asfjsiofh fcjwi0hv hfie";
		String regex = "^[aA][bB][cC.]*"; // empiezan por abc/ABC y opcionalmente le sigue un caracter 0 o 1 vez (.*)
		
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
		boolean res1 = texto.matches("^[aA][bB][cC.]*"); // . .* = un caracter cualqueira + lo que siga 1 o 0 
		System.out.println("Coincide? " + res1); // .* que la cadena sigue aunque acabe// .+ 1 o muchos
		
	}
}