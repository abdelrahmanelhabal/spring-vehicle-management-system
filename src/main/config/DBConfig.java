package main.config;

import lombok.Getter;
import main.dao.DaoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Getter
public class DBConfig {
    private Connection connection ;

    @Value("${db.url}")
    private String url ;

    @Value("${db.username}")
    private String username ;

    @Value("${db.password}")
    private String password ;

    @PostConstruct
    public void connectToDatabase(){
        try{
            connection = DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e){
            throw new DaoException("Failed to create Database connection",e);
        }
    }

    @PreDestroy
    public void disconnectToDatabase(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        catch (SQLException e){
            throw new DaoException("Failed to close Database connection",e);
        }
    }

    public Connection getConnection(){
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(url,username,password);
            }
            return connection;
        }
        catch (SQLException e){
            throw new DaoException("Unable to get Database connection", e);
        }
    }

}
