# ShoppingCart

Build with `mvn clean install`.

Run application with `java -jar ./target/shopping-cart.jar <<path-to-product-list-file>>` for example:

-	`java -jar ./target/shopping-cart.jar sampleProducts1.txt`
-	`java -jar ./target/shopping-cart.jar sampleProducts2.txt`
-	`java -jar ./target/shopping-cart.jar sampleProducts3.txt`

Sample input (products list):
```
Apple
Papaya
Banana
Papaya
Papaya
Orange
Papaya
Papaya
```


Sample output:
```
Product name        |Unit price  |Quantity  |Discounts                               |Price     
-------------------------------------------------------------------------------------------------------------------
Banana              |$0.15       |1         |                                        |$0.15     
Orange              |$0.30       |1         |                                        |$0.30     
Papaya              |$0.25       |5         |Get 3 pay for 2. (- $0.25)              |$1.00     
Apple               |$0.25       |1         |                                        |$0.25     
-------------------------------------------------------------------------------------------------------------------
                                                                        Total price: |$1.70     
```