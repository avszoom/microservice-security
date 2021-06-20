# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.avszoom.in.microservice-security' is invalid and this project uses 'com.avszoom.in.microservicesecurity' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)



###Notes

AS soon as spring boot security is added - authentication starts. No need to add any annotation or anything. Authentication screen pops
up asking for password and name. it also validates credential so there is default setting.

servlet technology is base of everything. Servlet container picks right servlet based on urls and then it executes methods to deal with it.
These are basic java objects which implement doget() doPOst() etc. All applications are hosted in some web container or web server. Web.xml file
maps the url path pattern to right implemented servlet.

Filters - it intercepts every request sit before servlet and we can inject some functionality there.Spring security filter do the same it
          try to authenticate user. mandatory authenticates for all urls but it skips error urls. it sets up a default username and password
          if user doesnt specify. we can set up default password user via application.properties.
          By default spring is configured to intercept all request(/**) via filters and forward it to DelegatingFilterProxy which in turn calls
          Authentication filter.

Authentication Manager - Authentication Manager class actually has a method authenticate that spring security filter calls in. Now if we
        want to alter behaviour of authentication manager then we use authentication Manager builder class to create  manager instance
        and provide our configuration.
        Now Authentication Manager once configured (common configurations are its form based authentication, given a set of username pwd)
        Manager then contains a list of Authentication Provider(based on config whether its form based, token based etc) and forward any
        request coming to then. These providers operate on Authentication Object which basically store credential and when authenticated
        provider returns Authentication object that store prinicipal and authorization information.
        So essentially we can have lot of providers to implement different authentication in single instance.

UserDetailService - Every AuhenticationProvider when given credential using Authentication object has to perform check on it by accesing
        user objects , Hence spring provides by default a UserDetailService which do this heavy lifting job, we just need to configure it
        by pointing to right data store. It returns an UserDetail Object which Providers user to return principal or throw exception based
        on successful or failed authentication.



Authorization - default behaviour of spring security is to give access to all apis to everyone who is authenticated.

HTTP Security -  This is the class that spring security uses to figure out whether user can be given access to this api or not. Now to create
        instance of this class we use same class call WebSecurityConfigurerAdapter and overwrite configure(HttpSecurity) method

logout() - spring security has a default logout page existing at /logout. This logouts or clear session of current user.


Deep dive in authentication -

Request -> DelegatingFilterProxy -> AuthenticationFilter -> AuthenticationManager(configure) -> AuthenticationProvider(configure) -> UserDetailService

Once user is succesful authenticated user principal object(Authenticate object) is stored in Security context or associated with current
Session. SO that user doesnt has to authenticate for every other request.
