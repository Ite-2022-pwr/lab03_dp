module model {
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;
    requires spring.data.jpa;
    exports pl.pwr.ite.model.filter;
    exports pl.pwr.ite.model.entity;
    exports pl.pwr.ite.model.repository;
    exports pl.pwr.ite.model.enums;

    opens pl.pwr.ite.model.entity to server, org.hibernate.orm.core, spring.core;
    opens pl.pwr.ite.model.repository to spring.core;
    opens pl.pwr.ite.model.enums to spring.core;
    opens pl.pwr.ite.model.filter to spring.core;
}