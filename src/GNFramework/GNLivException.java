package GNFramework;



public class GNLivException  extends Exception{
    public GNLivException(String e, String clase , String metodo){
        //grabar el log
        System.out.println("[ERROR EN EL PROGRAMA PARA EL LOG]" + clase +"." + metodo + "." + e);
    }

    @Override
    public String getMessage(){
        return "No espie....";
    }

}
