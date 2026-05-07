package gt.edu.carrito.Repository;

import gt.edu.carrito.Modelos.ProductoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModelo, Integer> {

    // Query nativa para buscar productos por nombre
    @Query(value = "select * from productos", nativeQuery = true)
    List<ProductoModelo> getAllProductos();


}
