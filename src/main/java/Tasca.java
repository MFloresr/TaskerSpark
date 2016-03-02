/**
 * Created by Vipi on 02/03/2016.
 */
public class Tasca {
    String tarea;
    boolean marcado = false;

    public Tasca (String tarea) {
        this.tarea = tarea;
    }

    public String getTarea() {
        return tarea;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }
}
