import java.util.Arrays;
import java.util.List;
public class EjercicioArrays {
    
    public static void main(String[] args) {
        int numAlumnos = 40;
        //vector con las notas generadas
        Integer[] control = new Integer[numAlumnos];
		int[] listaClase;
		int[] practicas;
		float[] calificaciones;
		float[] estadistica;
		int[] aprobados;
		int[] suspensos;
        int maxNota = 0;
        int minNota = 0;
        int indMaxNota; // Posocion donde sale nota más alta
        int  indMinNota; // Pos nota más baja
        int postEval;
		double[] calif;
		
        //Generar notas con el nuevo metodo
		for(int i=0; i < control.length; i++){
            control[i] = generarNota(); 
        }
		
        //buscamos al mayor
        postEval = 11;
        for(int i=0; i<control.length; i++){
            int preEval = control[i];
            if (preEval < postEval){
                minNota = preEval;
                postEval = control[i];
            }
        }
        //buscamos al menor
        postEval = 0;
        for(int i=0; i<control.length; i++){
            int preEval = control[i];
            if (preEval > postEval){
                maxNota = preEval;
                postEval = control[i];
            }
        }
        //creamos una lista de los alumnos de la clase
        listaClase = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++){
            listaClase[i] = i+1;
        }
        //Empezamos el uso de listas para facilitar la tarea de índices.
        List notas = Arrays.asList(control);
        indMinNota = notas.indexOf(minNota) + 1;
        indMaxNota = notas.indexOf(maxNota) + 1;

        //Comprobamos el resultado del ejercicio   
        System.out.println("Mínimo es: " + minNota);
        System.out.println("Máximo es: " + maxNota);
        System.out.println("Indice del mínimo es : " + indMinNota);
        System.out.println("Indice del máximo es : " + indMaxNota);
        System.out.println("Lista de clase :" + Arrays.toString(listaClase));
        System.out.println("Array de Notas :" + notas);
        
     // METODO PARA PRACT Y CALF
        //creamos el array de notas "practicas" 
        practicas = new int[numAlumnos];
        meterNotas(practicas);
        
        //Creamos el vector calificaciones (media)
        calificaciones = calcularCalificaciones(control, practicas);         
        System.out.println("Prácticas      :" + Arrays.toString(practicas));
        System.out.println("Calificaciones :" + Arrays.toString(calificaciones));
        
     // METODO PARA ESTATDISTICAS
        //Sacamos la estadística de calificaciones
        //hacemos un array de 10 para la estadística.
        estadistica = estadisticas(calificaciones);
        for (int i=0; i< estadistica.length; i++){
            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;
            System.out.println("Estadística nota tramo <=" 
                + (i+1) + " = " 
                + sol + "%");
        }
        
        // METODO PARA APROB Y SUSP
        //Aprobados y suspensos
        aprobados = estadoAlumno(calificaciones, true);
        suspensos = estadoAlumno(calificaciones, false);
        
        System.out.println("Relación de aprobados por nº de lista: " 
                + Arrays.toString(aprobados));
        System.out.println("Relación de suspensos por nº de lista: " 
                + Arrays.toString(suspensos));
        
     // METODO DE RESUMEN
        //Resumen de aprobados y suspensos
        int[] aprob = listaResumen(aprobados);
        int[] susp =listaResumen(suspensos);
        
        System.out.println("Resumen  de aprobados por nº de lista: " 
                + Arrays.toString(aprob));
        System.out.println("Resumen  de suspensos por nº de lista: " 
                + Arrays.toString(susp));
    
        /*6. Suponer un vector de Calificaciones de tamaño 40 
        (máximo de alumnos por clase), pero que solo almacena las
        notas de 31 alumnos. Realizar un programa que permita insertar en
        la posición 4 del vector la calificación de un nuevo 
        alumno en clase al que supuestamente le corresponde como nota un 6.*/
        calif = new double[40];
        for (int j=0; j<31; j++){
            calif[j] = generarNota();
        }
        System.out.println("Nota antigua alumno nº4: " + calif[3]); 
        calif[3] = 6;
        System.out.println("Nota nueva   alumno nº4: " + calif[3]);
    }
    
    public static int generarNota() {
        return (int) (Math.random() * 11);
    }
    
    // Array para las notas
    public static void meterNotas(int[] array) {
    	for (int i = 0; i < array.length; i++) {
            array[i] = generarNota();
        }
    }
    // Metodo para la media 
    public static float[] calcularCalificaciones(Integer[] cal, int[] pra ) {
    	float[] media = new float[cal.length];
    	for(int i = 0; i < cal.length; i++) {
    		media[i] = (float) (cal[i] + pra[i]) / 2;
    	}
    	return media;
    }
    
    // Metodo para las estadisticas
    public static float[] estadisticas(float[] calificaciones) {
    	float[] estadistica = new float[10];
    	for(int i = 0; i < 10; i++) {
    		float count = 0;
    		for(int j = 0; j < calificaciones.length; j++) {
    			if ((i < calificaciones[j]) && ((i+1) >= calificaciones[j])) {
    				count += 1;
    			}
    		}
    		if (count != 0) {
                estadistica[i] = (count / calificaciones.length);
            } else {
                estadistica[i] = 0;
            }
        }
        return estadistica;
    }
    
    // Metodo para estado: aprobados/suspensos
    public static int[] estadoAlumno(float[] notas, boolean aprobado) {
    	int[] estado = new int[notas.length];
    	for(int i = 0; i < notas.length; i++) {
    		if(aprobado) {
    			if(notas[i] >= 5) {
    				estado[i] = i +1;
    			}
    		} else {
    			if (notas[i] < 5) {
    				estado[i] = i+1;
    			}
    		}
    	} 
    	return estado;
    }
    
    public static int[] listaResumen(int[] listaAlumnos) {
    	int tamano = 0;
    	for (int id : listaAlumnos) {
    		if (id != 0)
    			tamano++;
    	}
    	
    	int[] resultado = new int[tamano];
    	int j = 0;
    	for(int id : listaAlumnos) {
    		if(id != 0) {
    			resultado[j++] = id;
    		}
    	}
    	return resultado;
    }
}
