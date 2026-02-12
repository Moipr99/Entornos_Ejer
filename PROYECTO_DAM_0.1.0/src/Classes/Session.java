package Classes; // añadida clase input
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Session {
	private Scanner key = new Scanner(System.in);
	
	private User user;
    private boolean logged;
    private static final String FILE_PATH = "./assets/files";
    private static final String USERS_FILE = "users.txt";

    // Inicializa a false
    public Session() {
        this.logged = false;
        this.user = null;
    }
    
    //Login: solicita datos al usuario
    public void login() {

        String username = Input.getString("Username: ");
        String password = Input.getString("Password: ");

        User foundUser = findUser(username);

        // sin distinguir mayus y minus
        if (foundUser != null &&
            foundUser.getUsername().equalsIgnoreCase(username) &&
            foundUser.getPassword().equals(password)) {

            user = foundUser;
            logged = true;
            System.out.println("Sesión iniciada correctamente.");
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

        Input.toContinue();
    }
    
    //Registro de nuevo usuario
    public void signup() {
        System.out.print("Username: ");
        String username = key.nextLine().trim();

     // Comprobar si el usuario ya existe
        if (findUser(username) != null) {
            System.out.println("El nombre de usuario ya existe.");
            Input.toContinue();
            return;
        }
        
         // AÑADIR PONER 2 VECES LA CONTRASEÑA PARA COMPROBAR
         // + mensaje de no coincidencia. 
        
        String password = Input.getString("Password: ");
        String name = Input.getString("Nombre: ");
        String nif = Input.getString("NIF: ");
        String email = Input.getString("Email: ");
        String address = Input.getString("Dirección: ");
        String birthday = Input.getString("Fecha de nacimiento: ");
        String role = "user";

        User newUser = new User(username, password, name, nif, email, address, birthday, role);
        
        // Aqui luego las validaciones de longitud y demas

        try {
            saveUser(newUser);
            System.out.println("Usuario registrado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario.");
        }

        Input.toContinue();
    }
    
    //Si hay sesión iniciada
    public boolean isLogged() {
        return logged;
    }
    
    // Muestra todos los datos del usuario logueado
    public void showUser() {
        if (!logged || user == null) {
            System.out.println("No hay sesión iniciada.");
            Input.toContinue();
            return;
        }
        
        System.out.println("---- USUARIO ACTUAL ----");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Nombre: " + user.getName());
        System.out.println("NIF: " + user.getNif());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Dirección: " + user.getAddress());
        System.out.println("Fecha nacimiento: " + user.getBirthday());
        System.out.println("Rol: " + user.getRole());

        Input.toContinue();
    }
    
    // Cerrar sesión
    public void logout() {
        logged = false;
        user = null;
        System.out.println("Sesión cerrada.");
        Input.toContinue();
    }
    
    // Busca un usuario por username en el fichero
    private User findUser(String username) {
        File file = new File(FILE_PATH + "/" + USERS_FILE);

        if (!file.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("#");
                if (data.length >= 8 && data[0].trim().equalsIgnoreCase(username.trim())) {
                    // Crear User con trim para evitar espacios y saltos de línea
                    return new User(data[0].trim(), data[1].trim(), data[2].trim(),
                    				data[3].trim(), data[4].trim(), data[5].trim(),
                    				data[6].trim(), data[7].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de usuarios: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
    
    //Guarda un usuario en el fichero
    private void saveUser(User user) throws IOException {
        
        File file = new File(FILE_PATH + "/" + USERS_FILE);
        
        // Abrir FileWriter para no borrar los usuarios que ya estan
        FileWriter writer = new FileWriter(file, true);
        
        // Escribir datos del usuario
        writer.write(
            user.getUsername().trim() + "#" +
            user.getPassword().trim() + "#" +
            user.getName().trim() + "#" +
            user.getNif().trim() + "#" +
            user.getEmail().trim() + "#" +
            user.getAddress().trim() + "#" +
            user.getBirthday().trim() + "#" +
            user.getRole().trim()
        );

        // Salto de línea final
        writer.write("\n");

        // Cerrar escritor
        writer.close();
    }
}
