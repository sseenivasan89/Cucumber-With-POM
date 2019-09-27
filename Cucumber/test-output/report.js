$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GoogleSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Google Search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9273420600,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Searching Google Page",
  "description": "",
  "id": "google-search;searching-google-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Search"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I Launch Goolge",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I Search For Selenium",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I Select The Link",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I Search Something On Selenium Page",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearchSteps.i_Launch_Goolge()"
});
formatter.result({
  "duration": 6310214700,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearchSteps.i_Search_For_Selenium()"
});
formatter.result({
  "duration": 6279310700,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearchSteps.i_Select_The_Link()"
});
formatter.result({
  "duration": 3217079100,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearchSteps.i_Search_Something_On_Selenium_Page()"
});
formatter.result({
  "duration": 6302579800,
  "status": "passed"
});
formatter.after({
  "duration": 2891593800,
  "status": "passed"
});
});