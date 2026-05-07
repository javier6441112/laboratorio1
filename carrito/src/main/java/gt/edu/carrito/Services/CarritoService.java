package gt.edu.carrito.Services;

import java.math.BigDecimal;
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

    public ProductoDto guardarProducto(ProductoDto productoDto) {
        // Crear un nuevo modelo de producto desde el DTO
        ProductoModelo productoModelo = new ProductoModelo();
        productoModelo.setNombre(productoDto.getNombre());
        productoModelo.setDescripcion(productoDto.getDescripcion());
        productoModelo.setPrecio(productoDto.getPrecio() != null ? productoDto.getPrecio() : BigDecimal.ZERO);
        productoModelo.setStock(productoDto.getStock() != null ? productoDto.getStock() : 0);

        // Guardar en la base de datos
        ProductoModelo productoGuardado = productoRepository.save(productoModelo);

        // Convertir el modelo guardado a DTO y retornarlo
        return new ProductoDto(
                productoGuardado.getIdProducto(),
                productoGuardado.getNombre(),
                productoGuardado.getDescripcion(),
                productoGuardado.getPrecio(),
                productoGuardado.getStock());
    }
}