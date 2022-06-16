
package prueba.gestionVentas.pruebaGestionVentas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
    private String identificacion;
    
    @Column(name="nombres",length = 60, nullable = false)
    private String nombres;
    
    @Column(name="apellidos",length = 60, nullable = false)
    private String apellidos;
    
    @Column(name="correo",length = 30, nullable = false)
    private String correo;
    
    @Column(name="direccion",length = 40, nullable = false)
    private String direccion;
    
    @Column(name="telefono",length = 13, nullable = false)
    private String telefono;

    public Cliente() {
    }

    public Cliente(String identificacion, String nombres, String apellidos, String correo, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getId() {
        return identificacion;
    }

    public void setId(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
