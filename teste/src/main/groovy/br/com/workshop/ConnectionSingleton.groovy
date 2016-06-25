package br.com.workshop

import groovy.sql.Sql

/**
 * Created by dummy on 18/06/2016.
 */
class ConnectionSingleton {

    private static Sql connection;
    static Sql getConnection() {
        if (!connection) {
            connection = new ConnectionFactory().createConnection();
        }
        return connection;
    }
}

