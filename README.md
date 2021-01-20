## Word Count API 1.0
 
This REST API provides a list of n number of most occurring words in a sample text in decreasing order, where n is provided as a parameter.


Example: http://localhost:8080/getTopResultsApi?count=4
```
{
   "wordOne": 91,
   "wordTwo": 80,
   "wordThree": 70,
   "wordFour": 60
}
```
The sample text used for this application was generated using http://www.dummytextgenerator.com/#jump and can be found here `/resources/sample.txt`.


### Assignment
This Word Count API is not perfect and currently has minor and major flaws. Imagine this entire application coming to you as a pull request.
Make any changes you would suggest regarding any general issues, optimisations, quality improvements or modernisations to this code. This includes the entire project with all its files!   

Commit your changes to the provided feature branch `feature-2.0` and send the zipped Git project back to us. 
For any additional recommendations and comments you want to provide, please add a new section to this README file.

 
### Installation
 1. Compile with mvn install
 2. Run Main.java
 3. Open browser on http://localhost:8080/swagger-ui.html
 
Details for basic in-memory login for the 2 default users:

| User          | Password      |
| ------------- |:-------------:|
| admin         | *password*    |
| user          | *password*    |

### License 
TPG Telecom
 