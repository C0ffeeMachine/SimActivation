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




# Project Implementation

Application flow with functionality:

 1) SIM Details:  Customer has to enter the SIM number present in the SIM starter kit and Service number (mobile number), so that provider can     validate the SIM and Service number. Once details are validated, customer should be able to see the available offers for the provided SIM       details.
    ### Acceptance Criteria:

     a) SIM number should be 13-digit numeric value
     b) Service number should be 10-digit numeric value
     c) Verify the values for invalid SIM/Service details, if the provided SIM/Service number is invalid display "Invalid details, please check         again SIM number/Service number!"

     Verify SIM already activated, if the provided SIM is already activated display "SIM already active"   

    ### REST endpoint:

     Create a REST endpoint to do SIM validation

     This is a POST request accepting SIM number and Service number. Verify that combination of SIM number and Service number are correct. On        successful validation, respective sim offer details has to be returned. On failure, return the response with customized error messages.




 2) Customer Basics Details: Assuming that while purchasing the SIM, email and date of birth(dob) details are submitted by the customer. Now to activate the SIM, as part of verification process, customer has to provide email and dob details for validation. These details are validated against stored data and for invalid details display custom error message.

### Acceptance Criteria:

Both email and dob are mandatory fields, if not present then display "Email/dob value is required"

dob should be in yyyy-mm-dd format

Email should contain one '@' symbol followed with that one dot(.) then it should accept only 2 or 3 characters. If invalid then display "Invalid email"

If the provided email and dob does not exist then display "No request placed for you." otherwise return success

### REST endpoint:

Create a REST endpoint to validate customer basic details against stored data

This is a POST request accepting email and dob details, verify that these details are correct against stored data and respond appropriate error messages in case of incorrect values.




 3) Customer Personal Details:  As a customer, provide personal details such as first name, last name and confirm email for customer personal details validation.Here confirm email acts like OTP to validate the stored customer data. Retrieve customer record based on first name and last name, validate entered confirm email with stored email id, if matching return success otherwise return custom error message.
### Acceptance Criteria:

Firstname and last name should accept only alphabets, the maximum length is 15. For incorrect value display "Firstname/Lastname should be maximum of 15 characters"                               

Validate First name and last name with the existing details if not matching display "No customer found for the provided details"    

 Verify that error message “Invalid email details!!” is displayed if both email and confirm email are not matching.                                                               

### REST endpoint:

This is a POST request which accepts the first name, last name and confirm email. Verify that provided details are correct, respond appropriate error messages in case of incorrect values otherwise get customer data based on provided first and last name, compare stored email with provided confirm email value. If valid, return success otherwise appropriate error message.



 4) Update Customer Address: Assuming that while purchasing the SIM, communication address has been submitted. Now customer should be able to update the address if required for further communication.
### Acceptance Criteria:

Address length should be maximum of 25 characters otherwise display "Address should be maximum of 25 characters"                                                    

Verify that PIN code is 6-digit number. For incorrect value, display "Pin should be 6 digit number"

City and state should not contain any special characters except space. For incorrect value, display "City/State should not contain any special characters except space"

### REST endpoint:

This is a PUT request which accepts address details

Update new address if details already present otherwise add address and respond with updated address


Note: Verify new address update in CustomerAddress table

 5) Customer ID Proof Validation: Customer should provide valid government identify proof(Example: Aadhar id, passport etc). Here you can consider Aadhar card for Id proof check.

### Acceptance Criteria:

Enter Aadhar unique number which is present in the given id, it should be 16 digit otherwise display "Id should be 16 digit"

Enter first name, last name, it should be match with stored Id proof values and also match with the previously provided first name and last name. For incorrect values display "Invalid details"

Enter date of birth in yyyy-mm-dd format and it should match previously provided dob. For incorrect values, display "Incorrect date of birth details"

All inputs are mandatory fields. If all the details are valid then proceed with activating the SIM status

### REST endpoint:

This is a POST request which accepts Id proof details, verify values and respond customized error messages for incorrect values

Verify that entered values are matching with the stored data, if matching respond success and change the status of SIM in SimDetails table from “inactive” to “active” otherwise respond with appropriate message.

