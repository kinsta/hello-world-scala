![Photo by Madison Oren on Unsplash](https://user-images.githubusercontent.com/2342458/202707015-13fe70e3-539e-418f-9b82-e38cca652cb4.png)

# Kinsta - Hello World - Scala
An example of how to set your Scala application up to enable deployment on Kinsta App Hosting services.

---
Kinsta is a developer-centric cloud host / PaaS. We’re striving to make it easier for you to share your web projects with your users. Focus on coding and building, and we’ll take care of deployment and provide fast, scalable hosting. + 24/7 expert-only support.

- [Start your free trial](https://kinsta.com/signup/?product_type=app-db)
- [Application Hosting](https://kinsta.com/application-hosting)
- [Database Hosting](https://kinsta.com/database-hosting)

## Dependency Management
During the deployment process Kinsta will automatically install dependencies defined in your `build.sbt` file.

## Web Server Setup

### Port
Kinsta automatically sets the `PORT` environment variable. You should **not** define it yourself and you should 
**not** hard-code it into the application. Use `scala.util.Properties.envOrElse("PORT", "8080")` in your code when referring to the server port. 

### Start Command
When deploying an application Kinsta will automatically create a web process with the built executable as the entry point.
