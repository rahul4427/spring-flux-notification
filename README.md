# User notification with web-flux and Server-Sent-Event(SSE)

This Application allows a user to receive any notification generated at any event(ex message by anyone, any broadcast message, etc). 
</br>
## Thought process and problem solving
I wanted to create a system where-in a user can receive his/her updates without continous polling of timely polling. My requirement 
was to establish a continous connection where the server can send data to the client whenever it wants
</br>

## Demo
Clicking on the below link will take you to a UI where the streaming output gets printed whenever a notification is received.
In Order to subscribe as a particular user, replace the userName in the below URL(**"/?user=*userName*"**) and you will be subscribed to receive notification
of that user
```
https://webfluxnotification.herokuapp.com/?user=userName
```
</br>

In Order to Send a message to any user in order to notify them, user the swagger documentation UI accessibile in to below URL
```
https://webfluxnotification.herokuapp.com/swagger-ui.html
```

Just go to above URL followed by -> Notify -> /send-message </br>
Use the below sample Json for creating the request.
</br>
```json
{
  "eventString": "Sample Notification",
  "sender": "Rahul",
  "userName": "userName"
}
```
</br>

## Key Technologies, Frameworks and tools used:
* [Spring Web-Flux](https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/web-reactive.html)
* [Server-Sent-Event](https://medium.com/conectric-networks/a-look-at-server-sent-events-54a77f8d6ff7)
* [Swagger](https://swagger.io/about/)
* [HTML, CSS, JS](https://www.w3schools.com/html/html_scripts.asp)

