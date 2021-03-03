# Java 8 Default method

Java 8 enables us to add non-abstract method implementation to interfaces by utilizing the  ```default``` keyword. This feature is also know as **Extension methods.

## Example 1

```java
interface Formula{
    double calculate(int a);
    default double sqrt(){
        return Math.Sqrt(a);
    }
}
```

Besides the abstract method ```calculate``` the interface ```Formula``` also defines the default method ```sqrt```. Concrete classes only have to implement the abstract method ```calculate```. The default method ```sqrt``` can be used out of the box.

```java
Formula formula = new Formula() {
    @Override
    public double calculate(int a) {
        return sqrt(a * 100);
    }
};

formula.calculate(100);     // 100.0
formula.sqrt(16);           // 4.0
```

