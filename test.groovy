node{
    stage('Get')
    {
        httpRequest acceptType: 'APPLICATION_JSON',
        contentType: 'APPLICATION_JSON',
        customHeaders: [[maskValue: true, name: 'Basic', value: 'Sometext']],
        httpMode: 'GET',
        responseHandle: 'NONE', 
        url: 'http://dummy.restapiexample.com/api/v1/employees'
    }
    stage('post'){
        httpRequest acceptType: 'APPLICATION_JSON',
        contentType: 'APPLICATION_JSON',
        customHeaders: [[maskValue: true, name: 'Basic', value: 'Sometext']],
        httpMode: 'POST',
        requestBody: '{"name":"test","salary":"123","age":"23"}', 
        responseHandle: 'NONE',
        url: 'http://dummy.restapiexample.com/api/v1/create'
    }
    stage('put'){
        httpRequest acceptType: 'APPLICATION_JSON',
        contentType: 'APPLICATION_JSON',
        customHeaders: [[maskValue: true, name: 'Basic', value: 'Sometext']],
        httpMode: 'PUT',
        requestBody: '{"name":"test1","salary":"1123","age":"23"}', 
        responseHandle: 'NONE',
        url: 'http://dummy.restapiexample.com/api/v1/update/21'
    }
}
