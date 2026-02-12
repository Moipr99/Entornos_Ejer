package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Maze {
	
	private char[][] map;
	private String filename; // ruta laberinto
	private boolean loaded; // valor false y se pondrá con valor true con un laberinto
	private int startI; // coordenadas de inicio
	private int startJ;
	private int endI; // coordenadas del final
	private int endJ;
	
	private Scanner key = new Scanner(System.in);

	//Constructor
	public Maze() {
		
		this.map = null; // vacio hasta que se carga
		this.filename = ""; // se tiene que seleccionar
		this.loaded = false;
		this.startI = -1;
		this.startJ = -1;
		this.endI = -1;
		this.endJ = -1;
	}
	
	// Getters
    public boolean isLoaded() {
        return loaded;
    }

    public char[][] getMap() {
        return map;
    }

    public int getStartI() {
        return startI;
    }

    public int getStartJ() {
        return startJ;
    }

    public int getEndI() {
        return endI;
    }

    public int getEndJ() {
        return endJ;
    }

    public String getFilename() {
        return filename;
    }
	
    // Cargar laberinto
    public void loadMaze() {
        File dire = new File("./assets/mazes"); // carpeta donde estan los laberintos
        if (!dire.exists() || !dire.isDirectory()) {
            System.out.println("No se encontró la carpeta mazes.");
            return;
        }

        File[] files = dire.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No hay laberintos en la carpeta.");
            return;
        }

        System.out.println("Selecciona un laberinto para cargar:");
        int count = 1;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && files[i].getName().endsWith(".txt")) {
                System.out.println(count + " - " + files[i].getName());
                count++;
            }
        }
        System.out.println("0 - Cancelar");

        int opcion = -1;
        do {
            System.out.print("Elige una opción: ");
            opcion = key.nextInt();
            key.nextLine(); // Limpia
            if (opcion == 0) {
                System.out.println("Cancelado.");
                return;
            }
            if (opcion <= 0 || opcion >= count) {
                System.out.println("Opción inválida, prueba de nuevo.");
            }
        } while (opcion < 0 || opcion >= count);

        // Obtener el laberinto elegido
        int index = 0;
        count = 1;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && files[i].getName().endsWith(".txt")) {
                if (count == opcion) {
                    filename = files[i].getPath();
                    break;
                }
                count++;
            }
        }

        // Cargar laberinto en la matriz
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int rows = 0;
            int cols = 0;

            // Contar filas y columnas
            while ((line = br.readLine()) != null) {
                rows++;
                if (line.length() > cols) cols = line.length();
            }

            map = new char[rows][cols];

            // Volver al inicio del fichero
            br.close();
            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            int i = 0;
            while ((line = br2.readLine()) != null) {
                for (int j = 0; j < line.length(); j++) {
                    map[i][j] = line.charAt(j);
                }
                // Rellenar con espacios si la línea es más corta que cols
                for (int j = line.length(); j < cols; j++) {
                    map[i][j] = ' ';
                }
                i++;
            }
            br2.close();

            loaded = true;
            System.out.println("Laberinto cargado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar el laberinto: " + e.getMessage());
        }
    }

    // Mostrar el laberinto con numeración
    
    /* No he conseguido cuadrar el numero de filas y columnas yo sola ni que las columnas pasen de 9 
     * sin romper el dibujo, se lo he preguntado a la IA. Lo siento.*/
    public void showMaze() {
        if (!loaded) {
            System.out.println("No hay laberinto cargado.");
            return;
        }

        int rows = map.length;
        int cols = map[0].length;

        // Número de dígitos del mayor índice de columna
        int maxDigits = String.valueOf(cols - 1).length();

        // --- NUMERACIÓN DE COLUMNAS EN VERTICAL ---
        for (int d = 0; d < maxDigits; d++) {
            System.out.print("   "); // espacio para los números de fila
            for (int c = 0; c < cols; c++) {
                String colNumber = String.valueOf(c);
                int pos = colNumber.length() - maxDigits + d;

                if (pos >= 0) {
                    System.out.print(colNumber.charAt(pos));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // --- LABERINTO CON NÚMEROS DE FILA ---
        for (int i = 0; i < rows; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < cols; j++) {
                if (i == startI && j == startJ) {
                    System.out.print("I");
                } else if (i == endI && j == endJ) {
                    System.out.print("F");
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }

    // Establecer inicio y fin
    public void setStartEnd() {
        if (!loaded) {
            System.out.println("No hay laberinto cargado.");
            return;
        }
        
        //AÑADIR COMPROBACION DE QUE SE PONEN BIEN LAS CASILLAS - xa v3

        System.out.println("Introduce coordenadas de inicio:");
        System.out.print("Fila: ");
        startI = key.nextInt();
        System.out.print("Columna: ");
        startJ = key.nextInt();

        System.out.println("Introduce coordenadas de fin:");
        System.out.print("Fila: ");
        endI = key.nextInt();
        System.out.print("Columna: ");
        endJ = key.nextInt();

        System.out.println("Coordenadas establecidas correctamente.");
    }
    
    public void reset() {
        map = null;
        filename = "";
        loaded = false;
        startI = -1;
        startJ = -1;
        endI = -1;
        endJ = -1;
    }
}