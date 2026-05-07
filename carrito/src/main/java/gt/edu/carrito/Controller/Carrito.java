package gt.edu.carrito.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.carrito.Dto.ProductoDto;
import gt.edu.carrito.Services.CarritoService;

@RestController
@RequestMapping("/carrito")
public class Carrito {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/getCarrito")
    public List<ProductoDto> getCarrito() {
        return carritoService.getCarrito();
    }

    @PostMapping("/agregarProducto")
    public ProductoDto agregarProducto(@RequestBody ProductoDto productoDto) {
        return carritoService.guardarProducto(productoDto);
    }
}
