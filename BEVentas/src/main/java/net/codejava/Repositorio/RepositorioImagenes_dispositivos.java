package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Dispositivos_individuales;
import net.codejava.Entidad.Imagenes_dispositivos;

public interface RepositorioImagenes_dispositivos extends CrudRepository< Imagenes_dispositivos, Integer>{
	Iterable<Imagenes_dispositivos> findByidInventario(int id_inventario);
}
