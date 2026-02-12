package Classes; 

public class User {

	private String username;
	private String password;
	private String name;
	private String nif;
	private String email;
	private String address;
	private String birthday;
	private String role;
	
	// Para cuando se crea un usuario (un insert)
	 public User(String username, String password, String name, String nif,
             String email, String address, String birthday, String role) {

	     /* Validar username
	     if (username == null || username.trim().isEmpty() || username.length() < 3) {
	         throw new IllegalArgumentException(
	             "Nombre de usuario inválido (mínimo 3 caracteres)"
	         );
	     }
	     // Validar password
	     if (password == null || password.trim().isEmpty() || password.length() < 5) {
	         throw new IllegalArgumentException(
	             "Contraseña inválida (mínimo 6 caracteres)"
	         );
	     } EN PROXIMAS VERSIONES*/ 

	    this.username = username.trim().toLowerCase();
	    this.password = password.trim();
		this.name = name;
		this.nif = nif;
		this.email = email;
		this.address = address.trim();
		this.birthday = birthday;
		this.role = role;
	}
	// Coge los datos de usuario
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNif() {
		return nif;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getRole() {
		return role;
	}
	
	// Comprobar contraseña (login)
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }
	
}
