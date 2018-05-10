package chapter01.springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface StatementStrategy {
    java.sql.PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
