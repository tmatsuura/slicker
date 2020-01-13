package com.slicker

import slick.jdbc.MySQLProfile.api._

package object query {
  val db = Database.forConfig("mydb")
}
