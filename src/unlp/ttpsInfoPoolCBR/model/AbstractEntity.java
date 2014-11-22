package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Axel on 22/11/2014.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this!=null&&o!=null){
            if(this.getId().equals(((AbstractEntity)o).getId())){
                return true;
            }
        }
        return false;
    }


}
