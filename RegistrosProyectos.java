import java.util.ArrayList;
import java.lang.String;
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
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.lang.Math;


public class RegistrosProyectos{
  /*“Modulo generador de registro de proyectos”. La empresa hasta este punto cuenta con 50
distintos proyectos (40 históricos y 10 vigentes).
a. Los trabajadores deben tener en su historial de registros proyectos que hayan
realizado (aleatoriamente de 0-50) el numero total de ellos y el nombre del proyecto.
b. Los trabajadores deben tener al menos 1 proyecto vigente y máximo 3.*/
private String[] historicos = {"humanidaria","caras Inocentes","apoyo comunitario","Conciencia Colectiva","Sembrando Oportunidades","ProAprende","Aprendizaje Dinamico","Agua y vida","Sovi","Hazlo Posible","ProTierra","Ecovida","Saber más","Ciencia T","Ecociencia","Mundo Tecnologico","Tecno","Cerebros Exploradores","cienbidura","viendo hacia el futuro","Ciclon","Durango","Luciernaga","Hercules","Jupiter","Laguna","Metro","Omega","Fenix","Langosta","preludio","Sputnik","Revolucion Tecnologica","Don Gato","Unidad","Conciencia","Nelson","Catarsis","Reconstruccion","Rosas"};
private String[] vigentes = {"Internacional","ONG","Progreso","Nuevo Rumbo","Mundo Educa","Escuela Global","Cometa","Flora","Fauna","Nuevo Amanecer"};
private ArrayList<String> Proyectos = new ArrayList<String>();
private int numTrabajadores = 10;
private ArrayList<String> proyectosTrabajadores= new ArrayList<String>();


public RegistrosProyectos(){}
public void setHistoricos(String[] historicos){
  this.historicos = historicos;
}
public String[] getHistoricos(){

  return this.historicos;

}
public void setProyectos(ArrayList<String> Proyectos){
  this.Proyectos = Proyectos;
}
public ArrayList<String> getProyectos(){
  return Proyectos;
}

public void setVigentes(String[] vigentes){
  this.vigentes = vigentes;
}

public String[] getVigentes(){

  return vigentes;
}
public void Registros(){
  Proyectos.clear();
  int indice,indice2, j; 
    int Min = 1;
    int Max = 3;
    j = (int)Math.floor(Math.random() * (Max - Min + 1)) + Min;
    ArrayList<Integer> numRepetidos = new ArrayList<Integer>();
    Min = 0;
    Max = 9;
    for(int i=0;i<j;i++){
     indice = (int)Math.floor(Math.random() * (Max - Min + 1)) + Min;
     boolean encontrar=false;
      for(int k=0;k<i;k++){
          if(numRepetidos.get(k)==indice){
            encontrar=true;
          }
      }
      if(!encontrar){
        numRepetidos.add(indice);
        Proyectos.add(vigentes[indice]);
      }else{
        i--;
      }
    }
    Min = 0;
    Max = 39;
    int maxProye=1;
    int minProye=3;

    j= (int)Math.floor(Math.random() * (maxProye - minProye + 1)) + minProye;
       numRepetidos.clear();
    for(int i=0;i<j;i++){
     indice = (int)Math.floor(Math.random() * (Max - Min + 1)) + Min;
         boolean encontrar=false;
      for(int k=0;k<i;k++){
          if(numRepetidos.get(k)==indice){
            encontrar=true;
          }
      }
      if(!encontrar){
        numRepetidos.add(indice);
        Proyectos.add(historicos[indice]);
      }else{
        i--;
      }
    } 
    /*int i=0;
    for(String o: Proyectos){
      System.out.println((i+1)+")"+o);
      i++;
     }*/
  }
  
  public void asignarProyectos2(){
    String aux=null,aux2=null;
    Registros();
    for(int i=0;i<numTrabajadores;i++){
      for(int j=0;j<Proyectos.size();j++){
        aux=Proyectos.get(j);
        if(aux2==null){
          aux2=aux;
        }else{
          aux2=aux2+","+aux;
        }
      }  
    Registros();
    proyectosTrabajadores.add(aux2);
    aux2=null;
    }
    int i=0;
    for(String o: proyectosTrabajadores){
      System.out.println((i+1)+")"+o);
      i++;
     }
  }
  



  

} 


