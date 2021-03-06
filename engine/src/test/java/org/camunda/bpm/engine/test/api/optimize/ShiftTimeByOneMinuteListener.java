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
package org.camunda.bpm.engine.test.api.optimize;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.util.ClockUtil;

import java.util.Date;

public class ShiftTimeByOneMinuteListener implements ExecutionListener {

  @Override
  public void notify(DelegateExecution execution) throws Exception {
    Long oneMinute = 1000L * 60L;
    Date shiftedTimeByOneMinute = new Date(ClockUtil.getCurrentTime().getTime() + oneMinute);
    ClockUtil.setCurrentTime(shiftedTimeByOneMinute);
  }
}
