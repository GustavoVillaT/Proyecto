import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.InputMismatchException;
class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Proyecto");  
    String usuario=null,password=null;
    int x=0;
  while(x==0){
    Scanner xt = new Scanner(System.in);
    System.out.println("Ingrese su nombre de usuario: ");
    usuario=xt.nextLine();
      if(usuario.compareTo("RH")==0){
        while(x==0){
        System.out.println("Ingrese su contraseña");
        password=xt.nextLine();
        if(password.compareTo("1234")==0){
          x=1;
          System.out.println("Ingresando.....");
        }else{
           System.out.println("contraseña incorrecta");
        }}
      }else{
          System.out.println("usuario incorrecto");
      }
      }
      datosPersonales tr1=new datosPersonales();
      tr1.asignarDatos();
      tr1.Direcciones();

  do {
      System.out.println("0-Salir 1-Agregar 2-Leer 3-Modificar 4-Borrar ");
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
          tr1.Agregar();
          break;
        case 2:
          tr1.Imprimir();
          break;
        case 3:
          tr1.modificar();
          break;
        case 4:
          tr1.borrar();
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
} while (x!=0);
    

     
      

    }


        
}
