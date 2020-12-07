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
