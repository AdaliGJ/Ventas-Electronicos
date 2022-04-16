package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Factura;

public interface RepositorioFactura extends CrudRepository< Factura, Integer> {

}
