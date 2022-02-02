package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    public void createTable(String tableName) throws Exception {
        executeStatement(String.format("create table if not exists %s();", tableName));
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropTable(String tableName) throws SQLException {
        executeStatement(String.format("drop table if exists %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        executeStatement(String.format("alter table %s add column %s %s", tableName, columnName, type));
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropColumn(String tableName, String columnName) throws  Exception {
        executeStatement(String.format("alter table %s drop column %s;", tableName, columnName));
        System.out.println(getTableScheme(connection, tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        executeStatement(String.format("alter table %s rename column %s to %s", tableName, columnName, newColumnName));
        System.out.println(getTableScheme(connection, tableName));
    }

    private void executeStatement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Config config = new Config("src/main/java/ru/job4j/io/data/app.properties");
        config.load();
        Properties properties = new Properties();
        properties.setProperty("driver", config.value("hibernate.connection.driver_class"));
        properties.setProperty("url", config.value("hibernate.connection.url"));
        properties.setProperty("login", config.value("hibernate.connection.username"));
        properties.setProperty("password", config.value("hibernate.connection.password"));
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("Test");
        tableEditor.addColumn("Test", "col", "varchar (255)");
        tableEditor.renameColumn("Test", "col", "new_col");
        tableEditor.dropColumn("Test", "new_col");
        tableEditor.dropTable("Test");
    }
}
