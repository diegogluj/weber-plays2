package models;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import org.junit.Test;

/**
 * Test class for the Panelist model.
 * @author Matias Niklison &lt;matias.niklison@gmail.com&gt;
 */
public class PanelistTest {
  @Test
  public void create() {
      running(fakeApplication(), new Runnable() {
          public void run() {
              Provider provider = new Provider();
              provider.name = "Provider's test name.";
              provider.save();
              
              Panelist panelist = new Panelist();
              panelist.name = "Panelist's name";
              panelist.email = "panelist@email.com";
              panelist.provider = provider;
              panelist.save();
              assertThat(panelist.id).isNotNull();
          }
      });
  }
}
