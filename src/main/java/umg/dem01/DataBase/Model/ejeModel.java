package umg.dem01.DataBase.Model;

public class Model {
    private int id;
    private String marca;
    private String modelo;
    private String sistemaOperativo;

    // Constructores
    public Model() {}

    public Model(int id, String marca, String modelo, String sistemaOperativo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return "Model [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", sistemaOperativo=" + sistemaOperativo + "]";
    }


}
