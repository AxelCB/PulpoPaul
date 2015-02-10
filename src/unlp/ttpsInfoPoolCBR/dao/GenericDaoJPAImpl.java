package unlp.ttpsInfoPoolCBR.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import unlp.ttpsInfoPoolCBR.model.AbstractEntity;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;
import unlp.ttpsInfoPoolCBR.util.MapperUtils;
import unlp.ttpsInfoPoolCBR.vo.AbstractVo;

/**
 * Created by Axel on 22/11/2014.
 */
public class GenericDaoJPAImpl<M extends AbstractEntity,VO extends AbstractVo> implements IGenericDao<M,VO>{

//    @PersistenceContext
    private EntityManager em;

    protected Class<M> persistentClass;
    protected Class<VO> voClass;

    public GenericDaoJPAImpl(Class<M> persistentClass, Class<VO> voClass) {
        this.persistentClass = persistentClass;
        this.voClass = voClass;
    }

    protected EntityManager getEm() {
    	if(em==null){
    		em = EntityManagerFactoryHolder.getEntityManager();
    	}
        return em;
    }

    protected void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
//    @Transactional
    public VO guardar(VO objetoVO) throws Exception {
        try{
        	EntityManagerFactoryHolder.beginTransaction(this.getEm());
        	M objeto = MapperUtils.map(objetoVO, this.getPersistentClass());
            objeto = this.getEm().merge(objeto);
            objetoVO = MapperUtils.map(objeto,this.getVoClass());
            EntityManagerFactoryHolder.commitTransaction(this.getEm());
        }catch(Exception ex){
        	EntityManagerFactoryHolder.rollbackTransaction(this.getEm());
            throw ex;
        }finally{
//        	this.getEm().close();
        }
        return objetoVO;
    }

    @Override
    @Transactional
    public VO modificar(VO objetoVO) throws Exception {
        try{
        	EntityManagerFactoryHolder.beginTransaction(this.getEm());
        	M objeto = MapperUtils.map(objetoVO, this.getPersistentClass());
            objeto = this.getEm().merge(objeto);
            objetoVO = MapperUtils.map(objeto,this.getVoClass());
            EntityManagerFactoryHolder.commitTransaction(this.getEm());
        }catch(Exception ex){
        	EntityManagerFactoryHolder.rollbackTransaction(this.getEm());
            throw ex;
        }finally{
        	this.getEm().close();
        }
        return objetoVO;
    }

    @Override
    @Transactional
    public void borrar(Integer idObjetoVO) throws Exception {
        try{
        	EntityManagerFactoryHolder.beginTransaction(this.getEm());
            M objetoM = this.getEm().find(persistentClass,idObjetoVO);
            if(!objetoM.equals(null)){
                this.getEm().remove(objetoM);
            }
            EntityManagerFactoryHolder.commitTransaction(this.getEm());
        }catch(Exception ex){
        	EntityManagerFactoryHolder.rollbackTransaction(this.getEm());
            throw ex;
        }finally{
        	this.getEm().close();
        }
    }

    @Override
    public List<VO> listar() throws Exception {
        List<M> listaM = new ArrayList<M>();
        try{
            TypedQuery<M> jpaql = this.getEm().createQuery("select o from " + persistentClass.getSimpleName() + " o",persistentClass);
            listaM = jpaql.getResultList();
            return MapperUtils.map(listaM, this.getVoClass());
        }catch(Exception ex){
            throw ex;
        }finally{
        	this.getEm().close();
        }
    }

    @Override
    public VO encontrar(Integer id) throws Exception {
        VO objetoVO;
        try{
        	M objeto = this.getEm().find(this.getPersistentClass(),id);
            objetoVO = MapperUtils.map(objeto, this.getVoClass()); 
        }catch(Exception ex){
            throw ex;
        }finally{
        	this.getEm().close();
        }
        return objetoVO;
    }

	@Override
    @Transactional
	public void drop() throws Exception {
        List<M> listaM = new ArrayList<M>();
        try{
        	EntityManagerFactoryHolder.beginTransaction(this.getEm());
            TypedQuery<M> jpaql = this.getEm().createQuery("select o from " + persistentClass.getSimpleName() + " o",persistentClass);
            listaM = jpaql.getResultList();
            
            for(int i = 0; i < listaM.size(); i++){
                this.getEm().remove(listaM.get(i));
            }
            EntityManagerFactoryHolder.commitTransaction(this.getEm());
        }catch(Exception ex){
        	EntityManagerFactoryHolder.rollbackTransaction(this.getEm());
            throw ex;
        }finally{
        	this.getEm().close();
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
