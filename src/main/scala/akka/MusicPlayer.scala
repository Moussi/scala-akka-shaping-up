package akka

import akka.MusicController.{PlayMusicMsg, StopMusicMsg}
import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by amoussi on 30/07/18.
  */
class MusicPlayer {

}

object MusicController {

    case class PlayMusicMsg(who: String)

    case class StopMusicMsg(who: String)

    val props = Props[MusicController]
}

class MusicController extends Actor {

    def receive = {
        case PlayMusicMsg(who) => println(s" play music for $who")
        case StopMusicMsg(who) => println(s" stop music for $who")
        case _ => println("unrecognized music player action")
    }
}

object  player extends App{

    val system = ActorSystem("musicPlayer")
    val musicController = system.actorOf(MusicController.props, "musicController")

    musicController ! PlayMusicMsg("Afassi Quran")
    musicController ! StopMusicMsg("Ali Jaber Quran")

    system.terminate
}
