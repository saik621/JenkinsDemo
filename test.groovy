node{
    
    def httpdemo(String methodreq1, String myUrl1, String content2)
    {
        def test = httpRequest acceptType: 'APPLICATION_JSON',
        contentType: 'APPLICATION_JSON',
        httpMode: methodreq1,
        responseHandle: 'NONE', 
        url: myUrl1
        requestBody: content2
        return test
    }
    stage('Get')
    {
        def resp = httpdemo('GET', 'https://jirademos.atlassian.net/rest/api/latest/issue/testissue')
    }
    stage('post'){
        def content1 = '''\'{
  "update": {
    "worklog": [
      {
        "add": {
          "timeSpent": "60m",
          "started": "2019-07-05T11:05:00.000+0000"
        }
      }
    ]
  },
  "fields": {
    "summary": "Main order flow broken",
    "parent": {
      "key": "PROJ-123"
    },
    "issuetype": {
      "id": "10000"
    },
    "components": [
      {
        "id": "10000"
      }
    ],
    "customfield_20000": "06/Jul/19 3:25 PM",
    "customfield_40000": "Occurs on all orders",
    "customfield_70000": [
      "jira-administrators",
      "jira-software-users"
    ],
    "project": {
      "id": "10000"
    },
    "description": "Order entry fails when selecting supplier.",
    "reporter": {
      "id": "5b10a2844c20165700ede21g"
    },
    "fixVersions": [
      {
        "id": "10001"
      }
    ],
    "customfield_10000": "09/Jun/19",
    "priority": {
      "id": "20000"
    },
    "labels": [
      "bugfix",
      "blitz_test"
    ],
    "timetracking": {
      "remainingEstimate": "5",
      "originalEstimate": "10"
    },
    "customfield_30000": [
      "10000",
      "10002"
    ],
    "customfield_80000": {
      "value": "red"
    },
    "security": {
      "id": "10000"
    },
    "environment": "UAT",
    "versions": [
      {
        "id": "10000"
      }
    ],
    "duedate": "2019-03-11T00:00:00.000Z",
    "customfield_60000": "jira-software-users",
    "customfield_50000": "Could impact day-to-day work.",
    "assignee": {
      "id": "5b109f2e9729b51b54dc274d"
    }
  }
}\''''
        def resp = httpdemo('POST', 'https://jirademos.atlassian.net/rest/api/latest/issue/', content1)
    }
    stage('put'){
      def resp = httpdemo('PUT', 'https://jirademos.atlassian.net/rest/api/latest/issue/', content1)
    }
}
