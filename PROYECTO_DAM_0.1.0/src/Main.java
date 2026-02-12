import Classes.Config;
import Classes.Session;
import java.util.Scanner;
import Classes.Input;
import Classes.Maze;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
        Session session = new Session();
        Maze maze = new Maze();
        int option;

        System.out.println(Config.WELCOME);
        System.out.println("Versión: " + Config.VERSION);
        
        do {
            if (!session.isLogged()) {

                System.out.println(Config.UNLOGGED_MENU);
                option = Input.getInt("Elige una opción: ");

                switch (option) {
                    case 1:
                        session.login();
                        break;
                    case 2:
                        session.signup();
                        break;
                    case 0:
                        System.out.println(Config.GOODBYE);
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

            } else {
            	
            	 System.out.println(Config.LOGGED_MENU);
            	 option = Input.getInt("Elige una opción: ");

                 switch (option) {
                     case 1:
                    	 maze.loadMaze();
                         break;
                     case 2:
                    	 maze.showMaze(); 
                         break;
                     case 3:
                    	 maze.setStartEnd(); 
                         break;
                     case 4:
                         System.out.println("Próximamente");
                         break;
                     case 5:
                         session.showUser();
                         break;
                     case 6:
                         System.out.println("Cerrando sesión...");
                         session.logout();
                         maze.reset();
                         break;
                     case 0:
                         System.out.println(Config.GOODBYE);
                         break;
                     default:
                         System.out.println("Opción no válida");
                 }
             }
         } while (option != 0);
     } 
}
