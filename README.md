# lib16 Array Utilities
Some array utility functions not only for lib16.

## Basic Usage
### The `Arrays` class
```java
Integer[] array = new Integer[] {1, 2 ,3, 4, 5, 6, 7};
Arrays.reverse(array);               // 7, 6, 5, 4, 3, 2, 1
```
```java
Arrays.reverse(array, 2, 5);         // 1, 2, 5, 4, 3, 6, 7
```
```java
Arrays.rotate(array, 2);             // 3, 4, 5, 6, 7, 1, 2
```
```java
Arrays.rotate(array, -1, 1, 5);      // 1, 5, 2, 3, 4, 6, 7
```
```java
Random random = new Random();
Arrays.shuffle(array, random);       // 2, 3, 6, 1, 7, 5, 4
```
```java
Arrays.shuffle(array, random, 2, 6); // 1, 2, 5, 4, 6, 3, 7
```
```java
Arrays.swap(array, 1, 3);            // 1, 4, 3, 2, 5, 6, 7
```

### The `Arrays2D` class
```java
Integer[] array = new Integer[] {
        {1, 2 ,3},
        {4, 5, 6},
        {7, 8, 9}
};
Arrays2D.reverseX(array);                    // 3, 2, 1
                                             // 6, 5, 4
                                             // 9, 8, 7
```
```java
Arrays2D.reverseX(array, 1, 0, 3, 2);        // 1, 3, 2
                                             // 4, 6, 5
                                             // 7, 8, 9
```
```java
Arrays2D.reverseY(array);                    // 7, 8, 9
                                             // 4, 5, 6
                                             // 1, 2, 3
```
```java
Arrays2D.reverseY(array, 1, 0, 3, 2);        // 1, 5, 6
                                             // 4, 2, 3
                                             // 7, 8, 9
```
```java
Arrays2D.rotateX(array, 1);                  // 2, 3, 1
                                             // 5, 6, 4
                                             // 8, 9, 7
```
```java
Arrays2D.rotateX(array, 1, 0, 0, 3, 2);      // 2, 3, 1
                                             // 5, 6, 4
                                             // 7, 8, 9
```
```java
Arrays2D.rotateY(array, -1);                 // 7, 8, 9
                                             // 1, 2, 3
                                             // 4, 5, 6
```
```java
Arrays2D.rotateY(array, 1, 0, 3, 3);         // 1, 5, 6
                                             // 4, 8, 9
                                             // 7, 2, 3
```
```java
Arrays2D.shuffle(array, random);             // 2, 7, 1
                                             // 9, 5, 4
                                             // 8, 3, 6
```
```java
Arrays2D.shuffle(array, random, 1, 0, 3, 2); // 2, 7, 1
                                             // 9, 5, 4
                                             // 8, 3, 6
```
```java
Arrays2D.swap(array, 1, 0, 2, 2);            // 1, 9, 3
                                             // 4, 5, 6
                                             // 7, 8, 2
```