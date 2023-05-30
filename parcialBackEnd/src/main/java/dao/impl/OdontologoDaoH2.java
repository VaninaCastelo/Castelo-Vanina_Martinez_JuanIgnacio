package dao.impl;

import dao.H2Connection;
import dao.IDao;
import entity.Odontologo;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);


    @Override
    public Odontologo registrar(Odontologo odontologo) throws SQLException {
        Connection connection = null;

        //no se establace la conexion, ademas desde la linea 25 a la 38, deberia ir dentro del bloque try
        connection.setAutoCommit(false);


        PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (NROMATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)");
        ps.setString(1,odontologo.getNroMatricula());
        ps.setString(2,odontologo.getNombre());
        ps.setString(3,odontologo.getApellido());
        ps.execute();


        LOGGER.info("Se registró exitosamente el odontologo: " + odontologo);
        connection.commit();

        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);


        }catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            } catch (Exception ex){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        Connection connection = null;
        List<Odontologo> odontologos= new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nroMatricula = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                Odontologo odontologo = new Odontologo(nroMatricula,nombre, apellido);
                odontologos.add(odontologo);
            }

            LOGGER.info("Listado de todos los odontologos: " + odontologos);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologos;
    }
}
