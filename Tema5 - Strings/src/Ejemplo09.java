import java.util.Scanner;

public class Ejemplo09 {
	public static Scanner key = new Scanner(System.in);
	public static void main(String[] args) {
		// convertir array char a String
		
		char [] letras = {'A', 'B', 'C', ' ', 'D', 'E', 'F'};

		String texto = new String(letras);
		System.out.println(texto);
		
	}

}