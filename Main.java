import java.lang.String;
class Main {
  public static void main(String[] args) {
    System.out.println("Proyecto");  
    RegistrosProyectos juan = new RegistrosProyectos();
    recursosHumanos RH=new recursosHumanos();
    int x=0;
    x=RH.ingreso();
    RH.generadorRegistros();
    RH.funciones(x);
   //juan.asignarProyectos2();
     
    
  }
}

