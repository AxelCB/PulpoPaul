package unlp.ttpsInfoPoolCBR.dao.rol;


import java.util.List;

import javax.persistence.TypedQuery;

import unlp.ttpsInfoPoolCBR.dao.GenericDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Rol;
import unlp.ttpsInfoPoolCBR.util.MapperUtils;
import unlp.ttpsInfoPoolCBR.vo.RolVo;

/**
 * Created by Axel on 23/11/2014.
 */
public class RolDaoJPAImpl extends GenericDaoJPAImpl<Rol,RolVo> implements IRolDao {
    public RolDaoJPAImpl() {
        super(Rol.class, RolVo.class);
    }


    @Override
    public RolVo buscarPorNombre(String nombre) throws Exception {
        Rol rol = null;
        RolVo rolVo = null;
        try{
            TypedQuery<Rol> jpaql = this.getEm().createQuery("select r from Rol r where r.nombre = :nombre", Rol.class);
            jpaql.setParameter("nombre",nombre);
            
            List<Rol> listaRol = jpaql.getResultList();
            if(!listaRol.isEmpty()){
            	rol = listaRol.get(0);
            	rolVo = MapperUtils.map(rol, RolVo.class);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
        	this.getEm().close();
        }
        return rolVo;
    }
}
