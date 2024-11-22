package main.models;

public class Usuario {
    public enum Rol { ADMINISTRADOR, VENDEDOR, GERENTE }

    private String nombreUsuario;
    private String contrasena;
    private Rol rol;

    public Usuario(String nombreUsuario, String contrasena, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters y Setters
    public String getNombreUsuario() { return nombreUsuario; }
    public String getContrasena() { return contrasena; }
    public Rol getRol() { return rol; }

    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setRol(Rol rol) { this.rol = rol; }

    @Override
    public String toString() {
        return nombreUsuario + "," + contrasena + "," + rol;
    }
}
