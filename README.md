## HobbyLocale
This project was developed as **Full Stack Web Application**. Frontend was developed using `AngularJS 2` and `Bootstrap 4`. The backend was developed using `Node.js` over serverless architecture `Apache OpenWhisk` implementing `Microservices` and `MongoDB` as `NoSQL` database. The application would be a platform where people with similar hobbies would gather together, post and register to events regarding various hobbies, have healthy discussions about hobbies, rate and review events and hobbies. To view the events, user doesn't need to login but to post or register for an event, user need to create an account.

The following repositorries contain the code and detailed instructions about how to implement it. It contains repository for frontend application, all the backend microservices applications.

Front end application: https://github.com/deshpandega/client-app

Authentication microserices: https://github.com/deshpandega/login-action

Users microservices: https://github.com/deshpandega/user-action

Events microservices: https://github.com/deshpandega/events-action

----


## Data Analysis using Python
The following repository contains all the work done on **Data Analysis using Python** including midteerm and final project analysis.

https://github.com/deshpandega/deshpande_gaurang_spring2017

----


## Dynamic Procing - using Particle Swarm Optimization
This project was developed as part of **Data Structures and Algorithm** class. The objective of this project is to understand, practice and implement the swarm computing approach to find out the best price for products based on various factors in e-commerce application to maximize the revenue. Dynamic pricing is a strategy to modify the price of commodity over time, depending on various market scenarios, to obtain the optimum revenue.

#### Details: 

> **The project has following implementations:**
> 
> - Design & develop a standalone `Java` application implementing `PSO` to find maximum revenue for product depending on holidays, different time of year, quantity demand, variable cost changes with quantity of product to be sold, weather, etc.
> - PSO is implemented as a computational method that optimizes a problem by iteratively trying to improve a candidate solution with regard to a given measure of quality.
> - Solution is found out by having a population of candidate solutions, here dubbed as particles, and moving these particles around in the search-space according to simple mathematical formulae over the particle's position and velocity.
> - Each particle's movement is influenced by its local best known position, but is also guided toward the best-known positions in the search-space, which are updated as better positions are found by other particles.
> - Particle are plotted using jfreechart to display the overall swamp & global best price for maximum revenue.

----


## Big Data - 'Releasing Soon'
This project was developed as **Big Data** application implementing `Artificial Neural Network` using `genetic mutation algorithm`. Movie data set from `IMDB` was used to know about past released movies and factors like writers, directors, actors, actresses, etc. affecting the rating. The movie's fan count or marketing and publicity factor was also considered by using `Facebook graph API` and `Twitter API`.  The data was cleaned and fed to neural network to train the weights and the trained neural network was used to test the movie under consideration for prediction. Accuracy of the model was around 85%.

#### Details:


> **The project has following implementations:**
> 
> - Analyzed movie data comprising of IMDB, Facebook and Twitter. Real time Twitter and Facebook data on demand was collected. IMDB Data of over 40000 movies were extracted using `OMDB API`
> - Predicted the range of ratings (box office success) for a future movie.
> - Validated Rating for movies with past dated release movies
> - `IMDB` : Movie Name, Actors, Director, Writers, Ratings, Genre, Languages etc. There were 78 ratings, 25 genres, 14484 directors, 52120 actors, 47061 writers and 106 countires in 236 languages.
> - `Facebook` : Fan count and talk about count
> - `Twitter` : Tweets for particular movie. Received over 0.5MB data per movie. So to reduce the resource consumption, only useful data was extracted 
> - Used average over span and exponential normalization techniques to condition the data and fed to neural network to get predictions.

----


## NEU Events Webapp
This project was developed as **Full Stack Web Application**. Frontend was developed using HTML, along with Material Design libraries. The backend was developed using Spring MVC architecture and Hibernate to connect to MySQL database. The application would be a portal where people would post about events going on in and around campus. To view the events, user doesn't need to login but to post an event, user need to create an account with portal. 

#### Details:

