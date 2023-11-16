module server {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.data.jpa;
    requires spring.tx;
    requires spring.context;
    requires model;
    requires service;
    requires lombok;
    requires spring.web;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires spring.beans;
    requires spring.core;
    requires spring.jdbc;
    requires java.sql;

    exports pl.pwr.ite.server.config;
    exports pl.pwr.ite.server.web.dto;
    exports pl.pwr.ite.server.web.mapper;
    exports pl.pwr.ite.server;

    opens pl.pwr.ite.server to spring.core;
    opens pl.pwr.ite.server.config to spring.core;
    opens pl.pwr.ite.server.web.mapper to spring.core;
    opens pl.pwr.ite.server.web.controller to spring.beans, spring.web, spring.core;
    opens pl.pwr.ite.server.web.service to spring.beans;

    uses org.springframework.boot.autoconfigure.SpringBootApplication;
}