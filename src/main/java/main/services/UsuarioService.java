package main.services;

import main.models.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    public static List<Usuario> cargarUsuarios(String rutaArchivo) {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String contrasena = datos[1];
                Usuario.Rol rol = Usuario.Rol.valueOf(datos[2]);
                usuarios.add(new Usuario(nombre, contrasena, rol));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public static void guardarUsuarios(List<Usuario> usuarios, String rutaArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Usuario usuario : usuarios) {
                bw.write(usuario.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }
}
