### Design Patterns with Unit Test

This repo contains my journey to learn unit tests and maven in depth, using Java and jUnit.

#### Resources

- For design patterns: https://refactoring.guru/design-patterns
- For junit: https://junit.org/junit4/
- For maven: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

## Design Patterns
### Adapter
**Adapter** allows objects with incompatible interfaces to collaborate.

![](https://refactoring.guru/images/patterns/diagrams/adapter/example.png)

### Singleton

**Singleton** lets you ensure that a class has only one instance, 
while providing a global access point to this instance.

![](https://refactoring.guru/images/patterns/content/singleton/singleton-comic-1-en.png)

![](https://refactoring.guru/images/patterns/diagrams/singleton/structure-en.png)

### Observer
**Also known as:** Event-Subscriber, Listener

Observer lets you define a subscription mechanism to notify multiple objects 
about any events that happen to the object they’re observing.

The Observer pattern suggests that you add a subscription mechanism to the publisher class so individual objects can 
subscribe to or unsubscribe from a stream of events coming from that publisher.

- All implementations of `java.util.EventListener` use this pattern.

![](https://refactoring.guru/images/patterns/diagrams/observer/structure.png)

