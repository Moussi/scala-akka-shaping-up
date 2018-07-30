package akka

import akka.MusicController.{PlayMusicMsg, StopMusicMsg}
import akka.MusicPlayer.{Play, Stop}
import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by amoussi on 30/07/18.
  */

object MusicController {

    sealed trait MusicMsg
    case class PlayMusicMsg(who: String) extends MusicMsg

    case class StopMusicMsg(who: String) extends MusicMsg

    val props = Props[MusicController]
}

class MusicController extends Actor {

    def receive = {
        case PlayMusicMsg(who) => println(s" play music for $who")
        case StopMusicMsg(who) => println(s" stop music for $who")
        case _ => println("unrecognized music controller action")
    }
}

object MusicPlayer {
    sealed trait PlayerMsg
    case class Play(piste:String) extends PlayerMsg
    case class Stop(piste:String) extends PlayerMsg
    val props = Props[MusicPlayer]
}

class MusicPlayer extends Actor{
 def receive = {
     case Play(piste) => val musicControllerActor = context.actorOf(MusicController.props, "musicController")
         musicControllerActor ! PlayMusicMsg(piste)
     case Stop(piste) => val musicControllerActor = context.actorOf(MusicController.props, "musicController")
         musicControllerActor ! StopMusicMsg(piste)
     case _ => println("unrecognized message")
 }
}

object  player extends App{

    val system = ActorSystem("musicPlayer")
    val musicPlayer = system.actorOf(MusicPlayer.props, "musicPlayer")

    musicPlayer ! Play("Afassi Quran")
    musicPlayer ! Stop("Ali Jaber Quran")

    system.terminate
}
