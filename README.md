# Task S303 - Patterns 2

## Introduction

We will continue practicing the use of design patterns to solve common problems in software development.

You will see that there are many different patterns, and each one applies to specific use cases. As we work through them, you will learn to recognize when and how to use them to write cleaner, more flexible, and easier-to-maintain code. This task will allow you to consolidate the knowledge you have acquired and discover new patterns that will help you tackle more complex projects with confidence and professional judgment.

## Level 1

### Builder Pattern

#### What is it?

The Builder design pattern is a creational pattern that helps us build complex objects step by step, separating the construction of the object from its representation.

In other words, it makes it easier to create objects that have many parameters, some of them optional or with default values, without filling client code with long constructors or tangled configurations.

#### Usefulness

The Builder pattern is useful when:

- The object to be built has many optional attributes or possible configurations.
- The construction needs to remain clear, readable, and extensible.
- You want to avoid overly long constructors or constructors that are difficult to read.


#### Purpose

- It makes the creation process more readable and maintainable.
- It avoids the telescoping constructor anti-pattern (those constructors with 5, 6, or 7 parameters that nobody understands).
- It helps produce clearer and more expressive code, especially when combined with the Fluent approach.

There are different ways to implement Builder. In this exercise, you will use the **Fluent Builder**, which allows calls to be chained fluently.

#### Example

```java
Car car = new CarBuilder()
        .withModel("Sedan Premium")
        .withEngine("Hybrid", 180)
        .withColor("Metallic Black")
        .withInterior("Leather")
        .withNavigationSystem()
        .withDriverAssistance()
        .withSportPackage()
        .build();
```


### Exercise

#### Implementing the Builder pattern in a restaurant menu

#### Objective

Design and implement a system to build different types of restaurant menus by applying the Builder design pattern using the Fluent Builder style and following SOLID principles.

In addition, the **progressive interface** concept will be used, which consists of progressively limiting the options available to the user during object construction, ensuring that the process is carried out in the correct order and that dependencies between steps are respected. For example, it should not be possible to add dessert before adding the main course, nor should it be possible to call the method to add dessert more than once.

#### Description

Menus may be composed of:

- Starters
- Main course
- Dessert
- Drink

These may have specific characteristics:

- Any dish can be: Vegan and/or Gluten Free.
- The main course can include a supplement (for example: an extra side dish).
- In addition, the customer may order only the half menu, which includes only the main course and the drink.
- The kids’ menu includes only a main course, drink, and dessert.
- Menus may be without a drink.
- Desserts are optional in all menus and can be either dessert or coffee.


#### Requirements

Model a flexible system to build menus step by step, without dependencies on concrete classes, ensuring the correct and mandatory order in menu construction. For example, it should not be possible to add dessert before adding the main course.

Implement a restriction such that, if dessert is chosen, coffee cannot be added, and vice versa. This rule must be enforced through interface design.

Allow dish properties (vegan, gluten free, supplement) to be configured with fluent and expressive methods, avoiding boolean parameters.

Implement unit tests showing the creation of several menus:

**Menu:**

- Starter: Mediterranean Salad (Vegan) (Gluten Free)
- Main Course: Beef Fillet, Supplement: Extra side dish
- Dessert: Chocolate mousse
- Drink: Red Wine


#### Expected usage example

```java
Menu executiveMenu = new MenuBuilder()
    .withEntrant("Amanida Mediterrània")
        .isVegan()
        .isGlutenFree()
    .withMainCourse("Filet de Vedella")
        .withSuplement("Guarnició extra")
    .withDessert("Mousse de xocolata")
    .withDrink("Vi Negre")
    .build();

Menu kidsMenu = new MenuBuilder()
    .withMainCourse("Macarrons amb tomàquet")
    .withDessert("Gelat de Vainilla")
    .withDrink("Suc de taronja")
    .build();

Menu halfMenu = new MenuBuilder()
    .withMainCourse("Risotto de bolets")
        .isVegan()
    .withCoffee("Espresso")
    .withDrink("Aigua")
    .build();
```

## Answer
The dessert/coffee exclusivity is enforced at compile time using progressive interfaces. After selecting dessert, the returned type no longer exposes the coffee option, and vice versa. Therefore, invalid combinations cannot even be written, so no runtime exception is needed for this rule.

## Level 2

### Observer Pattern

#### What is it?

The Observer pattern is a behavioral design pattern that defines a one-to-many dependency relationship between objects, so that when one object changes state, all its dependents are automatically notified.

In other words, it allows you to define a subscription mechanism to notify multiple objects about any event that happens to the object they are observing.

#### Usefulness

The Observer pattern is useful when:

- We need to automatically notify multiple components when a state change occurs.
- Changes in the state of one object may affect others, but we do not know which or how many objects at coding time.
- We need other objects to be added or removed dynamically as observers depending on the context.
- We want to implement pub-sub style systems (publisher / subscriber).


#### Purpose

