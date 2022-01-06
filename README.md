# api-communicator

> **Created By Marco Tahat**

This is Simple Java/gradle application shows how to communicate and consume rest service.
this application has been develop for interview perp.

>**Install & Run Application**
Pleae use Gradle to build the project dependencies, so after you clone this project 
follow these stesps: (Eclipe)
 - from eclipse main menu go to File > import
 - Select **Existing gradle Project** > Project Root Directory
 - Browser to your project root 'your local path'\api-communicator
 - Click **Finish** the project will be imported.
 - Navigate to **RestApplication.java** in src/main/java
 - Right Click on the Class name, then choose **Run As Java Application**
 - From the **Console View** Enter your Input.
 - Any time you can exit by typing **Exit**
 - DONE! 

> **The Design**

![design](https://user-images.githubusercontent.com/45109004/48676622-e783d600-eb2e-11e8-9222-0cb591d36529.png)

> **Main Classes**

**RestApplication.java** : 
Main Method, run this project as Java Application 
   - param > **RestClient** : the client to consume the API
   - param > **input** : User input from console, this is case 
   - Accepted Inputs: Case Sensitive
    - state code: two letters Upper Case for example; NY
    - state name: first letter should be upper case, for example: New York
    - all : shows you total number of states hosted by the service.
   - return > **results** taken from the response.
   
> **Main Integration Test**

**RestApplicationTest.java** : Parameterized test, this covers 
 - all happy scenarios for the 55 
 - states that the service support, plus the 'all' option.
 - also this class cover the integration part between the Application, Domain and Util classes.
 

 
 

