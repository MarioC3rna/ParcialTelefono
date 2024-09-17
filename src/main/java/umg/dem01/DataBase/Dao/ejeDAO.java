package umg.dem01.DataBase.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private Connection connection;

    // Constructor que recibe la conexión a la base de datos
    public ejeDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para crear un nuevo registro
    public void create(ejeModel modelo) throws SQLException {
        String sql = "INSERT INTO modelos_telefonicos (marca, modelo, sistema_operativo) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, modelo.getMarca());
            stmt.setString(2, modelo.getModelo());
            stmt.setString(3, modelo.getSistemaOperativo());
            stmt.executeUpdate();
        }
    }

    // Método para obtener un registro por ID
    public ejeModel getById(int id) throws SQLException {
        String sql = "SELECT * FROM modelos_telefonicos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ejeModel(
                            rs.getInt("id"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getString("sistema_operativo")
                    );
                }
            }
        }
        return null;
    }

    // Método para obtener todos los registros
    public List<ejeModel> getAll() throws SQLException {
        List<ejeModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM modelos_telefonicos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ejeModel modelo = new ejeModel(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("sistema_operativo")
                );
                lista.add(modelo);
            }
        }
        return lista;
    }

    // Método para actualizar un registro
    public void update(ejeModel modelo) throws SQLException {
        String sql = "UPDATE modelos_telefonicos SET marca = ?, modelo = ?, sistema_operativo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, modelo.getMarca());
            stmt.setString(2, modelo.getModelo());
            stmt.setString(3, modelo.getSistemaOperativo());
            stmt.setInt(4, modelo.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un registro
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM modelos_telefonicos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
