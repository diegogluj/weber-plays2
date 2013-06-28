package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.utils.dao.BasicModel;

/**
 * The Provider: I Need more info about this model FIXME
 * @author Matias Niklison &lt;matias.niklison@gmail.com&gt;
 */
@Entity
public class Provider extends Model implements BasicModel<Long> {

  /**
   * Generated serialVersionUID
   */
  private static final long serialVersionUID = -3276000877346387494L;

  @Id
  public Long id;

  @Required
  public String name;

  @Override
  public Long getKey() {
    return this.id;
  }

  @Override
  public void setKey(final Long theKey) {
    this.id = theKey;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String theName) {
    this.name = theName;
  }
}
