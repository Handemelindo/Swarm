package org.swarmframework.demos

import org.swarmframework.transport._
import org.swarmframework.internal._
import org.swarmframework.core.Swarm._

import java.net.InetAddress

object ExplicitMoveTo1 extends App {
  implicit val tx = InetTransporter
  InetTransporter.listen(9998)

  spawn {
    val name = readLine("What is your name? ")
    moveTo(InetLocation(InetAddress.getLocalHost, 9997))
    val age = Integer.parseInt(readLine(s"Hello $name, what age are you? "))
    moveTo(InetLocation(InetAddress.getLocalHost, 9998))
    println(s"Wow $name you're half way to ${age * 2} years old!")
    NoBee()
  }
}