package net.codejava.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.Entidad.VistaCatalogo;

public interface RepositorioVistaCatalogo extends CrudRepository<VistaCatalogo, Integer>{
	
	Iterable<VistaCatalogo> findByOrderByIdinventarioAsc();
	Iterable<VistaCatalogo> findByOrderByIdinventarioDesc();
	
	Iterable<VistaCatalogo> findByOrderByExistenciasAsc();
	Iterable<VistaCatalogo> findByOrderByExistenciasDesc();
	
	
	Iterable<VistaCatalogo> findByOrderByPreciolistaAsc();
	Iterable<VistaCatalogo> findByOrderByPreciolistaDesc();
	
	Iterable<VistaCatalogo> findByOrderByMesesgarantiaAsc();
	Iterable<VistaCatalogo> findByOrderByMesesgarantiaDesc();
	
	Iterable<VistaCatalogo> findByOrderByNombremarcaAsc();
	Iterable<VistaCatalogo> findByOrderByNombremarcaDesc();
	
	Iterable<VistaCatalogo> findByTipodispositivoContainingOrNombremarcaContainingOrDescripcionContainingOrModeloContainingOrColorContainingOrderByPreciolistaAsc(String Busqueda1,String Busqueda2,String Busqueda3,String Busqueda4,String Busqueda5);
	Iterable<VistaCatalogo> findByTipodispositivoContainingOrNombremarcaContainingOrDescripcionContainingOrModeloContainingOrColorContainingOrderByPreciolistaDesc(String Busqueda1,String Busqueda2,String Busqueda3,String Busqueda4, String Busqueda5);
	/*
	@Query("SELECT * FROM vistacatalogo where nombremarca = :Nombremarca")
	Iterable<VistaCatalogo> findByNombremarca(@Param("Nombremarca") String Nombremarca);  
	*/
	
}
