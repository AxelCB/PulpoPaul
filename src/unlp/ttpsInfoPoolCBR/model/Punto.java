package unlp.ttpsInfoPoolCBR.model;

/**
 * Created by axel on 05/11/14.
 */
public class Punto {

    private Long id;
    private String latitud;
    private String longitud;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Punto)) return false;

        Punto punto = (Punto) o;

        if (id != null ? !id.equals(punto.id) : punto.id != null) return false;

        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
