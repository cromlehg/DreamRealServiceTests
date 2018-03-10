package com.inaword.drlt

import scalaj.http.Http
import scalaj.http.HttpOptions

object Runner2 extends App {

  val limit = 10

  val start = System.currentTimeMillis

  for (i <- 1 to limit) {
    val result = Http("http://dreamvp.com:9080/api/v1").postData("""{"name": "getPosts", "page_id": 1, "filter": "new"}""")
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString
  }

  println(System.currentTimeMillis - start)

}
