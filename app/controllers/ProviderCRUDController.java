package controllers;

import static play.data.Form.*;
import models.Provider;
import models.dao.ProviderDAO;
import play.mvc.Call;
import play.utils.crud.CRUDController;

/**
 * CRUD Controller for {@link Provider}
 * @author Matias Niklison &lt;matias.niklison@gmail.com&gt;
 *
 */
public class ProviderCRUDController extends CRUDController<Long, Provider> {

  public ProviderCRUDController(final ProviderDAO dao) {
    // 10 is pageSize
    // "name" is orderBy
    super(dao, form(Provider.class), Long.class, Provider.class, 10, "name");
  }

  @Override
  protected String templateForList() {
    return "providerList";
  }

  @Override
  protected String templateForForm() {
    return "providerForm";
  }

  @Override
  protected String templateForShow() {
    return "providerShow";
  }

  @Override
  protected Call toIndex() {
    return routes.ProviderController.index();
  }

}
