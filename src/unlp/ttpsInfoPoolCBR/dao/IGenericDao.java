package unlp.ttpsInfoPoolCBR.dao;

import unlp.ttpsInfoPoolCBR.model.AbstractEntity;

import java.util.List;

/**
 * Created by Axel on 22/11/2014.
 */
public interface IGenericDao<M extends AbstractEntity,VO extends AbstractEntity> {

    public VO guardar(VO objetoVO)throws Exception;
    public VO modificar(VO objetoVO)throws Exception;
    public void borrar(VO objetoVO) throws Exception;

    public List<VO> listar()throws Exception;
    public VO encontrar(Integer id) throws Exception;
    
    public void drop()throws Exception;
}
