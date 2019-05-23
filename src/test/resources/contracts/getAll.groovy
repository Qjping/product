package contracts


import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description("should a number")
    request {
        method(GET())

        urlPath ("/v1/get/all"){
//            queryParameters {
//                parameter("number",2)
//            }
        }


    }
//cusumer不支持使用正则表达式
    response {
        status(200)
        body(
               [[
                      "name":"战国策",
                      "id":"2",
                      "email":$(c("1490665859@qq.com"),p(email())),
                      "web": '127.0.0.1'
              ],
              [
                      "name":"资治通鉴",
                      "id":number(),
                      "email":$(c("1490665859@qq.com"),p(email())),
                      "web": $(c("www.baidu.com"),p(url())),
                      price:$(c(127),p(number()))
              ]]
              )
        headers {
            (header('Content-Type', 'application/json;charset=UTF-8'))
        }

    }
}

//import org.springframework.cloud.contract.spec.Contract
//Contract.make {
//    priority 1
//    request {
//        method 'POST'
//        url '/users/password'
//        headers {
//            contentType(applicationJson())
//        }
//        body(
//                email: $(consumer(optional(regex(email()))), producer('abc@abc.com')),
//                callback_url: $(consumer(regex(hostname())), producer('http://partners.com'))
//        )
//    }
//    response {
//        status 404
//        headers {
//            header 'Content-Type': 'application/json'
//        }
//        body(
//                code: value(consumer("123123"), producer(optional("123123")))
//        )
//    }
//}
//
//
