package utils;

import com.github.javafaker.Faker;
import models.Producto;
import models.Usuario;
import services.ArchivoProductoService;
import services.ArchivoUsuarioService;

import java.util.ArrayList;
import java.util.List;

public class FakeGenerator {

    public static void generarDatosDePrueba(String rutaProductos, String rutaUsuarios) {
        Faker faker = new Faker();

        // Generar productos
        List<Producto> productos = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            productos.add(new Producto(
                    i,
                    faker.commerce().productName(),
                    faker.lorem().sentence(5),
                    Double.parseDouble(faker.commerce().price()),
                    faker.number().numberBetween(10, 100)
            ));
        }
        ArchivoProductoService.guardarProductos(productos, rutaProductos);

        // Generar usuarios
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "admin123", Usuario.Rol.ADMINISTRADOR)); // Usuario administrador por defecto
        for (int i = 1; i <= 10; i++) {
            usuarios.add(new Usuario(
                    faker.name().username(),
                    faker.internet().password(8, 12),
                    Usuario.Rol.VENDEDOR // Todos serán vendedores por defecto
            ));
        }
        ArchivoUsuarioService.guardarUsuarios(usuarios, rutaUsuarios);
    }
}
