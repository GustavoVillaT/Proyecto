import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.InputMismatchException;
class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Proyecto");  
      datosPersonales tr1=new datosPersonales();
      tr1.asignarDatos();
      tr1.Direcciones();
      int x=1;
  do {
      System.out.println("0-Salir 1-Agregar 2-Leer 3-Modificar 4-Borrar");
    try {
      x = reader.nextInt();
      }catch (InputMismatchException ex){
      System.out.println("¡Cuidado! Solo puedes insertar números enteros. ");
      reader.next();}
      switch(x){
        case 0:
          System.out.println("Saliendo....");
          break;
        case 1:
        
          break;
        case 2:
          tr1.Imprimir();
          break;
        case 3:

          break;
        case 4:

          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
} while (x!=0);
    

     
      

    }


        
}
