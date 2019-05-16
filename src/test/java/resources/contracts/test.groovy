package resources.contracts

import com.fasterxml.jackson.dataformat.yaml.UTF8Reader
import org.apache.tomcat.util.http.parser.AcceptLanguage
import org.eclipse.jgit.transport.TransportHttp
import org.json.JSONObject
import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description("should a number")
    request {
        method(GET())

        urlPath ("/v1/get/2"){
//            queryParameters {
//                parameter("number",2)
//            }
        }


    }
    response {
        status(200)
        body('''{
                             "name": "战国策3"
}''')
        headers {
            (header('Content-Type', 'application.yaml/json;charset=UTF-8'))
        }
    }
}