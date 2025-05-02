
package controllers

import scala.collection.mutable
import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import play.twirl.api.Html
import views.html.{index, details}

import models.Product

@Singleton
class ProductController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  private val products = mutable.ListBuffer(
    Product(1, "Laptop", 3500),
    Product(2, "Phone", 2000)
  )

  def index() = getAll()

  def getAll() = Action {
    Ok(Json.toJson(products))
  }

  def list() = Action {
    Ok(Json.toJson(products))
  }

  def get(id: Long) = Action {
    Ok(details(id))
  }

  def create() = Action {
    Created("Produkt utworzony")
  }

  def delete(id: Long) = Action {
    Ok(s"Produkt o ID: $id został usunięty")
  }
}
