package com.p202.jsx.shared.mapstruct;


import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Shared mapper for MapStruct that can convert from and to {@link LocalDateTime}.
 */
@Component
public class LocalDateTimeMapper {

    /**
     * Convert from {@link Timestamp} to a {@link LocalDateTime}
     */
    public LocalDateTime asLocalDateTime(final Timestamp timestamp) {
        return (timestamp == null) ? null : timestamp.toLocalDateTime();
    }
}
