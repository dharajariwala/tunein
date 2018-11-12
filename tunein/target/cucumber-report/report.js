$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("one.feature");
formatter.feature({
  "line": 1,
  "name": "TuneIn Landing Page",
  "description": "",
  "id": "tunein-landing-page",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "User is able to Navigate to TuneIn Web Page",
  "description": "",
  "id": "tunein-landing-page;user-is-able-to-navigate-to-tunein-web-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Navigate"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am a user",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I Navigate to TuneIn url",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should see TuneIn Landing Page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I should Exit",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.initiateDriver()"
});
formatter.result({
  "duration": 1452030824,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iNavigateToTuneInUrl()"
});
formatter.result({
  "duration": 24332733856,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verifySomething()"
});
formatter.result({
  "duration": 11339826788,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iExitBrowser()"
});
formatter.result({
  "duration": 1138657818,
  "status": "passed"
});
});