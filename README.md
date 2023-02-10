# SimActivation
This project is a cloud native application. Backend is built using spring boot . This project implements feature such as circuit breaker pattern for fault tolerance , client side load balancing, Eureka service registry and service discovery.


# Feign Client
The Feign client automatically integrates with Load balancing APIs and Circuit Breaker APIs to provide load balancing and fallback mechanism.

Few drawbacks with RestTemplate are :

 1) need to be aware of the various methods of the RestTemplate API to use it.

 2) a separate bean for Load balancing

 3) a separate service for Circuit breaker is needed

The header details of a request from Zuul (Gateway API) are not forwarded to the other microservices using RestTemplate

# Eureka Service Discovery


# Circuit Breaker

# Zuul Gateway

# Client Side LoadBalancing
