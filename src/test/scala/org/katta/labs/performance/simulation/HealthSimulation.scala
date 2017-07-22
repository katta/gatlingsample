package org.katta.labs.performance.simulation;

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class HealthSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers

  val scn = scenario("Health Scenario") // A scenario is a chain of requests and pauses
    .exec(http("heatlh_request")
    .get("/health"))
    .pause(7) // Note that Gatling has recorder real time pauses


  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
}