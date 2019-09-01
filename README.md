# Spring MVC Weather Application

This application helps to get the Weather Information for different cities. Based on the API call made to the https://openweathermap.org/current <br>
It will provide the out and the json response gets parsed and returned to the UI through Spring MVC.

<b> Features Implemented : </b>

* <p> UI designed using jsp and made jQuery Ajax call to the Spring MVC. </p>
* <p> Spring MVC Controller handles the request and make calls to the https://openweathermap.org/current. </p>
* <p> Internalization implemented using Spring.</p>
* <p> This API help to get the details for only 1 city.</p>

<strong> BUILD the application as Maven Project </strong>

> mvn clean install

<strong> DEPLOY the application to the Tomcat </strong>

> Copy weather-app.war from target folder and deploy it to the Tomcat.
