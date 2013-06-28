package controllers;

import play.libs.Json;
import models.Provider;
import models.dao.ProviderDAO;
import play.mvc.Result;
import play.utils.crud.APIController;

import com.google.common.collect.ImmutableMap;

/**
 * REST Controller for {@link Provider}
 * 
 * @author Matias Niklison &lt;matias.niklison@gmail.com&gt;
 */
public class ProviderRESTController extends APIController<Long, Provider> {

  public ProviderRESTController(ProviderDAO dao) {
    super(dao);
  }

  /**
   * Creates a new {@link Provider}, it expects a json with "name" in it.
   * It returns a json with the status and the id of the created
   * {@link Provider}.
   */
  @Override
  public Result create() {
    Result check = checkRequired("name");
    if (check != null) {
      if (log.isDebugEnabled())
        log.debug("check : " + check);
      return check;
    }

    String name = jsonText("name");

    Provider provider = new Provider();
    provider.setName(name);

    Long key = dao.create(provider);
    if (log.isDebugEnabled()) {
      log.debug("key : " + key);
    }

    return created(Json.toJson(ImmutableMap.of("status", "OK", "id", key)));
  }
}
