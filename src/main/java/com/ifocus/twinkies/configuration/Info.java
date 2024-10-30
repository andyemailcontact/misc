package com.ifocus.twinkies.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("info.name")
@Data
//@AllArgsConstructor
public class Info {
    private String firstName;
    private String lastName;
}
