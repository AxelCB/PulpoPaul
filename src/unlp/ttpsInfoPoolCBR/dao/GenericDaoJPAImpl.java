package unlp.ttpsInfoPoolCBR.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import unlp.ttpsInfoPoolCBR.model.AbstractEntity;
import unlp.ttpsInfoPoolCBR.util.MapperUtils;
import unlp.ttpsInfoPoolCBR.vo.AbstractVo;

/**
 * Created by Axel on 22/11/2014.
 */
public class GenericDaoJPAImpl<M extends AbstractEntity,VO extends AbstractVo> implements IGenericDao<M,VO>{

//    @PersistenceContext
//    private EntityManager em;

    protected Class<M> persistentClass;
    protected Class<VO> voClass;

    public GenericDaoJPAImpl(Class<M> persistentClass, Class<VO> voClass) {
        this.persistentClass = persistentClass;
        this.voClass = voClass;
    }

//    protected EntityManager getEm() {
// 
//        return em;
//    }
//
//    protected void setEm(EntityManager em) {
//        this.em = em;
//    }

    @Override
//    @Transactional
    public VO guardar(EntityManager em,VO objetoVO) throws Exception {
        try{
        	M objeto = MapperUtils.map(objetoVO, this.getPersistentClass());
            objeto = em.merge(objeto);
            objetoVO = MapperUtils.map(objeto,this.getVoClass());
        }catch(Exception ex){
            throw ex;
        }
        return objetoVO;
    }

    @Override
//    @Transactional
    public VO modificar(EntityManager em,VO objetoVO) throws Exception {
        try{
        	M objeto = MapperUtils.map(objetoVO, this.getPersistentClass());
            objeto = em.merge(objeto);
            objetoVO = MapperUtils.map(objeto,this.getVoClass());
        }catch(Exception ex){
            throw ex;
        }
        return objetoVO;
    }

    @Override
    @Transactional
    public void borrar(EntityManager em,Integer idObjetoVO) throws Exception {
        try{
            M objetoM = em.find(persistentClass,idObjetoVO);
            if(!objetoM.equals(null)){
                em.remove(objetoM);
            }
        }catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public List<VO> listar(EntityManager em) throws Exception {
        List<M> listaM = new ArrayList<M>();
        try{
            TypedQuery<M> jpaql = em.createQuery("select o from " + persistentClass.getSimpleName() + " o",persistentClass);
            listaM = jpaql.getResultList();
            return MapperUtils.map(listaM, this.getVoClass());
        }catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public VO encontrar(EntityManager em,Integer id) throws Exception {
        VO objetoVO;
        try{
        	M objeto = em.find(this.getPersistentClass(),id);
            objetoVO = MapperUtils.map(objeto, this.getVoClass()); 
        }catch(Exception ex){
            throw ex;
        }
        return objetoVO;
    }

	@Override
//    @Transactional
	public void drop(EntityManager em) throws Exception {
        List<M> listaM = new ArrayList<M>();
        try{
        	
            TypedQuery<M> jpaql = em.createQuery("select o from " + persistentClass.getSimpleName() + " o",persistentClass);
            listaM = jpaql.getResultList();
            
            for(int i = 0; i < listaM.size(); i++){
                em.remove(listaM.get(i));
            }
        }catch(Exception ex){
            throw ex;
        }
        
	}

	public Class<M> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<M> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Class<VO> getVoClass() {
		return voClass;
	}

	public void setVoClass(Class<VO> voClass) {
		this.voClass = voClass;
	}
	
}
