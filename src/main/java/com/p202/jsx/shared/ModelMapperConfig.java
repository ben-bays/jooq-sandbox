package com.p202.jsx.shared;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.jooq.RecordValueReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Configuration
public class ModelMapperConfig {

    /**
     * @return A {@link ModelMapper} that is configured to work with jooq
     */
    @Bean
    public ModelMapper mapper() {
        final ModelMapper mapper = new ModelMapper();
        
        mapper.getConfiguration().addValueReader(new RecordValueReader());
        mapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);

        // Jooq likes to use java.sql.Timestamp.  Let's provide a mapping to transform that to a LocalDateTime
        mapper.addConverter((Converter<Timestamp, LocalDateTime>) context -> {
            final Timestamp source = context.getSource();
            return source == null ? null : source.toLocalDateTime();
        });
        
        
        return mapper;
    }

}
