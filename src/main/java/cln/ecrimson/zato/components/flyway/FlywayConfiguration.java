package cln.ecrimson.zato.components.flyway;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlywayConfiguration {

    @Autowired
    FlywayConfig flywayConfig;

    @PostConstruct
    public void init(){

        FluentConfiguration fwConfig = Flyway.configure(this.getClass().getClassLoader())
                .dataSource(flywayConfig.getUrl(), flywayConfig.getUsername(), flywayConfig.getPassword())
                .locations(flywayConfig.getLocations())
                .baselineOnMigrate(true)
                .validateOnMigrate(false)
                .defaultSchema(flywayConfig.getSchema())
                .loggers("slf4j")
                .table("schema_version");
        fwConfig.load().migrate();
    }
}
