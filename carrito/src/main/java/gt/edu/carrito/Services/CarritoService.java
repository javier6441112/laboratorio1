package gt.edu.carrito.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gt.edu.carrito.Dto.ProductoDto;
import gt.edu.carrito.Modelos.ProductoModelo;
import gt.edu.carrito.Repository.ProductoRepository;

@Service
public class CarritoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoDto> getCarrito() {
        // Obtener todos los productos del repositorio
        List<ProductoModelo> productoModelos = productoRepository.findAll();
        List<ProductoDto> productoDtos = productoModelos.stream()
                .map(producto -> new ProductoDto(
                        producto.getIdProducto(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getStock()))
                .toList();

        return productoDtos;
    }
}