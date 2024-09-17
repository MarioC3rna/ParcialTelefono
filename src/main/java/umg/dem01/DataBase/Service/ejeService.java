package umg.dem01.DataBase.Service;

import umg.dem01.DataBase.Dao.Dao;
import umg.dem01.DataBase.Model.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Service {
    private Dao dao;

    // Constructor que recibe la conexión
    public Service(Connection connection) {
        this.dao = new Dao(connection);
    }

    // Crear nuevo registro
    public void createModelo(Model modelo) throws SQLException {
        dao.create(modelo);
    }

    // Obtener modelo por ID
    public Service getModeloById(int id) throws SQLException {
        return dao.getById(id);
    }

    // Obtener todos los modelos
    public List<Service> getAllModelos() throws SQLException {
        return dao.getAll();
    }

    // Actualizar un modelo
    public void updateModelo(ejeModel modelo) throws SQLException {
        dao.update(modelo);
    }

    // Eliminar un modelo
    public void deleteModelo(int id) throws SQLException {
        dao.delete(id);
    }


}
