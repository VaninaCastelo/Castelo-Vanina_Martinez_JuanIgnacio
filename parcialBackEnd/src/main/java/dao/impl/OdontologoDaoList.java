package parcialBackEnd.src.main.java.dao.impl;

import dao.IDao;
import entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoList implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    List<Odontologo> odontologos = new ArrayList<>();
    @Override
    public Odontologo registrar(Odontologo odontologo) throws SQLException {
        odontologos.add(odontologo);
        LOGGER.info("El odontologo " + odontologo.getNombre() + " " + odontologo.getApellido() + " se registró exitosamente en memoria.");
        System.out.println(odontologo.toString());
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        LOGGER.info("Odontologos registrados en el sistema: /n" + odontologos);
        return odontologos;
    }
}
