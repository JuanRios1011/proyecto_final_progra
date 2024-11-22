package services;

import models.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoProductoService {

    // Guardar productos en un archivo de texto
    public static void guardarProductos(List<Producto> productos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Producto producto : productos) {
                writer.write(producto.getId() + "," +
                             producto.getNombre() + "," +
                             producto.getDescripcion() + "," +
                             producto.getPrecio() + "," +
                             producto.getCantidadEnStock());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar productos en el archivo: " + e.getMessage());
        }
    }

    // Leer productos desde un archivo de texto
    public static List<Producto> cargarProductos(String rutaArchivo) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String descripcion = partes[2];
                    double precio = Double.parseDouble(partes[3]);
                    int cantidadEnStock = Integer.parseInt(partes[4]);
                    productos.add(new Producto(id, nombre, descripcion, precio, cantidadEnStock));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar productos desde el archivo: " + e.getMessage());
        }
        return productos;
    }
}
