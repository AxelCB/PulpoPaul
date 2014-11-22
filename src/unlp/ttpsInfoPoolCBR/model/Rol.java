package unlp.ttpsInfoPoolCBR.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by axel on 05/11/14.
 */
@Entity
@Table
public class Rol extends AbstractEntity{

//    private Long id;
    @Column
    private String nombre;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Rol)) return false;
//
//        Rol rol = (Rol) o;
//
//        if (id != null ? !id.equals(rol.id) : rol.id != null) return false;
//
//        return true;
//    }
}