> **The project has following implementations:**
> 
> - The front end was developed using `HTML`, `CSS3`, `JavaScript`, `AJAX`, `Material Design` libraries, `JSPs`, `Velocity`, `FreeMarker`, `PDF Views`.
> - Simple Forms with `Form Backing Object`, `Filters` and `Validators` and Normal HTML forms
> - Backend was developed using `Spring MVC` and `Hibernate` framework with HQL queries, SQL queries, Named Queries, Criteria Queries, Query By Example and *Annotation* and *XML based mapping*.
> - Password is stored with `SHA256 bit` hash based encoding in Database.
> - Connection pooling for database connections, Sending email for Forgot Password with encrypted password reset link.
> - Implemented `Twitter API` for collecting Twitter feeds about Northeastern University, Google Maps suggesting event places.

----


## Cybersecurity Implementation
This project was developed as **Java** application. The project is healthcare based application simulating hospital management system. The goal for developing this application was to understand all Java concepts like *Inheritance, Polymorphism, Abstraction and Encapsulation* and incorporate the necessary features demonstrating cybersecurity features. The application used `.db4o` files as database to store java objects as is. The project also has an application for patients suffering from Parkinson's disease to measure their responsiveness and to check if the medication they are receiving is effective or not.

#### Details:


> **The project has following implementations:**
> 
> - All users have secured work area and need login to access. Passwords have restrictions on size, uppercase, lowercase, digit usage and special character mandatory usage. 
> - All users accessing the system will generate logs as they access different screens. These logs which will be stored in encypted format using `Cipher`, `AES`, `Secret Key` and `Base64 encoder`.
> - `Log4j` is used to generate logs from all screens and actions taken by different users.
> - The project uses `singleton` pattern to create the entire system.
> - `DB4O` files are used to store java objects as is.
> - The system is request based. If any modifications required to data entered would need permission from admin.
> - There is a role for Security team member to monitor every users activities by accessing the logs.
> - The application for patients has two methods to capture patient's responsiveness, both using hand to eye coordination of patient and their ability to tap the correct button. The data from patient's test results are visible to their respective doctors only in a visual format.
> - Backup of the entire system data (db4o file) is generated every 12 seconds. The frequency to capture backup can be configured.
> - Provision to send email to users 

----

## Hospital Management DB
This project was developed as **Database** application. The application used MySQL and Mongo DB as database simulating a database design for a hospital management system. Implemented the concepts like database design principles, EER diagram, relational model, queries, stored procedures, triggers, users, views, transactions, privileges, backups, subqueries, joins, normalization techniques, indexing and functions.

#### Details:


> **The project has following implementations:**
> 
> - Kept the normalization up-to `3NF` only
> - Tried to eliminate all `insert, update and delete anomalies` by cascading and/or restricting the update and delete operations in case of `foreign key constraints`
> - Created different users and granted respective `privileges` to each user
> - Inserted data using `csv import` method
> - Implemented `Views` for calculating prescription billing 
> - Implemented `stored procedures` to calculate bill for a patient 
> - Implemented stored procedure to `debug` a stored procedure
> - Implemented `triggers` for auditing purposes, auto modification of data in next check-in date for patient on booking appointment and validating email and contact number in person table
> - Implemented the backup features using `command line, workbench, and shell scripts`
> - Uploaded the backed up files on `AWS RDS` instance
> - Implemented `mongodb` as document database for storing hospital system data in NoSQL format
> - Implemented `indexing` on patient and staff for person column
> - Implemented queries that simulate transactions, subqueries, joins and functions

----

## User Experience Information Systems Website
This project was developed as **User Experience Design** project. Different UX techniques were used to come up with requirements, prioritizing requirements, developing the Information Architecture, developing the wireframes and prototypes, and HTML5, CSS3, JavaScript, Bootstrap and Material Design libraries were used to develop the frontend. Automation testing was done along with browser compatibility testing and usability testing with actual users.

#### Details:

> **The project has following implementations:**
> 
> - The strategy for coming up with this project was to gather all information regarding the Information Systems program under one roof.
> - Storyboarding and Personnas were created for coming up with requirements.
> - Surveys and Interviews were used to prioritize requirements.
> - Closed Card Sorting technique was used to complete Information Architecture.
> - Balsamiq tool was used to complete wireframing and prototyping for the entire application.
> - Front-end was developed using HTML5, CSS3, JavaScript, Bootstrap and Material Design libraries.
> - Selenium tool was used to complete automation testing. Manual testing for browser compatibility testing and manual testing for usability testing with actual users. The modifications required from the response were implemented.

----