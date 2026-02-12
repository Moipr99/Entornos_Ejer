import java.util.Scanner;
import java.util.regex.*;

public class Ejemplo18 {
	public static void main(String[] args) {
		String texto = "abc del mar";
		String regex = "^abc.*"; // empiezan por abc y le sigue un caracter 0 o 1 vez
		
		// Hacer busqyueda y extraer los fragmentos que coinciden 
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (valor: " 
								+ concordancias.group() +")");
		}
			
		// Comprobar que toda la cadena cumple la expresion.
		boolean res1 = texto.matches("^abc.*"); // . .* = un caracter cualqueira + lo que siga
		System.out.println("Coincide? " + res1); // .* que la cadena sigue aunque acabe// .+ 1 o muchos
		
	}
}