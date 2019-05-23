package contracts


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
        body(
                             name: "战国策",
 //                            data: fromRequest().url()
         
        )
        headers {
            (header('Content-Type', 'application/json;charset=UTF-8'))
        }
    }
}