package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Dispositivos_individuales;
import net.codejava.Entidad.Imagenes_dispositivos;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Imagenes_dispositivos permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */

public interface RepositorioImagenes_dispositivos extends CrudRepository< Imagenes_dispositivos, Integer>{
	Iterable<Imagenes_dispositivos> findByidInventario(int id_inventario);
}
