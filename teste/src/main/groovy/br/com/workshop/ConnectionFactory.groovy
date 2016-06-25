package br.com.workshop

import groovy.sql.Sql

/**
 * Created by dummy on 18/06/2016.
 */
class ConnectionFactory {

    Sql createConnection() {
        return Sql.newInstance('jdbc:sqlite:test.db', "org.sqlite.JDBC");
    }
}
