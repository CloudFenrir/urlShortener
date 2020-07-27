# urlShortener
This is a url shortener made on Java with Springboot.
Basically with this url shortener you can introduce any url and it will return a shorter url for it. When you introduce this short url it should return the entire url of which this was created.
Whenever you introduce any url that contains Google, the short url will be created with a length of 5 and only using alpha characters. Also for anu url that contains Yahoo, the short url will be created with a length of 7 and only using alphanumeric characters. For the rest of url, the short url will be created by removing special characters, vowels and numbers from it.

This application was made on Java 8.

Here is what you need to make this application work on your local:
- Make sure that port 8080 is available.
- Java JDK 8 installed.
- Postman

I designed the project with Model, Controller and Service classes in order to make it easier to understand and following good practices of programming. 

How to use it:
Just run the application and go to Postman.
For a POST action Use the url http://localhost:8080/api/url, then in the text field section write something like: 
[
  "url":"www.nearsoft.com" 
]

For a GET action use the url http://localhost:8080/api/shorturl 
changing the shorturl with the actual url provided by the post action.

I hope this was useful and I am hoping this project is good enough to be part of the team =D

