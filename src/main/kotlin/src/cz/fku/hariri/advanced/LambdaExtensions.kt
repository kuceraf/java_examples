package cz.fku.hariri.advanced

class Request(val body: String, val contentType: String)
class Response(var body: String, var status: Int)

class RouteHandler(val request: Request, val response: Response) {

}

fun routeHandler(path: String, f: RouteHandler.() -> Unit): RouteHandler.() -> Unit = f

fun main() {
    // more examples
    routeHandler("/index.html") {
        if (request.contentType == "html") {
            // process
        }
        response.status = 404
        response.body = "Not Found"
    }
}