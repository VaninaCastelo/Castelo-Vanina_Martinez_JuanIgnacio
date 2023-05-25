package dao.impl;

import dao.IDao;
import entity.Odontologo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoList implements IDao<Odontologo> {
    List<Odontologo> odontologos = new ArrayList<>();
    @Override
    public Odontologo registrar(Odontologo odontologo) throws SQLException {
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        return odontologos;
    }
}
