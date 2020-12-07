# spring-hibernate-notes

# Spring Inversion of Control :

(Design and construction of object which is handled by the object factory. -(create and manage objects)

# Spring Dependency injection :

Inject object's dependencies.

we can achieve this by 3 type :

1. XML configuration file (legacy)
2. Java annotation(modern)
3. java source code(modern)

## XML configuration:

### Dependency injection :

1. Constructor injection.
2. Setter injection.

2) Java Annotation -
   steps :
   a. enable component scanning in Spring config file.
   b. add the @Component annotation to your Java class.
   c.Retrieve bean from Spring container.

### Spring Dependency injection with Annotation and Auto-wiring

> What is spring auto-wiring?

- Spring will look for a class that matches the property
  - matches by type : class or interface.
- Spring will inject it automatically ... hence it is auto-wired.

### Auto-wiring injection types

there are 3 types

- Constructor injection
- Setter Injection
- Field Injection

### Development Process - Constructor Injection.

1. Define the dependency interface and class

2. Create a constructor in your class for injections.

3. Configure the dependency injection with @AutoWired annotation.

### Development process - Setter Injection with Auto-wiring

1. Create setter methods(s) in your class for injections

2. Configure the dependency injection with @Autowired Annotation

### Method Injection :

- Inject dependencies by calling Any method on our class.

```
Simply give : @Autowired
```

We can give any method name instead of the setter method

### Field Injection :

- Inject dependencies by setting field values on your class directly (even private fields)
- Accomplished by using Java reflection.

### Development Process - Field Injection

1. Configure the dependency injection with Autowired annotation
   - Applied directly to the field
   - No need fir setter methods
     > Note : All the 3 injection methods in Annotation are same (i.e., one is not superior)

### Annotation Autowiring and Qualifiers :

If we have multiple dependency then it will throw "Error creating bean with name 'bean id here' Injection of autowired dependencies failed"

TO over come this we use @Qualifier annotation to tell spring to use which bean id

We can use @Qualifier to all types of dependency i.e., Constructor, method and Field Injections

### Bean Scope and LifeCycle

- Scope refers to the lifecycle of a bean -
  Default scope is Singleton

  > what is singleton - Spring container creates only one instance of the bean by default & it is cached in memory & All requests for the bean will return SHARED reference to the SAME bean.
  > We can specify the bean scope using @Scope annotation ex : @Scope("singleton")

  > Prototype scope will create a new object for each request.
  > ex : @Scope("prototype")

- How long does the bean live?
- how many instance are created?
- How is the bean shared?

### Bean Lifecycle methods/Hooks

- We can add custom code during **bean initialization**.
  - Calling custom business logic methods.
  - Setting up handles to resources (db,sockets, file etc.)
- We can add custom code during **bean destruction**.
  - Calling custom business logic method.
  - Clean up handles to resources (db,sockets, file etc.).

### Development Process

1. Define your methods for init and Destroy.
2. Add annotation : @PostConstruct and @PreDestroy.

### Spring Configuration with Java code (No XML required)

### Development Process :

1. Create a Java class and annotate as `@Configuration`
2. Adding component scanning Support : `@ComponentScan` (optional)
3. Read Spring Java configuration class
4. Retrieve bean from spring container.

### Defining Beans with Java Code

### Development - process

1. Define method to expose bean
2. Inject bean dependencies.
3. Read Spring Java Configuration class
4. Retrieve bean from spring container

### Inject values from properties files.

### Development Process :

1. Create properties file.
2. Load Properties file in spring config.
3. reference values from properties file.

# Spring MVC :

- Framework for building web application in Java.
- Based on Model-view-controlled design pattern.
- Leverages features of the Core Spring Framework(IoC,DI).

> Spring MVC documentation www.luv2code.com/spring-mvc-docs

### components of Spring MVC application

- A set of web pages to layout UI components (web pages).
- A collection of Spring bean (Controllers, services, etc...)
- Spring configuration (XML, Annotation or Java)

Spring Execution :

> Web browser -> Front Controller -> controller -> view-template -> browser.

Spring MVC front controller :

- Front controller known as **DispatcherSerlet**

  - Part of the Spring framework.
  - Already developed by Spring dev team.

- You will create
  - <u>M</u>odel Objects.(Object/ data)
  - <u>V</u>iew templates. (JSP pages)
  - <u>C</u>ontroller classes. (business logic)

### <u>C</u>ontroller :

Code created by developer.

- Contains your business logic
  - Handle request.
  - Store or retrieve data(db, web services...)
  - Place data in model
- Send appropriate view template.

### <u>M</u>odel :

- Model : contains your data.
- store/retrieve data via backend systems
  - db, web services etc...
  - use a spring bean if you like.
- Place your data in the model
  - Data can be any Java objects/collection.

### <u>V</u>iew :

- Spring MVC is flexible
  - Supports many view templates.
- Most common is JSP + JSTL.
- Developer creates a page
  - Displays data
- Other view templates supported Thymeleaf, groovy, velocity, Freemarker , etc...

> For details view : www.luv2code.com/spring-mvc-views

# Spring MVC configuration - setup

### Step - 1

Add configurations to file: WEB-INF/web.xml

1. configure Spring MVC Dispatcher Servlet
2. Se up URL mappings to Spring MVC Dispatcher servlet.

### Step - 2

3. Add support for spring component scanning.
4. Add support for conversion, formatting, and validation.
5. Configure Spring MVC View Resolver.

# Spring - MVC project

### Developing spring controllers and views :

### Development Process :

1. Create controller class
   > annotate class with @Controller (@Controller inherit from @Component)
2. Define Controller method
3. Add request mapping to controller method.
4. Return view name
5. Develop view page.
