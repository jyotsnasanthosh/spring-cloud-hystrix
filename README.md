# spring-cloud-hystrix
A simple spring cloud hystrix client that implements the circuit breaker pattern

A service failure in the lower level of services can cause cascading failure all the way up to the user. 
When calls to a particular service reach a certain threshold (20 failures in 5 seconds is the default in Hystrix), the circuit opens and the call is not made. 
In cases of error and an open circuit a fallback can be provided by the developer.

### prerequisites
1. Java 1.8
2. Maven 3.5.2
3. Tomcat 7
4. Postgresql 42.1.4
5. Spring Tool Suite IDE

### setup
1. Clone this project
2. Open both MyApp and CircuitBreaker as separate maven projects.
3. Update maven dependencies in both.
4. Take separate jar builds of both projects and run them on server.
5. Hit `http://localhost:8090/getMessage` for running the main app service.
6. Stop running the MyApp and try hitting `http://localhost:8080/circuitBreaker` and the fallback method should be running.

### code style formatter
[Spring Boot Java Conventions](https://gist.github.com/jyotsnasanthosh/e2fb456f0ff91aa42ad8203e148bff79)
Save this as xml and import into eclipse -> window -> preferences -> java -> code style -> formatter