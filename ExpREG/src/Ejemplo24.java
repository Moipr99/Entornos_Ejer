import java.util.Scanner;
import java.util.regex.*;

public class Ejemplo24 {
	public static void main(String[] args) {
		String texto = "abc d2dg1Efdg as12r1Xabc15ty1"; // el de  final no porque no le sigue nada 
		String regex = "1[^2]"; //Comprueba si contiene un 1 y ese 1 no está seguido por un 2, 
									//opcionalmente va precedido o seguido de ninguno o varios caracteres
		
		// Hacer busqyueda y extraer los fragmentos que coinciden 
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (valor: " 
								+ concordancias.group() +")");
		}
			
		// Comprobar que toda la cadena cumple la expresion.
		boolean res1 = texto.matches(".*1[^2].*"); //
		System.out.println("Coincide? " + res1); // .* que la cadena sigue aunque acabe// .+ 1 o muchos
		
	}
}