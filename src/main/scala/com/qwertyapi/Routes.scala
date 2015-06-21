package com.qwertyapi

import com.qwertyapi.models.{Message, Link}
import org.scalatra._
import org.json4s._
import org.scalatra.json._
import scalate.ScalateSupport

class Routes extends QwertyapiStack with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  protected override def transformRequestBody(body: JValue): JValue = body.camelizeKeys

  protected override def transformResponseBody(body: JValue): JValue = body.underscoreKeys

  get("*?") {
    val message = Message(Seq("Not found"))
    NotFound(message)
  }

  get("/?") {
    Ok()
  }

  before() {
    contentType = formats("json")
  }

}
