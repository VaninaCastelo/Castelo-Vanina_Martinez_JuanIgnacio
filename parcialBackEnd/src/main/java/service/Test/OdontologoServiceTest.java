package parcialBackEnd.src.main.java.service.Test;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import parcialBackEnd.src.main.java.dao.impl.OdontologoDaoH2;
import parcialBackEnd.src.main.java.dao.impl.OdontologoDaoList;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);



    @Test
    public void deberiaRegistrarUnOdontologoH2() throws SQLException {
        service.OdontologoService odontologoServiceH2 = new service.OdontologoService(new OdontologoDaoH2());
        entity.Odontologo odontologo = new entity.Odontologo("mat3456", "Marcelo", "Muela");
        entity.Odontologo odontologo2 = new entity.Odontologo("mat3457", "María", "Canino");
        entity.Odontologo odontologo3 = new entity.Odontologo("mat3458", "Javier", "Paleta");
        entity.Odontologo odontologo4 = new entity.Odontologo("mat3459", "Cristina", "Bracket");
        odontologoServiceH2.registrarOdontologo(odontologo);
        odontologoServiceH2.registrarOdontologo(odontologo2);
        odontologoServiceH2.registrarOdontologo(odontologo3);
        odontologoServiceH2.registrarOdontologo(odontologo4);


        assertNotNull(odontologoServiceH2);
        assertEquals("mat3456", odontologo.getNroMatricula() );

    }

    @Test
    public void deberiaRegistrarUnOdontologoEnMemoria() {
        service.OdontologoService odontologoServiceList = new service.OdontologoService(new OdontologoDaoList());
        entity.Odontologo odontologo = new entity.Odontologo("mat3456", "Marcelo", "Muela");
        entity.Odontologo odontologo2 = new entity.Odontologo("mat3457", "María", "Canino");
        entity.Odontologo odontologo3 = new entity.Odontologo("mat3458", "Javier", "Paleta");
        entity.Odontologo odontologo4 = new entity.Odontologo("mat3459", "Cristina", "Bracket");
        odontologoServiceList.registrarOdontologo(odontologo);
        odontologoServiceList.registrarOdontologo(odontologo2);
        odontologoServiceList.registrarOdontologo(odontologo3);
        odontologoServiceList.registrarOdontologo(odontologo4);


        assertEquals("mat3456", odontologo.getNroMatricula());
        assertEquals("mat3457", odontologo2.getNroMatricula());


    }

    @Test
    public void deberiaListarOdontologosDeH2(){
        service.OdontologoService odontologoServiceH2 = new service.OdontologoService(new OdontologoDaoH2());

        assertTrue(odontologoServiceH2.listarOdontologos().size() > 1);

    }

    @Test
    public void deberiaListarOdontologosEnMemoria(){
        service.OdontologoService odontologoServiceList = new service.OdontologoService(new OdontologoDaoList());
        entity.Odontologo odontologo = new entity.Odontologo("mat3456", "Marcelo", "Muela");
        entity.Odontologo odontologo2 = new entity.Odontologo("mat3457", "María", "Canino");
        entity.Odontologo odontologo3 = new entity.Odontologo("mat3458", "Javier", "Paleta");
        entity.Odontologo odontologo4 = new entity.Odontologo("mat3459", "Cristina", "Bracket");
        odontologoServiceList.registrarOdontologo(odontologo);
        odontologoServiceList.registrarOdontologo(odontologo2);
        odontologoServiceList.registrarOdontologo(odontologo3);
        odontologoServiceList.registrarOdontologo(odontologo4);
        LOGGER.info(odontologoServiceList.listarOdontologos());
        assertTrue(odontologoServiceList.listarOdontologos().size() > 0);
    }

}