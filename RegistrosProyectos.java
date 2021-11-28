public class RegistrosProyectos{
  /*“Modulo generador de registro de proyectos”. La empresa hasta este punto cuenta con 50
distintos proyectos (40 históricos y 10 vigentes).
a. Los trabajadores deben tener en su historial de registros proyectos que hayan
realizado (aleatoriamente de 0-50) el numero total de ellos y el nombre del proyecto.
b. Los trabajadores deben tener al menos 1 proyecto vigente y máximo 3.*/
private String[] historicos = {"humanidaria","caras Inocentes","apoyo comunitario","Conciencia Colectiva","Sembrando Oportunidades","ProAprende","Aprendizaje Dinamico","Agua y vida","Sovi","Hazlo Posible","ProTierra","Ecovida","Saber más","Ciencia T","Ecociencia","Mundo Tecnologico","Tecno","Cerebros Exploradores","cienbidura","viendo hacia el futuro","Ciclon","Durango","Luciernaga","Hercules","Jupiter","Laguna","Metro","Omega","Fenix","Langosta","preludio","Sputnik","Revolucion Tecnologica","Don Gato","Unidad","Conciencia","Nelson","Catarsis","Reconstruccion","Rosas"};
private String[] vigentes = {"Internacional","ONG","Progreso","Nuevo Rumbo","Mundo Educa","Escuela Global","Cometa","Flora","Fauna","Nuevo Amanecer"};



public RegistrosProyectos(){}
public void setHistoricos(String[] historicos){
  this.historicos = historicos;
}
public String[] getHistoricos(){

  return historicos;

}

public void setVigentes(String[] vigentes){
  this.vigentes = vigentes;
}

public String[] getVigentes(){
  return vigentes;
}/*
public String Registros{
  int j = 
  while(0<){

  }
}*/


}
