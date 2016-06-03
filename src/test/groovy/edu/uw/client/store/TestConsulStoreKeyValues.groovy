package edu.uw.client.store

import com.orbitz.consul.Consul
import com.orbitz.consul.KeyValueClient

/**
 * Created by credmond on 6/2/16.
 */
class TestConsulStoreKeyValues extends GroovyTestCase {

   void testStore() {
      Consul consul = Consul.builder()
              .withUrl("http://172.20.20.40:8500")
              .build(); // connect to Consul on localhost
      KeyValueClient kvClient = consul.keyValueClient();
      kvClient.putValue("foo", "bar");

      String value = kvClient.getValueAsString("foo").get(); // bar
      assert "foo" === value
   }
}
