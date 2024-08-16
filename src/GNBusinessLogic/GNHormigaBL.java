package GNBusinessLogic;

import java.util.List;

import GNDataAccess.GNHormigaDAO;
import GNDataAccess.GNDTO.GNHormigaDTO;

public class GNHormigaBL {
    private GNHormigaDTO hormiga;
    private GNHormigaDAO hDAO = new GNHormigaDAO();

    public GNHormigaBL (){}
    
    public List<GNHormigaDTO> getAll() throws Exception{
      List<GNHormigaDTO> lst = hDAO.readAll();
         for(GNHormigaDTO GNHormigaDTO : lst){
         GNHormigaDTO.setTipoHormiga(GNHormigaDTO.getTipoHormiga().toUpperCase());
         }
        return hDAO.readAll();
    }

    public GNHormigaDTO getByIdSexo(int IdHormiga) throws Exception{
        hormiga = hDAO.readBy(IdHormiga);
        return hormiga;
    }
    
    public boolean create(GNHormigaDTO gnHormigaDTO) throws Exception{
        return hDAO.create(gnHormigaDTO);
    }

    public boolean update(GNHormigaDTO gnHormigaDTO) throws Exception{
         return hDAO.update(gnHormigaDTO);
    }

    public boolean delete(int idHormiga) throws Exception{
        return hDAO.delete(idHormiga);
    }

    // public Integer getMaxRow() throws Exception{
    //     return hDAO.getMaxRow();
    // }
}
