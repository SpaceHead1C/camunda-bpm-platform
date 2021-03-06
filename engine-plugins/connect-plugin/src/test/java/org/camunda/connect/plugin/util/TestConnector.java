/*
 * Copyright © 2012 - 2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.connect.plugin.util;

import java.lang.Exception;import java.lang.Object;import java.lang.RuntimeException;import java.lang.String;import java.util.HashMap;
import java.util.Map;

import org.camunda.connect.impl.AbstractConnector;

/**
 * @author Daniel Meyer
 *
 */
public class TestConnector extends AbstractConnector<TestConnectorRequest, TestConnectorResponse> {

  public static final String ID = "testConnector";

  public static Map<String, Object> requestParameters;
  public static Map<String, Object> responseParameters = new HashMap<String, Object>();

  public TestConnector(String connectorId) {
    super(connectorId);
  }

  public TestConnectorRequest createRequest() {
    return new TestConnectorRequest(this);
  }

  public TestConnectorResponse execute(TestConnectorRequest req) {
    // capture request parameters
    requestParameters = req.getRequestParameters();

    TestRequestInvocation testRequestInvocation = new TestRequestInvocation(null, req, requestInterceptors);

    try {
      testRequestInvocation.proceed();
      // use response parameters
      return new TestConnectorResponse(responseParameters);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
