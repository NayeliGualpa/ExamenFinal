import GNDataAccess.GNHormigaDAO;
import GNDataAccess.GNDTO.GNHormigaDTO;
import GNUserInterface.GNForm.GNMainForm;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            GNHormigaDAO hDao = new GNHormigaDAO();
            for (GNHormigaDTO s : hDao.readAll())
               System.out.println(s.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
        }


      
   
        // Llamar al método main de la clase MainWindow para iniciar la aplicación
        GNMainForm.main(args);

    
      
}
}
