package unlp.ttpsInfoPoolCBR.dao;

import unlp.ttpsInfoPoolCBR.model.AbstractEntity;
import unlp.ttpsInfoPoolCBR.utils.EntityManagerFactoryHolder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axel on 22/11/2014.
 */
public class GenericDaoJPAImpl<M extends AbstractEntity,VO extends AbstractEntity> implements IGenericDao<M,VO>{

    protected EntityManagerFactoryHolder emfh;

    protected Class<M> persistentClass;
    protected Class<VO> voClass;

    public GenericDaoJPAImpl(Class<M> persistentClass, Class<VO> voClass) {
        this.persistentClass = persistentClass;
        this.voClass = voClass;
        emfh= new EntityManagerFactoryHolder();
        emfh.init();
    }

    @Override
    public VO guardar(VO objetoVO) throws Exception {
        EntityManager em = null;
        try{
            em = emfh.getEntityManager();
            emfh.beginTransaction(em);

            objetoVO = em.merge(objetoVO);

            emfh.commitTransaction(em);

        }catch(Exception ex){
            emfh.rollbackTransaction(em);
            throw ex;

        }finally {
            em.close();
        }
        return objetoVO;
    }

    @Override
    public VO modificar(VO objetoVO) throws Exception {
        return null;
    }

    @Override
    public void borrar(VO objetoVO) throws Exception {

    }

    @Override
    public List<VO> listar() throws Exception {
        EntityManager em = null;
        List<VO> listaVO = new ArrayList<VO>();
        try{
            em = emfh.getEntityManager();
            Query jpaql = em.createQuery("select m from"+voClass.getCanonicalName());
            listaVO = (List<VO>)jpaql.getResultList();

        }catch(Exception ex){
            throw ex;

        }finally {
            em.close();
        }
        return listaVO;
    }
}
