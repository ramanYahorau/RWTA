#### How to run a test:
##### 1)Create TestNG configuration
##### 2)Select test Class and test Method(leave method field empty if you want to run whole test Class)
##### 3)add '-ea -Dselenide.browser="browserType" -Dselenide.timeout="timeOut" to VM options
##### 4)example: '-ea -Dselenide.browser="chrome" -Dselenide.timeout=15000' 
##### 5)Save configuration
##### 5)add the same <browserType> to the setDriverProperties(<browserType>) method in @BeforeClass  
##### 6)Run created TestNG configuration  
