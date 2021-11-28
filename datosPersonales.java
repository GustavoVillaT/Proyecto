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
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
public class datosPersonales{


private int numTrabajadores=20;//numero de trabajadores
private ArrayList<Integer> edadTrabajador = new ArrayList<Integer>();
private ArrayList<String> nombreTrabajador = new ArrayList<String>();
private ArrayList<String> aPaternoTrabajador = new ArrayList<String>();
private ArrayList<String> aMaternoTrabajador = new ArrayList<String>();
private ArrayList<String> direccionTrabajador = new ArrayList<String>();
/**
*Constructor
*/
public datosPersonales(){}






public void asignarDatos(){
String[] nombresAleatorios = {"Marisol", "Rodrigo", "Anastasio", "Annie","Jose","Marco","Pedro","Luis","Marta","Frida","Francisco", "Ramon","Lorena","Matias","Jordan","Sergio","Saul","Samantha","Miguel","Martin","Antonela","Federico","Angel","Clara","Daniela", "Jesica", "Enrique", "Mateo", "Leonardo", "Rafael","Adrián", "Sofia","Luis","Enrique","Bastian","Sebastian","Gabriel","Alejandro", "Nepamuceno", "Roque", "Grasiela"};
String[] apellidosAleatorios={"Villa","Rodríguez", "Martínez", "Hernández", "López", "González", "Pérez","Sánchez", "Ramírez", "Torres", "Flores", "Rivera","Gómez", "Díaz", "Reyes", "Cruz", "Morales", "Ortiz", "Gutiérrez","Smith","Johnson", "Williams", "Morrissey", "Hazel", "West", "Yañes", "Rourke", "Joyce", "Brown", "Jones", "Miller", "Davis", "Byrne", "Wilkins", "Michaels", "Anderson", "O'Brien", "Yorke", "Greenwood", "Jackson", "Quintero", "Weinstein", "Escañuela", "Vázquez", "Varela", "Skywalker", "García", "Rodríguez", "Wilson", "Spilberg", "Sumner", "Curtis", "Rosillo", "Stalin", "Mao", "Xu", "Rickles"};
int indice,indice2,indice3;
  int edadMinima = 18;
  int edadMaxima = 65;
for(int i=0;i<numTrabajadores;i++){
  indice=(int)Math.floor(Math.random()*(nombresAleatorios.length)); 
  indice2=(int)Math.floor(Math.random()*(nombresAleatorios.length));
  indice3=(int)Math.floor(Math.random()*(nombresAleatorios.length));
  edadTrabajador.add((int)Math.floor(Math.random()*(edadMaxima-edadMinima+1)+edadMinima));
  nombreTrabajador.add(nombresAleatorios[indice]);
  aPaternoTrabajador.add(apellidosAleatorios[indice2]);
  aMaternoTrabajador.add(apellidosAleatorios[indice3]);
}
/*    //imprimir datos
for(int i=0;i<numTrabajadores;i++){
  System.out.println("El trabajador "+nombreTrabajador.get(i)+" "+aPaternoTrabajador.get(i)+" "+aMaternoTrabajador.get(i)+" tiene una edad de "+edadTrabajador.get(i)+" años.");
}*/
}
public void Direcciones(){
    int count=0;
    ArrayList<String> alcaldia = new ArrayList<String>();
    ArrayList<String> codigopostal= new ArrayList<String>();
    ArrayList<String> colonia = new ArrayList<String>();
    ArrayList<String> calle = new ArrayList<String>();
    try{
      FileReader fr=new FileReader ("Basededatos.csv");
      BufferedReader br=new BufferedReader(fr);
      String linea=br.readLine();
      while(linea!=null){
        StringTokenizer separador =new StringTokenizer(linea,",");
        while(separador.hasMoreTokens()){  
          String aux=separador.nextToken();
          if(count==0){
            alcaldia.add(aux);
            count++;
          }else if(count==1){
            colonia.add(aux);
            count++;
          }else if(count==2){
            calle.add(aux);
            count++;
          }else if(count==3){
            codigopostal.add(aux);
            count=0;
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
    int index=0;
    for(int i=0;i<3;i++){
      String auxiliar="calle:"+calle.get(i)+" colonia:"+colonia.get(i)+" alcaldia:"+alcaldia.get(i)+" C.P:"+codigopostal.get(i);
      direccionTrabajador.add(auxiliar);
    }
    /*for(String o:direccionTrabajador)
      System.out.println(o);*/

}
public void Imprimir(){
  try{
  if(numTrabajadores==0){
    System.out.println("No hay trabajadores en la base de datos");
  }else{ 
  for(int i=0;i<numTrabajadores;i++){
  System.out.println((i+1)+") El trabajador "+nombreTrabajador.get(i)+" "+aPaternoTrabajador.get(i)+" "+aMaternoTrabajador.get(i)+" tiene una edad de "+edadTrabajador.get(i)+" años");
}}
}catch(IndexOutOfBoundsException ex){
  System.out.println("No hay un trabajador registrado en ese lugar");
}
}
public void borrar(){
  int x=0;
  Scanner sc = new Scanner(System.in);
   do {
      System.out.println("0-Salir 1-Borrar todos los trabajadores 2-Borrar intervalo de trabajadores 3-Borrar un trabajador");
    try {
      x = sc.nextInt();
      }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      sc.next();}
      switch(x){
        case 0:
          System.out.println("Saliendo....");
          break;
        case 1:
          System.out.println("Borrando....");
          nombreTrabajador.clear();
          aPaternoTrabajador.clear();
          aMaternoTrabajador.clear();
          edadTrabajador.clear();
          numTrabajadores=0;
          System.out.println("Imprimiendo los trabajadores....");
          Imprimir();
          break;
        case 2:
          System.out.println("Escriba el intervalo a borrar.");
          System.out.println("Escriba el inicio del intervalo");
          int inf=0;
          int sup=0;
           try {
            inf = sc.nextInt();
            System.out.println("Escriba el fin del intervalo");
            sup= sc.nextInt();
          }catch (InputMismatchException ex){
            System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
            sc.next();}
            System.out.println("Borrando....");
            for(int i=0;i<=(sup-inf);i++){
            nombreTrabajador.remove((inf-1));
            aPaternoTrabajador.remove((inf-1));
            aMaternoTrabajador.remove((inf-1));
            edadTrabajador.remove((inf-1));
            }
            numTrabajadores=numTrabajadores-(sup-inf)-1;
            System.out.println("Imprimiendo los trabajadores....");
            Imprimir();
          break;
        case 3:
            int numT=0;
            System.out.println("Numero del trabajador a borrar");
            try {
            numT = sc.nextInt();
            
          }catch (InputMismatchException ex){
            System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
            sc.next();}
           System.out.println("Borrando....");
            nombreTrabajador.remove((numT-1));
            aPaternoTrabajador.remove((numT-1));
            aMaternoTrabajador.remove((numT-1));
            edadTrabajador.remove((numT-1));
            numTrabajadores--;
            Imprimir();
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
} while (x!=0);
}
public void modificar(){
  Scanner rt = new Scanner(System.in);
  Scanner xt = new Scanner(System.in);
  int trabajador=0;
  System.out.println("Que empleado desea modificar?");
   try {
      trabajador = rt.nextInt();
      }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
    System.out.println("El empleado numero: "+trabajador+" con nombre "+nombreTrabajador.get((trabajador-1))+" "+aPaternoTrabajador.get((trabajador-1))+" "+aMaternoTrabajador.get((trabajador-1))+" con "+edadTrabajador.get((trabajador-1))+" años");
      int numj=0;
      String nuevoNombre=null,nuevoApaterno=null,nuevoAmaterno=null;
      int nuevaEdad=0;
  do {
    System.out.println("0-Salir 1-Modifcar nombre 2-Modificar apellidoPaterno 3-Modificar apellidoMaterno 4-Modificar edad 5-Modificar direccion");
    try {
      numj = rt.nextInt();
      }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
      switch(numj){
        case 0:
          System.out.println("Saliendo....");
          break;
        case 1:
          System.out.println("Ingrese el nuevo nombre");
          nuevoNombre=xt.nextLine();
          nombreTrabajador.set((trabajador-1),nuevoNombre);
          break;
        case 2:
          System.out.println("Ingrese el nuevo apellido paterno");
          nuevoApaterno=xt.nextLine();
          aPaternoTrabajador.set((trabajador-1),nuevoApaterno);
          break;
        case 3:
         System.out.println("Ingrese el nuevo apellido materno");
         nuevoAmaterno=xt.nextLine();
         aMaternoTrabajador.set((trabajador-1),nuevoAmaterno);
          break;
        case 4:
          System.out.println("Ingrese la nueva edad");
        try {
      nuevaEdad = rt.nextInt();
      }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
      edadTrabajador.set((trabajador-1),nuevaEdad);
          break;
        case 5:
          System.out.println("No funciona actualmente xd");
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
} while(numj!=0);  
}

}

