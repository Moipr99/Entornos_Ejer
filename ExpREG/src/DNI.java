import java.util.Scanner;
import java.util.regex.*;

// REFERENCIA INVERSA

public class DNI {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		/*Crea un programa que pida un DNI o NIE e indique si es válido de acuerdo al siguiente formato:
			Para DNI:
			Se compone de 9 caracteres.
			Los 8 primeros caracteres son números.
			El último carácter es una letra, mayúscula o minúscula, la cual solo puede ser "TRWAGMYFPDXBNJZSQVHLCKE".*/
		
		System.out.print("Introduce un DNI: ");
		String dninie = teclado.nextLine().trim();
		
		String regex = "^[0-9XYZ][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKE]$"; // ^[0-9XYZxyz][0-9{7}[A-HJ-NP-TV-Z]$ -- PARA los 2
		if(dninie.matches(regex)) {
			if(dninie.charAt(0) >= '0' && dninie.charAt(0) <= '9') {
				System.out.println("DNI valido");
			} else {
				System.out.println("NIE valido");
			}
			System.out.println("DNI es valido");
		} else {
			System.out.println("DNI/NIE NO valido");
		}
		
	}
}