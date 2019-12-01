package fr.univparis8.iut.csid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsidConfiguration {

    @Bean
    public DiskReader dvdReader() {
        return new DvdReader();
    }
}
