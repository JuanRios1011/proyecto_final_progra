package main.services;

import main.models.Producto;
import main.models.Venta;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class VentaService {
    public static void registrarVenta(List<Producto> productos, double total, String rutaArchivo) {
        Venta nuevaVenta = new Venta(obtenerNuevoId(rutaArchivo), productos, total, LocalDateTime.now());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            bw.write(nuevaVenta.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al registrar venta: " + e.getMessage());
        }
    }

    private static int obtenerNuevoId(String rutaArchivo) {
        int maxId = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int id = Integer.parseInt(linea.split(",")[0]);
                maxId = Math.max(maxId, id);
            }
        } catch (IOException e) {
            System.err.println("Error al leer ID de ventas: " + e.getMessage());
        }
        return maxId + 1;
    }
}