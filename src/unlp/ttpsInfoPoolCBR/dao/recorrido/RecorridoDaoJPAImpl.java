package unlp.ttpsInfoPoolCBR.dao.recorrido;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Recorrido;

/**
 * Created by Axel on 23/11/2014.
 */
public class RecorridoDaoJPAImpl extends GenericDaoJPAImpl<Recorrido,Recorrido> implements IRecorridoDao {
    public RecorridoDaoJPAImpl() {
        super(Recorrido.class, Recorrido.class);
    }
    
    @Override
    public List<Recorrido> listarDisponibles() throws Exception {
        List<Recorrido> listaRecorrido = new ArrayList<Recorrido>();
        try{
            TypedQuery<Recorrido> jpaql = this.getEm().createQuery("select r from " + persistentClass.getSimpleName() + " r "
            		+ "WHERE r.lugares > ("
            			+ "SELECT count(*) FROM Recorrido rec "
            			+ "INNER JOIN rec.pasajeros " //Usuario_Recorrido_Viajo urv ON (rec.id = urv.recorrido_id)
            			+ "GROUP BY rec.id)",persistentClass);
            listaRecorrido = jpaql.getResultList();
        }catch(Exception ex){
            throw ex;
        }
        return listaRecorrido;
    }
    
}
