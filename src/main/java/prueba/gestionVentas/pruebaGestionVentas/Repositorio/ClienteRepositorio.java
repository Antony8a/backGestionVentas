package prueba.gestionVentas.pruebaGestionVentas.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prueba.gestionVentas.pruebaGestionVentas.models.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,String> {
     
}
