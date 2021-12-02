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
public class trabajadores{
  
  private int numTrabajadores=30;//numero de trabajadores
  private ArrayList<Integer> edadTrabajador = new ArrayList<Integer>();
  private ArrayList<String> nombreTrabajador = new ArrayList<String>();
  private ArrayList<String> aPaternoTrabajador = new ArrayList<String>();
  private ArrayList<String> aMaternoTrabajador = new ArrayList<String>();
  private ArrayList<String> direccionTrabajador = new ArrayList<String>();
  private ArrayList<String> alcaldia = new ArrayList<String>();
  private ArrayList<Integer> codigopostal= new ArrayList<Integer>();
  private ArrayList<String> colonia = new ArrayList<String>();
  private ArrayList<String> calle = new ArrayList<String>();

  //constructor
  public trabajadores(){}

  //metodos
  public void generadorRegistros(){
    String[] nombresAleatorios = {"Marisol", "Rodrigo", "Anastasio", "Annie","Jose","Marco","Pedro","Luis","Marta","Frida","Francisco", "Ramon","Lorena","Matias","Jordan","Sergio","Saul","Samantha","Miguel","Martin","Antonela","Federico","Angel","Clara","Daniela", "Jesica", "Enrique", "Mateo", "Leonardo", "Rafael","Adrián", "Sofia","Luis","Enrique","Bastian","Sebastian","Gabriel","Alejandro", "Nepamuceno", "Roque", "Grasiela","Kytzia"};
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
    int count=0;

    try{
      FileReader fr=new FileReader ("Basededatos.csv");
      BufferedReader br=new BufferedReader(fr);
      String linea=br.readLine();
      int x=0;
      if(numTrabajadores<300){
        for(int i=0;i<numTrabajadores;i++){
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
              codigopostal.add(Integer.parseInt(aux));
              count=0;
            }  
          }
          linea=br.readLine();
        }
      }else{
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
              codigopostal.add(Integer.parseInt(aux));
              count=0;
            }  
          }
          linea=br.readLine();
        }
      }     
    br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
    for(int i=0;i<numTrabajadores;i++){
      String auxiliar="Calle:"+calle.get(i)+" Colonia:"+colonia.get(i)+" Alcaldia:"+alcaldia.get(i)+" C.P:"+codigopostal.get(i);
      direccionTrabajador.add(auxiliar);
    }

    String aux2=null;
    int random=0;
    if(numTrabajadores>300){
      for(int i=300;i<numTrabajadores;i++){
        random=(int)Math.floor(Math.random()*(300));
        aux2=direccionTrabajador.get(random);
        direccionTrabajador.add(aux2);
      }
    }
    Actualizar();
    System.out.println("¡Datos generados!");
    /*int i=0; //imprimir las direcciones
    for(String o:direccionTrabajador){
      System.out.println((i+1)+")"+o);
      i++;
    }*/
  }
  public void Actualizar(){
    try{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      FileWriter fw=new FileWriter("datos.csv");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter salida= new PrintWriter(bw);
      for(int i=0;i<numTrabajadores;i++){
        salida.println((i+1)+","+nombreTrabajador.get(i)+","+aPaternoTrabajador.get(i)+","+aMaternoTrabajador.get(i)+","+edadTrabajador.get(i)+","+direccionTrabajador.get(i));
      }
      salida.close();
    }catch(IOException ex){
    System.out.println(ex.getMessage());
    }
  }
  

  public void Agregar(){
    Scanner rt = new Scanner(System.in);
    Scanner xt = new Scanner(System.in);
    String auxiliar=null;
    int auxiliar2=0;
    System.out.println("Agregue los datos del nuevo empleado");
    System.out.println("nombre: ");
    auxiliar=xt.nextLine();
    nombreTrabajador.add(auxiliar);
    System.out.println("Apellido paterno: ");
    auxiliar=xt.nextLine();
    aPaternoTrabajador.add(auxiliar);
    System.out.println("Apellido Materno: ");
    auxiliar=xt.nextLine();
    aMaternoTrabajador.add(auxiliar);
    System.out.println("edad: ");   //Edad debe ser mayor a 18 crear restriccion
    try {
      auxiliar2 = rt.nextInt();
    }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
    edadTrabajador.add(auxiliar2);
    System.out.println("Direccion:");
    System.out.println("Ingresa la calle: ");
    auxiliar=xt.nextLine();
    calle.add(auxiliar);
    System.out.println("Ingresa la colonia: ");
    auxiliar=xt.nextLine();
    colonia.add(auxiliar);
    System.out.println("Ingresa la alcaldia: ");
    auxiliar=xt.nextLine();
    alcaldia.add(auxiliar);
    System.out.println("Ingresa el codigo postal: ");
    try {
      auxiliar2 = rt.nextInt();
    }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();}
    codigopostal.add(auxiliar2);
    auxiliar="Calle:"+calle.get(numTrabajadores)+" Colonia:"+colonia.get(numTrabajadores)+" Alcaldia:"+alcaldia.get(numTrabajadores)+" C.P:"+codigopostal.get(numTrabajadores);
    numTrabajadores++;
    System.out.println(auxiliar);
    direccionTrabajador.add(auxiliar);
    Actualizar();
    System.out.println("¡Datos actualizados!");
  }
  public void Imprimir(){
    try{
      if(numTrabajadores==0){
        System.out.println("No hay trabajadores en la base de datos");
      }else{
        for(int i=0;i<numTrabajadores;i++){
          System.out.println("------------------------------------------------------------------------------------------------------");
          System.out.println((i+1)+") El trabajador "+nombreTrabajador.get(i)+" "+aPaternoTrabajador.get(i)+" "+aMaternoTrabajador.get(i)+" tiene una edad de "+edadTrabajador.get(i)+" años"+"\nY su dirección es: "+direccionTrabajador.get(i));
        }
        System.out.println("------------------------------------------------------------------------------------------------------");      
      }
      Actualizar();
    }catch(IndexOutOfBoundsException ex){
      System.out.println("No hay un trabajador registrado en ese lugar");
    }
  }
  public void Modificar(){
    Scanner rt = new Scanner(System.in);
    Scanner xt = new Scanner(System.in);
    int trabajador=0;
    System.out.println("Que empleado desea modificar?");
    try {
      trabajador = rt.nextInt();
    }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      rt.next();
    }
    System.out.println("El empleado numero: "+trabajador+" con nombre "+nombreTrabajador.get((trabajador-1))+" "+aPaternoTrabajador.get((trabajador-1))+" "+aMaternoTrabajador.get((trabajador-1))+" con "+edadTrabajador.get((trabajador-1))+" años"+"\n Y dirección: "+direccionTrabajador.get(trabajador-1));
    int numj=0;

    String nuevoNombre=null,nuevoApaterno=null,nuevoAmaterno=null,pivote=null;;
    int pivote2=0;
    do{
      if(numj!=0){
        System.out.println("¡Dato actualizado!");
      }
      System.out.println("0-Salir 1-Modifcar nombre 2-Modificar apellidoPaterno 3-Modificar apellidoMaterno 4-Modificar edad 5-Modificar direccion");
      try {
        numj = rt.nextInt();
      }catch (InputMismatchException ex){
        System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
        rt.next();
      }
      switch(numj){
        case 0:
          System.out.println("Saliendo....");
        break;
        case 1:
          System.out.println("Ingrese el nuevo nombre: ");
          nuevoNombre=xt.nextLine();
          nombreTrabajador.set((trabajador-1),nuevoNombre);
          Actualizar();
        break;
        case 2:
          System.out.println("Ingrese el nuevo apellido paterno: ");
          nuevoApaterno=xt.nextLine();
          aPaternoTrabajador.set((trabajador-1),nuevoApaterno);
          Actualizar();
        break;
        case 3:
          System.out.println("Ingrese el nuevo apellido materno: ");
          nuevoAmaterno=xt.nextLine();
          aMaternoTrabajador.set((trabajador-1),nuevoAmaterno);
          Actualizar();
        break;
        case 4:
          System.out.println("Ingrese la nueva edad: ");
        try {
          pivote2 = rt.nextInt();
        }catch (InputMismatchException ex){
          System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
          rt.next();
        }
          edadTrabajador.set((trabajador-1),pivote2);
          Actualizar();
        break;
        case 5:
          System.out.println("¿Que desea modificar?");
          System.out.println("0-Salir 1-Modificar calle 2-Modificar colonia 3-Modificar alcaldia 4-Modificar codigo postal");
        try {
          numj = rt.nextInt();
        }catch (InputMismatchException ex){
          System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
          rt.next();
        }
          switch(numj){
            case 0:
              System.out.println("Saliendo....");
            break;
            case 1:
              System.out.println("Ingrese la nueva calle: ");
              pivote=xt.nextLine();
              calle.set((trabajador-1),pivote);
              pivote="Calle:"+calle.get(trabajador-1)+" Colonia:"+colonia.get(trabajador-1)+" Alcaldia:"+alcaldia.get(trabajador-1)+" C.P:"+codigopostal.get(trabajador-1);
              direccionTrabajador.set((trabajador-1),pivote);
              Actualizar();
              pivote=null;
            break;
            case 2:
               System.out.println("Ingrese la nueva colonia: ");
              pivote=xt.nextLine();
              colonia.set((trabajador-1),pivote);
              pivote="Calle:"+calle.get(trabajador-1)+" Colonia:"+colonia.get(trabajador-1)+" Alcaldia:"+alcaldia.get(trabajador-1)+" C.P:"+codigopostal.get(trabajador-1);
              direccionTrabajador.set((trabajador-1),pivote);
              Actualizar();
              pivote=null;
            break;
            case 3:
               System.out.println("Ingrese la nueva alcadia: ");
              pivote=xt.nextLine();
              alcaldia.set((trabajador-1),pivote);
              pivote="Calle:"+calle.get(trabajador-1)+" Colonia:"+colonia.get(trabajador-1)+" Alcaldia:"+alcaldia.get(trabajador-1)+" C.P:"+codigopostal.get(trabajador-1);
              direccionTrabajador.set((trabajador-1),pivote);
              Actualizar();
              pivote=null;
            break;
            case 4:
               System.out.println("Ingrese el nuevo codigo postal: ");
              try {
                pivote2 = rt.nextInt();
              }catch (InputMismatchException ex){
              System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
              rt.next();
              }
              codigopostal.set((trabajador-1),pivote2);
              pivote="Calle:"+calle.get(trabajador-1)+" Colonia:"+colonia.get(trabajador-1)+" Alcaldia:"+alcaldia.get(trabajador-1)+" C.P:"+codigopostal.get(trabajador-1);
              direccionTrabajador.set((trabajador-1),pivote);
              Actualizar();
              pivote=null;
              pivote2=0;
            break;
            default:
              System.out.println("Opcion no valida");
            break;
          }
        
      }
    }while(numj!=0); 
  }
  public void Borrar(){
    int x=0;
    Scanner sc = new Scanner(System.in);
    do {
      if(x!=0){
        System.out.println("¡Datos actualizados!");
      }
      System.out.println("0-Salir 1-Borrar todos los trabajadores 2-Borrar intervalo de trabajadores 3-Borrar un trabajador");
      try {
        x = sc.nextInt();
      }catch (InputMismatchException ex){
        System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
        sc.next();
      }
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
          direccionTrabajador.clear();
          alcaldia.clear();
          codigopostal.clear();
          colonia.clear();
          calle.clear();
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
            sc.next();
          }
          System.out.println("Borrando....");
          for(int i=0;i<=(sup-inf);i++){
            nombreTrabajador.remove((inf-1));
            aPaternoTrabajador.remove((inf-1));
            aMaternoTrabajador.remove((inf-1));
            edadTrabajador.remove((inf-1));
            direccionTrabajador.remove((inf-1));
            alcaldia.remove((inf-1));
            codigopostal.remove((inf-1));
            colonia.remove((inf-1));
            calle.remove((inf-1));
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
            sc.next();
          }
          System.out.println("Borrando....");
          nombreTrabajador.remove((numT-1));
          aPaternoTrabajador.remove((numT-1));
          aMaternoTrabajador.remove((numT-1));
          edadTrabajador.remove((numT-1));
          direccionTrabajador.remove((numT-1));
          alcaldia.remove((numT-1));
          codigopostal.remove((numT-1));
          colonia.remove((numT-1));
          calle.remove((numT-1));
          numTrabajadores--;
          Imprimir();
        break;
        default:
          System.out.println("Opcion no valida");
        break;
      }
    } while (x!=0);
  }
}