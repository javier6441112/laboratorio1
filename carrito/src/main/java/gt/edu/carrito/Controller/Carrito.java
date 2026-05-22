package gt.edu.carrito.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.carrito.Dto.ProductoDto;
import gt.edu.carrito.Services.CarritoService;

@CrossOrigin(origins = "*")
@RestController
public class Carrito {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/")
    public String inicio() {
        return "Bienvenido al carrito de compras. Accede a /carrito/getCarrito o /carrito/agregarProducto";
    }

    @GetMapping("/carrito/getCarrito")
    public List<ProductoDto> getCarrito() {
        return carritoService.getCarrito();
    }

    @PostMapping("/carrito/agregarProducto")
    public ProductoDto agregarProducto(@RequestBody ProductoDto productoDto) {
        return carritoService.guardarProducto(productoDto);
    }
}
