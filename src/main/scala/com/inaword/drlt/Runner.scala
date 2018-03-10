package com.inaword.drlt

import scalaj.http.Http
import scalaj.http.HttpOptions

object Runner extends App {

  val limit = 100

  val start1 = System.currentTimeMillis

  var size1 = 0

  for (i <- 1 to limit) {
    val result = Http("http://dreamvp.com:9080/api/v1").postData("""{"name": "getPosts", "page_id": 1, "filter": "new"}""")
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString
    size1 = result.body.length
  }

  val time1 = System.currentTimeMillis - start1

  val start2 = System.currentTimeMillis

  var size2 = 0

  for (i <- 1 to limit) {
    val result = Http("http://dreamvp.com:9080/api/v1").postData("""{"name": "getPosts2", "page_id": 1, "filter": "new"}""")
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString
    size2 = result.body.length
  }
  val time2 = System.currentTimeMillis - start2

  println("limit " + limit + ", time: " + time1 + "ms" + ", size " + size1)
  println("limit " + limit + ", time: " + time2 + "ms" + ", size " + size2)

}
