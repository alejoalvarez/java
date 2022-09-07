# **Marker Interface In Java**

A marker interface in Java is an empty interface that has no fields or methods. This marker interface tells the compiler that the objects of the class that implement the marker interface are different and that they should be treated differently.

Each marker interface in Java indicates that it represents something special to JVM or compiler.

**In Java, we have three interfaces that are Marker interfaces as shown below:**

**1) Serializable interface:** 

Serializable is a marker interface present in the java.io package. We can serialize objects using this interface i.e. save the object state into a file.

**2) Cloneable interface:**

The cloneable interface is a part of the java.lang package and allows the objects to be cloned.

**3) Remote interface:**

The remote interface is a part of the java.RMI package and we use this interface to create RMI applications. This interface mainly deals with remote objects.
