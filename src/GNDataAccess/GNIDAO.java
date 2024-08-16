package GNDataAccess;

import java.util.List;

public interface GNIDAO<T> {
    
    public boolean create(T entity)      throws Exception;
    public List<T> readAll()             throws Exception;
    public boolean update(T entity)      throws Exception;
    public boolean delete(int id)        throws Exception;
    
    public T readBy(Integer id)          throws Exception;  // para leer los datos de cada tabla de acuerdo al id 
    //public Integer getMaxRow()         throws Exception;   para ver el maximo de registros 
}
