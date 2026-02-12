import java.util.Scanner;

public class Ejemplo08 {
	public static Scanner key = new Scanner(System.in);
	public static void main(String[] args) {
		// SUBSTRING
		/* String myStr = "Hello, World!";
			System.out.println(myStr.substring(7, 12));*/

		System.out.println("Introduce una frase: ");
		String frase = key.nextLine().trim();
		System.out.println("Frase: " + frase);
		String subcadena = key.nextLine().trim();
		// Utilizando otro metodos y substring , mostrar una cadena que excluya la priemra palabra,
		// por lo que hay que insertar al menos 3 palabras en la frase.
		
		int inicio = frase.indexOf(" ");
		int fin = frase.lastIndexOf(" ");
		if(inicio > 0 && fin > 0 && inicio < fin) {
			String subcadena = frase.substring(fin);
		}
	}

}