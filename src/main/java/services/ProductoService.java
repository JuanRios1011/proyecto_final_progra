package services;

import models.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    public static List<Producto> cargarProductos(String rutaArchivo) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String descripcion = datos[2];
                double precio = Double.parseDouble(datos[3]);
                int cantidad = Integer.parseInt(datos[4]);
                productos.add(new Producto(id, nombre, descripcion, precio, cantidad));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
        }
        return productos;
    }

    public static void guardarProductos(List<Producto> productos, String rutaArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Producto producto : productos) {
                bw.write(producto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar productos: " + e.getMessage());
        }
    }
}