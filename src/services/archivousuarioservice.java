package services;

import models.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUsuarioService {

    // Guardar usuarios en un archivo de texto
    public static void guardarUsuarios(List<Usuario> usuarios, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuario.getNombreUsuario() + "," +
                             usuario.getContraseña() + "," +
                             usuario.getRol());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios en el archivo: " + e.getMessage());
        }
    }

    // Leer usuarios desde un archivo de texto
    public static List<Usuario> cargarUsuarios(String rutaArchivo) {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombreUsuario = partes[0];
                    String contraseña = partes[1];
                    Usuario.Rol rol = Usuario.Rol.valueOf(partes[2]);
                    usuarios.add(new Usuario(nombreUsuario, contraseña, rol));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios desde el archivo: " + e.getMessage());
        }
        return usuarios;
    }
}