- To allow all observers to be automatically notified when the Observable changes state.
- To introduce new subscriber classes without having to modify the notifier class code (and vice versa, if there is a notifier interface).
- To establish relationships between objects at runtime, adding or removing observers as needed.
- To keep components decoupled, since the Observable does not need to know the internal logic of its observers.


### Exercise

#### Implementing the Observer pattern in a stock market change notification system

#### Objective

Build a system in which a Stock Agent (Observable) automatically notifies several Stock Agencies (Observers) whenever a change occurs in the stock market state (rise or fall).

#### Description

Design a `StockAgent` class that:

- Allows observers to subscribe and unsubscribe.
- Has methods to simulate the stock market going up or down in share value.
- When the stock market goes up or down, automatically notifies all observers with a message indicating the change and the new stock value.

Also design several concrete observer classes that:

- Subscribe to the `StockAgent`.
- When notified, display the notification message on screen indicating whether the market went up or down and the current value.


#### Requirements

- The Observable object must maintain references to its observers.
- It must be possible to add and remove observers dynamically.
- When the `StockAgent` changes state (up or down), it must call `notifyObservers()`.
- Each observer must display the received message.
- The program must be tested with unit tests for:
    - Subscribing multiple observers to the stock agent.
    - Simulating stock market rises and falls.
    - Verifying that observers correctly receive and display the expected messages.


#### Expected test example (simplified)

```java
@Test
public void testStockAgentNotifications() {
   StockAgent agent = new StockAgent();

   Observer alphaBrokers = new StockBrokerAgency("Alpha Brokers");
   Observer zenithInvestments = new StockBrokerAgency("Zenith Investments");

   agent.addObserver(alphaBrokers);
   agent.addObserver(zenithInvestments);

   agent.stockMarketUp(150.75);
   // Expected console output:
   // Alpha Brokers received notification: Stock market went UP to 150.75
   // Zenith Investments received notification: Stock market went UP to 150.75

   agent.stockMarketDown(145.50);
   // Expected console output:
   // Alpha Brokers received notification: Stock market went DOWN to 145.50
   // Zenith Investments received notification: Stock market went DOWN to 145.50
}
```


## Level 3

### Decorator Pattern

#### What is it?

The Decorator pattern is a structural design pattern that allows additional functionality to be added to an object in a flexible and dynamic way, without modifying its original class.

Instead of creating subclasses for every combination of features, the Decorator pattern uses a hierarchy of objects that wrap (decorate) the original object to add new behavior.

#### Usefulness

The Decorator pattern is useful when:

- We want to add functionality flexibly, without bloating the class hierarchy.
- It would be awkward or impossible to extend an object’s behavior using inheritance.
- We have many customization options or feature combinations and want to avoid creating an excessive number of subclasses.

It is frequently used in user interface frameworks, file input/output systems, logging frameworks, and product customization systems.

#### Purpose

The main purpose of the Decorator pattern is:

- To add functionality to objects dynamically.
- To avoid creating multiple subclasses for every combination of behaviors.


### Exercise

#### Implementing the Decorator pattern for a Bubble Tea application

#### Objective

Implement a class design that simulates Bubble Tea customization, using the Decorator design pattern to add ingredients such as pearls, ice, sugar, etc.

#### Description

The goal is to build an application that allows creating Bubble Teas.

You can start with a base such as:

- Latte → 3.50 €
- Matcha → 3.20 €
- Tea → 3.00 €

And then add different decorations such as:

- Ice → +0.25 €
- Sugar → +0.30 €
- Tapioca → +0.50 €
- Added flavors → +0.60 € for each added flavor.

If two flavors are added, the total cost increases by +1.20 €.

Each addition modifies both the cost and the description of the drink. The goal is to use the Decorator pattern to compose drinks dynamically, without having to create subclasses for every possible combination.

#### Requirements

Create a `BubbleTea` interface with the following methods:

```java
String getDescription();
double getCost();
```

Implement the base classes (`LatteBase`, `MatchaBase`, `TeaBase`) that implement `BubbleTea`. Each base must have a different initial cost and its own description.

Create concrete decorators (e.g. `Ice`, `Sugar`, `Tapioca`, `Flavor`) that inherit from `BubbleTeaDecorator`.

Each decorator must add to both the cost and the description of the Bubble Tea.

Implement unit tests showing the creation of Bubble Teas with different combinations.

#### Expected usage example

```java
public class Main {
   public static void main(String[] args) {
      BubbleTea tea = new LatteBase(); // Latte base
      tea = new Tapioca(tea);
      tea = new Sugar(tea);
      tea = new Flavor(tea, "Maduixa");
      tea = new Flavor(tea, "Mango");

      System.out.println(tea.getDescription());
      // Output: Latte Bubble Tea + Tapioca + Sugar + Flavor: Maduixa + Flavor: Mango

      System.out.println(tea.getCost());
      // Output: 3.50 +0.50 +0.30 +0.60 +0.60 = 5.50
   }
}
```