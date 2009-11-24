/*
 * Copyright 2009 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twitter.xrayspecs

import java.io.File
import net.lag.configgy.Configgy
import org.specs.runner.SpecsFileRunner


class XraySpecsRunner(path: String) extends SpecsFileRunner(path, ".*",
  System.getProperty("system", ".*"), System.getProperty("example", ".*")) {

  def this() = this("src/test/scala/**/*.scala")

  var configFilename = System.getProperty("basedir") + "/config/" + System.getProperty("stage", "test") + ".conf"
  if (new File(configFilename).exists()) {
    Configgy.configure(configFilename)
  }
}
