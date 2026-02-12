
public class Ejemplo01 {
	public static void main(String[] args) {
		// Ejempolo CONCAT
		String nombre = "Moira";
		String apellido = "Pérez";
		
		System.out.println("Nombre completo: ");
		System.out.println(nombre.concat(" ").concat(apellido));
		
		System.out.println("Forma tradicional con el +: ");
		System.out.println(nombre + " " + apellido);
		
	}
}