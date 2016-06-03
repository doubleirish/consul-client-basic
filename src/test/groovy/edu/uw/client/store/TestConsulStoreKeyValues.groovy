package edu.uw.client.store

import com.orbitz.consul.Consul
import com.orbitz.consul.KeyValueClient

/**
 * Created by credmond on 6/2/16.
 */
class TestConsulStoreKeyValues extends GroovyTestCase {

   void testStoreAndRetrieveKeyValues() {

      //
      // Connect to Consul
      //
      Consul consul = Consul.builder()
              .withUrl("http://172.20.20.40:8500")
              .build(); // connect to Consul on localhost
      KeyValueClient kvClient = consul.keyValueClient();

      //
      // push Config to Consul
      //
      kvClient.putValue("foo", "bar");

      //
      // pull Config from Consul
      //

      String value = kvClient.getValueAsString("foo").get(); // bar
      assert "bar" == value
   }
}
