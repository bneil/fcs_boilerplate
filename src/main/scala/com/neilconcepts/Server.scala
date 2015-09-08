package com.neilconcepts

import com.twitter.finagle.Httpx
import com.twitter.util.Await
import io.finch.route._
import io.finch.request._

object Server extends App {
  val title: RequestReader[String] = paramOption("title").withDefault("")

  println("woot1")
  val api: Router[String] =
    get(("hello" | "hi") / string ? title) { (name: String, title: String) =>
      s"Hello, $title $name!"
    }

  println("woot2")
  Await.ready(Httpx.serve(":8080", api.toService))
}
