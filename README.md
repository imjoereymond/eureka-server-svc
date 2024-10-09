# Eureka Server Service (eureka-server-svc)

This repository contains the Eureka Server Service, a microservice used for service discovery in a microservices architecture. The service acts as a registry where other microservices can register themselves and discover each other for communication.

## Features

- Acts as a Service Registry using Netflix Eureka.
- Supports self-registration and discovery of microservices.
- Works seamlessly with Spring Cloud Config for centralized configuration management.

## Configuration Management

The `eureka-server-svc` microservice fetches its configuration from a Spring Cloud Config Server. The Config Server pulls configuration files from a Git repository, specifically from the `development` branch.

### Spring Cloud Config Integration

The `eureka-server-svc` uses the following configuration to connect to the Config Server:

```yaml
spring:
  application:
    name: eureka-server-svc
  config:
    import: optional:configserver:http://localhost:8888
  cloud:
    config:
      username: welljr
      password: <9LLW342'A
```

- **Config Server URL**: `http://localhost:8888`
- **Git Repository URL**: `https://github.com/imjoereymond/config-server-repo`
- **Branch**: `development`

### Eureka Configuration in Config Server

The Eureka Server configuration is stored in the `eureka-server-svc.yml` file under the `wellcare-hub` directory of the `development` branch in the Git repository.

#### File Location in Git Repository

```
wellcare-hub/
    └── eureka-server-svc.yml
```

To access the configuration, the Config Server retrieves the file from the following URL:

```
http://localhost:8888/eureka-server-svc/development
```

### Example `eureka-server-svc.yml`

```yaml
server:
  port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
  instance:
    hostname: localhost

management:
  endpoints:
    web:
      exposure:
        include: "*"
  security:
    enabled: false
```

## Running the Eureka Server

1. **Clone the repository**:

   ```bash
   git clone <your-eureka-server-repo-url>
   cd <your-eureka-server-repo-directory>
   ```

2. **Run the application**:

   Build and run the Eureka Server by executing:

   ```bash
   ./mvnw spring-boot:run
   ```

   The Eureka Server will be available at `http://localhost:8761`.

## Service Discovery

Once the Eureka Server is up and running, other microservices can register themselves using their `application.yml` or `bootstrap.yml` configuration:

```yaml
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```

## Accessing the Eureka Dashboard

After starting the Eureka Server, you can access the Eureka Dashboard via:

```
http://localhost:8761
```

The dashboard provides information about all registered services, their status, and health checks.

## Troubleshooting

- **Config Server Not Responding**: Ensure that the Config Server is up and running and accessible at the correct URL.
- **Authentication Errors**: Verify that the username and password used for the Config Server are correct.
- **Service Registration Issues**: Ensure that the Eureka Server is running and accessible by other microservices.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
