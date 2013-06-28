package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.mindrot.jbcrypt.BCrypt;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * The Panelist: I Need more info about this model FIXME
 * @author Matias Niklison &lt;matias.niklison@gmail.com&gt;
 */
@Entity
public class Panelist extends Model {

  /**
   * Generated serialVersionUID
   */
  private static final long serialVersionUID = -2408015184908820163L;

  @Id
  public Long id;

  @Constraints.Required
  @Formats.NonEmpty
  public String name;

  @Constraints.Email
  @Constraints.Required
  @Formats.NonEmpty
  @Column(unique = true)
  public String email;

  @Constraints.Required
  @Formats.NonEmpty 
  public String passwordHash;

  @ManyToOne
  @Constraints.Required
  public Provider provider;

  @Formats.DateTime(pattern="dd/MM/yyyy")
  public Date birthDate;

  public Gender gender;

  public String country;

  public String district;

  public String city;

  public String project;

  public String sourceLog;

  public String activationKey;

  public Boolean activated;

  public Boolean disabled;

  @Constraints.Max(100)
  public String disabledReason;

  @Constraints.Pattern(value="^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
      "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
      "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
      "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$")
  public String lastIp;

  @Formats.DateTime(pattern="dd/MM/yyyy")
  public Date createdAt;

  @Formats.DateTime(pattern="dd/MM/yyyy")
  public Date modifiedAt;

  @Formats.DateTime(pattern="dd/MM/yyyy")
  public Date activatedAt;

//-- Queries (long id, user.class)
  public static Model.Finder<Long, Panelist> find =
      new Model.Finder<Long, Panelist>(Long.class, Panelist.class);

  /**
   * Default constructor.
   */
  public Panelist() {
    super();
    this.createdAt = new Date();
  }

  /**
   * Authenticate a Panelist, from a email and clear password.
   *
   * @param email The panelist's email
   * @param clearPassword clear password
   * @return Panelist if authenticated, null otherwise
   */
  public static Panelist authenticate(String email, String clearPassword) {

    if (clearPassword == null) {
      return null;
    }
    // get the user with email only to keep the salt password
    Panelist panelist = find.where().eq("email", email).findUnique();
    if (panelist != null) {
      // get the hash password from the salt + clear password
      // TODO Extract the encryption a class.
      if (BCrypt.checkpw(clearPassword, panelist.passwordHash)) {
        return panelist;
      }
    }
    return null;
  }

  /**
   * Changes the panelist password.
   * @param password
   */
  public void changePassword(String password) {
    // TODO Extract the encryption a class.
    this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    this.save();
  }

  /**
   * Confirms the panelist.
   */
  public void confirm() {
    this.activationKey = null;
    this.activated = true;
    this.activatedAt = new Date();
    this.save();
  }

  @Override
  public void save() {
    this.modifiedAt = new Date();
    super.save();
  }
}
