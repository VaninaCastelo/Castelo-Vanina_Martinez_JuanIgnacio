package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T registrar(T t) throws SQLException;

    List<T> listar();
}
