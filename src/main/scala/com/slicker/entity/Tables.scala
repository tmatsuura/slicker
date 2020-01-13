package com.slicker.entity
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Coffees.schema ++ GooseDbVersion.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Coffees
   *  @param cofName Database column cof_name SqlType(VARCHAR), PrimaryKey, Length(255,true)
   *  @param supId Database column sup_id SqlType(INT), Default(None)
   *  @param price Database column price SqlType(DOUBLE), Default(None)
   *  @param sales Database column sales SqlType(INT), Default(Some(0))
   *  @param total Database column total SqlType(INT), Default(Some(0)) */
  case class CoffeesRow(cofName: String, supId: Option[Int] = None, price: Option[Double] = None, sales: Option[Int] = Some(0), total: Option[Int] = Some(0))
  /** GetResult implicit for fetching CoffeesRow objects using plain SQL queries */
  implicit def GetResultCoffeesRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[Double]]): GR[CoffeesRow] = GR{
    prs => import prs._
    CoffeesRow.tupled((<<[String], <<?[Int], <<?[Double], <<?[Int], <<?[Int]))
  }
  /** Table description of table coffees. Objects of this class serve as prototypes for rows in queries. */
  class Coffees(_tableTag: Tag) extends profile.api.Table[CoffeesRow](_tableTag, Some("rssp"), "coffees") {
    def * = (cofName, supId, price, sales, total) <> (CoffeesRow.tupled, CoffeesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(cofName), supId, price, sales, total)).shaped.<>({r=>import r._; _1.map(_=> CoffeesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column cof_name SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val cofName: Rep[String] = column[String]("cof_name", O.PrimaryKey, O.Length(255,varying=true))
    /** Database column sup_id SqlType(INT), Default(None) */
    val supId: Rep[Option[Int]] = column[Option[Int]]("sup_id", O.Default(None))
    /** Database column price SqlType(DOUBLE), Default(None) */
    val price: Rep[Option[Double]] = column[Option[Double]]("price", O.Default(None))
    /** Database column sales SqlType(INT), Default(Some(0)) */
    val sales: Rep[Option[Int]] = column[Option[Int]]("sales", O.Default(Some(0)))
    /** Database column total SqlType(INT), Default(Some(0)) */
    val total: Rep[Option[Int]] = column[Option[Int]]("total", O.Default(Some(0)))
  }
  /** Collection-like TableQuery object for table Coffees */
  lazy val Coffees = new TableQuery(tag => new Coffees(tag))

  /** Entity class storing rows of table GooseDbVersion
   *  @param id Database column id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey
   *  @param versionId Database column version_id SqlType(BIGINT)
   *  @param isApplied Database column is_applied SqlType(BIT)
   *  @param tstamp Database column tstamp SqlType(TIMESTAMP) */
  case class GooseDbVersionRow(id: Long, versionId: Long, isApplied: Boolean, tstamp: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching GooseDbVersionRow objects using plain SQL queries */
  implicit def GetResultGooseDbVersionRow(implicit e0: GR[Long], e1: GR[Boolean], e2: GR[Option[java.sql.Timestamp]]): GR[GooseDbVersionRow] = GR{
    prs => import prs._
    GooseDbVersionRow.tupled((<<[Long], <<[Long], <<[Boolean], <<?[java.sql.Timestamp]))
  }
  /** Table description of table goose_db_version. Objects of this class serve as prototypes for rows in queries. */
  class GooseDbVersion(_tableTag: Tag) extends profile.api.Table[GooseDbVersionRow](_tableTag, Some("rssp"), "goose_db_version") {
    def * = (id, versionId, isApplied, tstamp) <> (GooseDbVersionRow.tupled, GooseDbVersionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(versionId), Rep.Some(isApplied), tstamp)).shaped.<>({r=>import r._; _1.map(_=> GooseDbVersionRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column version_id SqlType(BIGINT) */
    val versionId: Rep[Long] = column[Long]("version_id")
    /** Database column is_applied SqlType(BIT) */
    val isApplied: Rep[Boolean] = column[Boolean]("is_applied")
    /** Database column tstamp SqlType(TIMESTAMP) */
    val tstamp: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("tstamp")
  }
  /** Collection-like TableQuery object for table GooseDbVersion */
  lazy val GooseDbVersion = new TableQuery(tag => new GooseDbVersion(tag))
}
