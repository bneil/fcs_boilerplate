package com.neilconcepts

import io.finch._
import com.twitter.finagle.Http
import com.twitter.util.Await

object Server extends App {
  val api: Endpoint[String] = get("hello") { Ok("Hello, World!") }

  Await.ready(Http.serve(":8080", api.toService))
}
