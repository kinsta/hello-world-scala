import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.stream.ActorMaterializer

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object HelloWorld extends App {

  implicit val system: ActorSystem = ActorSystem("ProxySystem")
  implicit val mat: ActorMaterializer = ActorMaterializer()

  val route: Route = get {
    pathSingleSlash {
      // https://stackoverflow.com/a/68588177/594538
      import java.io.FileInputStream
      import java.util.jar.JarInputStream

      val scala3LibJar = classOf[CanEqual[_, _]].getProtectionDomain.getCodeSource.getLocation.toURI.getPath
      val manifest = new JarInputStream(new FileInputStream(scala3LibJar)).getManifest
      val runtimeVersion = manifest.getMainAttributes.getValue("Implementation-Version")

      complete(
        "Hello World\n" +
        "scala runtime: " + runtimeVersion + "\n" +
        "scala stdlib: " + scala.util.Properties.versionNumberString + "\n" +
        "java: " + scala.util.Properties.javaVersion)
    }
  }
  val port = (scala.util.Properties.envOrElse("PORT", "8080")).toInt
  val bindingFuture = Http().bindAndHandle(Route.handlerFlow(route), "0.0.0.0", port = port)

  Await.result(system.whenTerminated, Duration.Inf)

}
