package ch.heigvd.amt.services.dao;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Stateless
abstract public class AbstractManager {
    @Resource(lookup = "java:/jdbc/quarisDS")
    private DataSource dataSource;

    protected Connection connection;

    public AbstractManager() {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("FAIL FAIL FAIL");
            e.printStackTrace();
        }
    }
}
