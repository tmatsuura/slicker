package com.slicker.query

import com.slicker.entity.Tables.Coffees
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Select {
  def main(args: Array[String]): Unit = {
    val q = Coffees.filter(_.price > 8.0)
    println(q.result.statements.head)

    val action = q.result
    val result = Await.result(db.run(action), Duration.Inf)
    println(result)
  }
}
