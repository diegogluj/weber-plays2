package models;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import org.junit.Test;

/**
 * Test class for the Provider model.
 * @author Matias Niklison &lt;matias.niklison@gmail.com&gt;
 */
public class ProviderTest {
  @Test
  public void create() {
      running(fakeApplication(), new Runnable() {
          public void run() {
              Provider provider = new Provider();
              provider.name = "Provider's test name.";
              provider.save();
              assertThat(provider.id).isNotNull();
          }
      });
  }
}
