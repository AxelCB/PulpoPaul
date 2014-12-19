package unlp.ttpsInfoPoolCBR.dao;

import org.springframework.transaction.annotation.Transactional;
import unlp.ttpsInfoPoolCBR.model.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axel on 22/11/2014.
 */
public class GenericDaoJPAImpl<M extends AbstractEntity,VO extends AbstractEntity> implements IGenericDao<M,VO>{

    @PersistenceContext
    private EntityManager em;

    protected Class<M> persistentClass;
    protected Class<VO> voClass;

    public GenericDaoJPAImpl(Class<M> persistentClass, Class<VO> voClass) {
        this.persistentClass = persistentClass;
        this.voClass = voClass;
    }

    protected EntityManager getEm() {
        return em;
    }

    protected void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public VO guardar(VO objetoVO) throws Exception {
        try{
            objetoVO = this.getEm().merge(objetoVO);
        }catch(Exception ex){
            throw ex;
        }
        return objetoVO;
    }

    @Override
    @Transactional
    public VO modificar(VO objetoVO) throws Exception {
        try{
            objetoVO = this.getEm().merge(objetoVO);
        }catch(Exception ex){
            throw ex;
        }
        return objetoVO;
    }

    @Override
    @Transactional
    public void borrar(Integer idObjetoVO) throws Exception {
        try{
            M objetoM = this.getEm().find(persistentClass,idObjetoVO);
            if(!objetoM.equals(null)){
                this.getEm().remove(objetoM);
            } 
        }catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public List<VO> listar() throws Exception {
        List<VO> listaVO = new ArrayList<VO>();
        try{
            TypedQuery jpaql = this.getEm().createQuery("select o from " + persistentClass.getSimpleName() + " o",persistentClass);
            listaVO = jpaql.getResultList();
        }catch(Exception ex){
            throw ex;
        }
        return listaVO;
    }

    @Override
    public VO encontrar(Integer id) throws Exception {
        VO objetoVO;
        try{
            objetoVO = this.getEm().find(voClass,id);
        }catch(Exception ex){
            throw ex;
        }
        return objetoVO;
    }

	@Override
    @Transactional
	public void drop() throws Exception {
        List<VO> listaVO = new ArrayList<VO>();
        try{
            TypedQuery jpaql = this.getEm().createQuery("select o from " + persistentClass.getSimpleName() + " o",persistentClass);
            listaVO = jpaql.getResultList();
            
            for(int i = 0; i < listaVO.size(); i++){
                this.getEm().remove(listaVO.get(i));
            }
        }catch(Exception ex){
            throw ex;
        }
        
	}
  
}
