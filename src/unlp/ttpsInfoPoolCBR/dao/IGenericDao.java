package unlp.ttpsInfoPoolCBR.dao;

import java.util.List;

import unlp.ttpsInfoPoolCBR.model.AbstractEntity;
import unlp.ttpsInfoPoolCBR.vo.AbstractVo;

/**
 * Created by Axel on 22/11/2014.
 */
public interface IGenericDao<M extends AbstractEntity,VO extends AbstractVo> {

    public VO guardar(VO objetoVO)throws Exception;
    public VO modificar(VO objetoVO)throws Exception;
    public void borrar(Integer idObjetoVO) throws Exception;

    public List<VO> listar()throws Exception;
    public VO encontrar(Integer id) throws Exception;
    
    public void drop()throws Exception;
}
