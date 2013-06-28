package controllers;

import models.dao.ProviderDAO;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Controller for the {@link Provider}
 * @author Matias Niklison &lt;matias.niklison@gmail.com&gt;
 */
public class ProviderController extends Controller {

  /**
   * Provider DAO.
   */
  private static ProviderDAO providerDAO = new ProviderDAO();

  /**
   * CRUD Controller.
   */
  private static ProviderCRUDController providerCRUDController =
      new ProviderCRUDController(providerDAO);

  /**
   * Rest Controller.s
   */
  private static ProviderRESTController restController =
      new ProviderRESTController(providerDAO);

  public static Result index() {
    return providerCRUDController.list(0);
  }

  public static Result providerList(final Integer page) {
     return providerCRUDController.list(page);
  }

  public static Result providerNewForm() {
     return providerCRUDController.newForm();
  }

  public static Result providerCreate() {
     return providerCRUDController.create();
  }

  public static Result providerEditForm(final Long key) {
     return providerCRUDController.editForm(key);
  }

  public static Result providerUpdate(final Long key) {
     return providerCRUDController.update(key);
  }

  public static Result providerDelete(final Long key) {
     return providerCRUDController.delete(key);
  }

  public static Result providerShow(final Long key) {
     return providerCRUDController.show(key);
  }

  /* ************************************************** */

  public static Result restList() {
    return restController.list();
  }

  public static Result restCreate() {
    return restController.create();
  }

  public static Result restUpdate(Long key) {
    return restController.update(key);
  }

  public static Result restDelete(Long key) {
    return restController.delete(key);
  }

  public static Result restGet(Long key) {
    return restController.get(key);
  }
}
