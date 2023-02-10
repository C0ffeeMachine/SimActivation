# Project - SimActivation
This project is a cloud native application. Backend is built using spring boot . This project implements feature such as circuit breaker pattern for fault tolerance , client side load balancing, Eureka service registry and service discovery.

# TECH USED


## Feign Client
The Feign client automatically integrates with Load balancing APIs and Circuit Breaker APIs to provide load balancing and fallback mechanism.

Few drawbacks with RestTemplate are :

 1) need to be aware of the various methods of the RestTemplate API to use it.
 2) a separate bean for Load balancing
 3) a separate service for Circuit breaker is needed

The header details of a request from Zuul (Gateway API) are not forwarded to the other microservices using RestTemplate

## Eureka Service Discovery
A service registers itself with a central server called the Service Registry. Now, once it registers itself with the Service Registry, two things happen:

 1) Its details like name, port, host, etc. are stored in the Service Registry
 2) A list of other registered services become available to it



## Circuit Breaker
Hystrix allows you to mention any alternate piece of code that you wish to run if a service is down. Obviously you don’t get the same result as you wish you had. But, providing some form of data instead of an error is better.

Thus Hystrix allows you to degrade gracefully. The user continues to have access to the application, but some of the features will be unavailable temporarily. Compared to FailFast this is the FailSilent pattern.

Fallback executes when:

 1) An error occurs
 2) A timeout occurs
 3) Circuit opens

## Zuul Gateway
The API gateway performs complex tasks including:

 1) Intelligent routing: When a request comes from the client, it intelligently routes it to the appropriate services
 2) Client Specific API: A mobile client and a web client need different treatment and an API gateway provides specific APIs for each client
 3) Request Aggregation: Based on a single request from the client, it invokes multiple services, aggregates the result, and sends it back
 4) Protocol translation: It will be responsible for taking data from service through let’s say AMQP and sends the data to the client over HTTP
 5) Security
 6) Load balancing

## Client Side LoadBalancing(Netflix Ribbon)
Two types of load balacing are:-

 1) Server side Load balancing: Customer would simply send the request to the load balancer and it is the responsibility of the load balancer to decide to whom it should forward the request.
 2) Client Side Load Balancing: The client is responsible for deciding to whom it will send the request. The client-side load balancers are thus software load balancers and not traditional hardware load balancers.
