module service {
    exports pl.pwr.ite.service;
    requires model;
    requires spring.context;

    opens pl.pwr.ite.service.impl to spring.core, spring.beans;
}