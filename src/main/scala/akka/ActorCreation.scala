package akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by amoussi on 30/07/18.
  */

class GreetingActor extends Actor {
    def receive = {
        case "hello" => println("helloo")
        case _ => println("Not Recognized message")
    }
}

object main extends App {

    val system = ActorSystem("GreetingActor")

    val greetingActor = system.actorOf(Props[GreetingActor], "greeting")

    greetingActor ! "hello"
    greetingActor ! "Salem"

    system.terminate
}

