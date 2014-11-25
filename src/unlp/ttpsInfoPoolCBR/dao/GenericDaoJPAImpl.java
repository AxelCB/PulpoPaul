package unlp.ttpsInfoPoolCBR.dao;

import unlp.ttpsInfoPoolCBR.model.AbstractEntity;
import unlp.ttpsInfoPoolCBR.util.EntityManagerFactoryHolder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axel on 22/11/2014.
 */
public class GenericDaoJPAImpl<M extends AbstractEntity,VO extends AbstractEntity> implements IGenericDao<M,VO>{

    //Esto sería inyectado a través de spring, cuando lo empecemos a usar
//    protected EntityManagerFactoryHolder EntityManagerFactoryHolder;

    protected Class<M> persistentClass;
    protected Class<VO> voClass;

    public GenericDaoJPAImpl(Class<M> persistentClass, Class<VO> voClass) {
        this.persistentClass = persistentClass;
        this.voClass = voClass;

        //Esto sería inyectado a través de spring, cuando lo empecemos a usar
//        EntityManagerFactoryHolder= new EntityManagerFactoryHolder();
//        EntityManagerFactoryHolder.init();
    }

    @Override
    public VO guardar(VO objetoVO) throws Exception {
        EntityManager em = null;
        try{
            em = EntityManagerFactoryHolder.getEntityManager();
            EntityManagerFactoryHolder.beginTransaction(em);

            objetoVO = em.merge(objetoVO);

            EntityManagerFactoryHolder.commitTransaction(em);

        }catch(Exception ex){
            EntityManagerFactoryHolder.rollbackTransaction(em);
            throw ex;
        }
        return objetoVO;
    }

    @Override
    public VO modificar(VO objetoVO) throws Exception {
        EntityManager em = null;
        try{
            em = EntityManagerFactoryHolder.getEntityManager();
            EntityManagerFactoryHolder.beginTransaction(em);

            objetoVO = em.merge(objetoVO);

            EntityManagerFactoryHolder.commitTransaction(em);

        }catch(Exception ex){
            EntityManagerFactoryHolder.rollbackTransaction(em);
            throw ex;

        }
        return objetoVO;
    }

    @Override
    public void borrar(VO objetoVO) throws Exception {
        EntityManager em = null;
        try{
            em = EntityManagerFactoryHolder.getEntityManager();
            EntityManagerFactoryHolder.beginTransaction(em);

            em.remove(objetoVO);

            EntityManagerFactoryHolder.commitTransaction(em);

        }catch(Exception ex){
            EntityManagerFactoryHolder.rollbackTransaction(em);
            throw ex;

        }
    }

    @Override
    public List<VO> listar() throws Exception {
        EntityManager em = null;
        List<VO> listaVO = new ArrayList<VO>();
        try{
            em = EntityManagerFactoryHolder.getEntityManager();
            Query jpaql = em.createQuery("select o from "+ persistentClass.getSimpleName() +" o");
            listaVO = (List<VO>)jpaql.getResultList();

        }catch(Exception ex){
            throw ex;

        }
        return listaVO;
    }

    @Override
    public VO encontrar(Integer id) throws Exception {
        EntityManager em = null;
        VO objetoVO;
        try{
            em = EntityManagerFactoryHolder.getEntityManager();
            objetoVO  = em.find(voClass,id);

        }catch(Exception ex){
            throw ex;
        }
        return objetoVO;
    }
}
