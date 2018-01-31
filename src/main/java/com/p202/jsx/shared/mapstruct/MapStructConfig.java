package com.p202.jsx.shared.mapstruct;

import org.mapstruct.MapperConfig;

@MapperConfig(uses = {LocalDateTimeMapper.class}, componentModel = "spring")
public interface MapStructConfig {
}
