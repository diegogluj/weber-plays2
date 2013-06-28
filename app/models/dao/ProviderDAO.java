package models.dao;

import models.Provider;
import play.utils.dao.BasicDAO;

/**
 * Provider DAO.
 * @author Matias Niklison &lt;matias.niklison@gmail.com&gt;
 */
public class ProviderDAO extends BasicDAO<Long, Provider> {

  public ProviderDAO() {
    super(Long.class, Provider.class);
 }
}
