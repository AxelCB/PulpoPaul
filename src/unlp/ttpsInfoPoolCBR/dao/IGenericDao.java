package unlp.ttpsInfoPoolCBR.dao;

import java.util.List;

import javax.persistence.EntityManager;

import unlp.ttpsInfoPoolCBR.model.AbstractEntity;
import unlp.ttpsInfoPoolCBR.vo.AbstractVo;

/**
 * Created by Axel on 22/11/2014.
 */
public interface IGenericDao<M extends AbstractEntity,VO extends AbstractVo> {

    public VO guardar(EntityManager em,VO objetoVO)throws Exception;
    public VO modificar(EntityManager em,VO objetoVO)throws Exception;
    public void borrar(EntityManager em,Integer idObjetoVO) throws Exception;

    public List<VO> listar(EntityManager em)throws Exception;
    public List<VO> listarTodos(EntityManager em)throws Exception;
    public VO encontrar(EntityManager em,Integer id) throws Exception;
    
    public void drop(EntityManager em)throws Exception;
}
