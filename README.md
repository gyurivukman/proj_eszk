Yet Another Online Recipe And Shoppling List
===============================

This is an **Angular2** and **SpringBoot** based web application combining a recipebook with the ability create your own shopping lists.
- You can browse anonimously or as a registered user
- Users have the ability to add recipes with ingredients and steps, edit them if it belongs to them and add comments to recipes. The required data for these operations are stored in a MySQL database
- Users can search for recipes based on ingredients, tags or name
- Users can cherry-pick recipe ingredients to add to their shopping list - or add all of them if none are selected

#Server Side
-------------
The backend or server side is a gradle and springboot based,Model-Controller project without Views,as the Frontend takes care of that and the Backend only deals with data and business logic.

We use a MySQL database with liquibase as our chosen migration management tool.

## Endpoints
/api
 - /user
   * /login
   * /register
   * /{id}
    - /recipes

 - /recipe
   * /{id}
    -/picture
   
## Testing
Server side testing is JUnit based.

# Frontend

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.7.4. It is based on Angular2/4 with plain Bootstrap 4.0 for CSS.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).


Screenshots
-----------
![alt text](https://imgur.com/HhBuCyx.jpg)


# Install for development

Frontend
-----------
1. Install NodeJS from `http://nodejs.org`. Make sure to include npm in your path variable!
2. Install angular-cli with the following command: `npm install @angular/cli --save`
3. Clone this repository
4. Navigate to `/cloned_repo_location/Frontend/` and issue the following command: `npm install`. This will install all the dependencies and as such, it might take some time.
5. Run `npm start` for the local dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

Backend
-----------
1. Install MySQL and start the MySQL server on localhost:3306, with the username/password of root/root for the database. (Note:   This is configurable later in the application.properties file)
2. Use your favourite GUI based SQL tool or plain terminal to create a database with the name: **proj_eszk**
3. Install IntelliJ Ultimate and import the backend by using import project and selecting the build.gradle file in Backend/
4. Tick the "Use Auto Import" checkbox at the top
5. Go to File/Settings/Build,Execution,Deployment/Compiler/Annotation Processors. Tick the *Enable Annotation Processing* checkbox. This is required for the **Lombok Plugin**.
6. Nagivate to /Backend/ and open a command line terminal, then type *gradle update -PrunList=migrate* to migrate the database
7. Optionally, you can put some demo data in the database by issuing *gradle update -PrunList=seeddemo*
8. You can now start your development server (embedded tomcat) in the upper right corner with the green triangle.


Database model
----------------
placeholder


Class Diagram
-------------
placeholder


Use Case Diagram
----------------
placeholder
![alt text](https://imgur.com/SO2ReVg.png)


Improvement ideas
-----------------------
- The app could use an already existing REST API (such as Tesco's) to get an approximation for prices on the shopping list.
- Some kind of google map integration to point the user towards the nearest shops she/he can buy the items on the shopping list.
