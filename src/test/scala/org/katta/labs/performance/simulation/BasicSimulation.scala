package org.katta.labs.performance.simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.katta.labs.performance.config.HttpConfig

class BasicSimulation extends Simulation {

  val scn = scenario("BasicSimulation")
    .exec(http("request_1")
      .get("/"))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(HttpConfig.conf)

}