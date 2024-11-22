package models;

public class Usuario {
    public enum Rol { ADMINISTRADOR, VENDEDOR, GERENTE }

    private String nombreUsuario;
    private String contraseña;
    private Rol rol;

    public Usuario(String nombreUsuario, String contraseña, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    // Getters y Setters
    public String getNombreUsuario() { return nombreUsuario; }
    public String getContraseña() { return contraseña; }
    public Rol getRol() { return rol; }

    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public void setRol(Rol rol) { this.rol = rol; }

    @Override
    public String toString() {
        return nombreUsuario + "," + contraseña + "," + rol;
    }
}
