# api-communicator

> **Created By Marco Tahat**

This is Simple Java/gradle application shows how to communicate and consume rest service.
this application has been develop for interview purposes.

>**Install & Run Application**
- [ ] **Task 1**: Please use Gradle to build the project dependencies, after you clone the project, fill out the required dependencies listed in the build.gralde file, feel free to use any gradle/java plugins. you can use your own **build.gradle** file as well. hint: use the right version for each library from maven repo https://mvnrepository.com. if needed, modify the code to make it work with the latests Library for each depedency. use "**implementation** and **testImplementation** for dependencies. 

follow these stesps: (Eclipe)
 - from eclipse main menu go to File > import
 - Select **Existing gradle Project** > Project Root Directory
 - Browser to your project root 'your local path'\QA-assessment
 - Click **Finish** the project will be imported.
 - Navigate to **RestApplication.java** in src/main/java
 - Right Click on the Class name, then choose **Run As Java Application**
 - From the **Console View** Enter your Input.
 - Any time you can exit by typing **Exit**
 - DONE! 

- [ ] **Task 2**: Please fix any compile issues before modifying the code.

> **The Design**
- [ ] **Task 3**: Use https://datausa.io/about/api/ to build simple Java Console Apps that takes State Name/Two Letter Codes and Returns the following information:
        - State Total Population.
        - State Capital City. 
        - State Largest City.
* Sample: output: 
``` 
Input: Texas
Output: Capital City: Austin
        Largest City: Houston 
        Population: 39M
```
- [ ] **Task 4**: Optional- Implement a method to return all valid/supported States in this Service. 
```
Input: ALL States
Output: "AL, AS, ...,TX, WA" 
```
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

**CongifUtil.java** 
Use this class to configure you Service Base URL, PORT & Host Names.

> **Main Integration Test**
- [ ] **Please add/modify any test needed for this project.** and make sure the existed tests are running green.

**RestApplicationTest.java** : Parameterized test using HamCrest, this covers 
 - all happy scenarios for the 55 
 - states that the service support, plus the 'all' option.
 - also this class cover the integration part between the Application, Domain and Util classes.

> **PART TWO: UI Tests** 
- [ ] **Task 1**: write simple UI test ( Using Cypress is big plus) that utilize https://datausa.io/ UI to do the following: 
    - Search for Texas in the main serach box. 
    - Assert that: 
      - 2019 POPULATION is : 29M
      - US SENATORs: John Cornyn, Ted Cruz
      - 2019 MEDIAN AGE : 35.1
- [ ] **Task 2**
    - Choose CoVid 19 stats and Collect the following:
       - CONFIRMED CASES, DEATHS, CASES PER CAPITA
    - Take Screenshots for Data Dashboard. 
- [ ] **Task 3**
    - Use any Reporting tool to show the results -- ( Allure Reporting is preferred)


 

 
 

