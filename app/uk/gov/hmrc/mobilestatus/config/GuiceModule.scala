/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.mobilestatus.config

import com.google.inject.AbstractModule
import com.google.inject.name.Names.named
import play.api.{Configuration, Environment}
import uk.gov.hmrc.http.{CoreGet, HttpClient}
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig

class GuiceModule(
  environment:   Environment,
  configuration: Configuration)
    extends AbstractModule {

  val servicesConfig = new ServicesConfig(configuration)

  override def configure(): Unit = {
    bind(classOf[CoreGet]).to(classOf[WSHttpImpl])
    bind(classOf[HttpClient]).to(classOf[WSHttpImpl])

    bindConfigBoolean("feature.componentisedAccessCodes")
    bindConfigBoolean("shuttering.appShuttered")
  }

  private def bindConfigBoolean(path: String): Unit =
    bindConstant().annotatedWith(named(path)).to(configuration.underlying.getBoolean(path))
}
