package src;

import models.Producto;
import models.Usuario;
import services.ArchivoProductoService;
import services.ArchivoUsuarioService;
import utils.FakeGenerator;

import java.util.List;

public class Main {  // Cambiado a mayúscula
    public static void main(String[] args) {
        try {
            // Rutas de los archivos
            String rutaProductos = "resources/productos.txt";
            String rutaUsuarios = "resources/usuarios.txt";

            // Cargar productos desde el archivo
            List<Producto> productos = ArchivoProductoService.cargarProductos(rutaProductos);

            // Cargar usuarios desde el archivo
            List<Usuario> usuarios = ArchivoUsuarioService.cargarUsuarios(rutaUsuarios);

            // Generar datos de prueba si los archivos están vacíos
            if (productos == null || productos.isEmpty() || usuarios == null || usuarios.isEmpty()) {
                System.out.println("Generando datos de prueba...");
                FakeGenerator.generarDatosDePrueba(rutaProductos, rutaUsuarios);
                productos = ArchivoProductoService.cargarProductos(rutaProductos);
                usuarios = ArchivoUsuarioService.cargarUsuarios(rutaUsuarios);
            }

            // Mostrar datos cargados
            System.out.println("Productos cargados:");
            productos.forEach(System.out::println);

            System.out.println("\nUsuarios cargados:");
            usuarios.forEach(System.out::println);

            // Aquí puedes continuar con la lógica del menú principal
            System.out.println("\nSistema de gestión de inventario listo.");
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}