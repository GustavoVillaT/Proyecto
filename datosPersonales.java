import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.StringTokenizer;

public class datosPersonales{


private int numTrabajadores=100;//numero de trabajadores
private ArrayList<Integer> edadTrabajador = new ArrayList<Integer>();
private ArrayList<String> nombreTrabajador = new ArrayList<String>();
private ArrayList<String> aPaternoTrabajador = new ArrayList<String>();
private ArrayList<String> aMaternoTrabajador = new ArrayList<String>();
/**
*Constructor
*/
public datosPersonales(){}






public void asignarDatos(){
String[] nombresAleatorios = {"Jose","Marco","Pedro","Luis","Marta","Frida","Francisco", "Ramon","Lorena","Matias","Jordan","Sergio","Saul","Samantha","Miguel","Martin","Antonela","Federico","Angel","Clara","Daniela", "Jesica", "Enrique", "Mateo", "Leonardo", "Rafael","Adrián", "Sofia"};
String[] apellidosAleatorios={"Villa","Rodríguez", "Martínez", "Hernández", "López", "González", "Pérez","Sánchez", "Ramírez", "Torres", "Flores", "Rivera","Gómez", "Díaz", "Reyes", "Cruz", "Morales", "Ortiz", "Gutiérrez","Smith","Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "García", "Rodríguez", "Wilson"};
int indice,indice2,indice3;
  int edadMinima = 18;
  int edadMaxima = 80;
for(int i=0;i<numTrabajadores;i++){
  indice=(int)Math.floor(Math.random()*(nombresAleatorios.length)); 
  indice2=(int)Math.floor(Math.random()*(nombresAleatorios.length));
  indice3=(int)Math.floor(Math.random()*(nombresAleatorios.length));
  edadTrabajador.add((int)Math.floor(Math.random()*(edadMaxima-edadMinima+1)+edadMinima));
  nombreTrabajador.add(nombresAleatorios[indice]);
  aPaternoTrabajador.add(apellidosAleatorios[indice2]);
  aMaternoTrabajador.add(apellidosAleatorios[indice3]);
}
    //imprimir datos
for(int i=0;i<numTrabajadores;i++){
  System.out.println("El trabajador "+nombreTrabajador.get(i)+" "+aPaternoTrabajador.get(i)+" "+aMaternoTrabajador.get(i)+" tiene una edad de "+edadTrabajador.get(i)+" años.");
}
}
public void Direcciones(){
    int count=0;
    ArrayList<String> colonia = new ArrayList<String>();
    ArrayList<String> estado = new ArrayList<String>();
    ArrayList<String> municipio = new ArrayList<String>();

    try{
      FileReader fr=new FileReader ("Datosdirecciones.csv");
      BufferedReader br=new BufferedReader(fr);
      String linea=br.readLine();
      while(linea!=null){
        StringTokenizer separador =new StringTokenizer(linea,",");
        while(separador.hasMoreTokens()){  
          String aux=separador.nextToken();
          if(count==0){
            count++;
          }else if(count==1){
            count++;
          }else if(count==2){
            count++;
          }else if(count==3){
            colonia.add(aux);
          }else if(count==4){

          }

        }
        linea=br.readLine();
      }
    br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }

}


}

