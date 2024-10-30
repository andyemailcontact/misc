# Spring Boot

## Test

```
@SpringBootTest
@ContextConfiguration(classes = {PropertiesAutoConfiguration.class}) // data bean
@ActiveProfiles("localtest") // override with application-localtest.yaml in test/Resources folder
```

