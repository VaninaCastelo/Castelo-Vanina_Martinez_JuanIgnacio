package service;
import dao.IDao;
import entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {

   private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {

        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        try {
            odontologoIDao.registrar(odontologo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoIDao.listar();
    }
}
