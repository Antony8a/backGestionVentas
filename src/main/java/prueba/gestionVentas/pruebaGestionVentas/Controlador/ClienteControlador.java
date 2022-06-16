package prueba.gestionVentas.pruebaGestionVentas.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import prueba.gestionVentas.pruebaGestionVentas.Excepciones.ResourseNotFoundException;
import prueba.gestionVentas.pruebaGestionVentas.Repositorio.ClienteRepositorio;
import prueba.gestionVentas.pruebaGestionVentas.models.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControlador {
	@Autowired
	private ClienteRepositorio repositorio;

	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
		return repositorio.findAll();
	}
	
	@PostMapping("/clientes")
	public Cliente guardar(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}
	
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable String id){
			Cliente cliente = repositorio.findById(id)
					            .orElseThrow(() -> new ResourseNotFoundException("No existe el cliente con el ID : " + id));
			return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarCliente(@PathVariable String id){
		Cliente cliente = repositorio.findById(id)
				            .orElseThrow(() -> new ResourseNotFoundException("No existe el cliente con el ID : " + id));
		
		repositorio.delete(cliente);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> actualizarEmpleado(@PathVariable String id,@RequestBody Cliente detallesCliente){
		Cliente cliente = repositorio.findById(id)
				            .orElseThrow(() -> new ResourseNotFoundException("No existe el cliente con el ID : " + id));
		
		cliente.setNombres(detallesCliente.getNombres());
		cliente.setApellidos(detallesCliente.getApellidos());
		cliente.setCorreo(detallesCliente.getCorreo());
		cliente.setDireccion(detallesCliente.getDireccion());
		cliente.setTelefono(detallesCliente.getTelefono());
		
		Cliente clienteActualizado = repositorio.save(cliente);
		return ResponseEntity.ok(clienteActualizado);
    }
	
}
