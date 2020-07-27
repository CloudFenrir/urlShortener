# urlShortener
This is a url shortener made on Java with Springboot

This application was made on Java 8.

Here is what you need to make this application work on your local:
- make sure that port 8080 is available.
- Java JDK 8 installed.
- Postman

How to use it:
Just run the application and go to Postman.
For a POST action Use the url http://localhost:8080/api/url, then in the text field section write something like: 
[
  "url":"www.nearsoft.com" 
]

For a GET action use the url http://localhost:8080/api/shorturl 
changing the shorturl with the actual url provided by the post action.

I hope this was useful and I am hoping this project is good enough to be part of the team =D

