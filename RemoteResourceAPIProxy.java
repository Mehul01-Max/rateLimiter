import java.util.*;

public class RemoteResourceAPIProxy {

    RemoteResourceAPI remoteResourceAPI;
    List<Request> requests;
    RequestHandling requestHandling;

    public RemoteResourceAPIProxy(RequestHandling requestHandling) {
        this.requests = new ArrayList<Request>();
        this.requestHandling = requestHandling;
    }

    private RemoteResourceAPI getReal() {
        if (remoteResourceAPI == null) {
            this.remoteResourceAPI = new RemoteResourceAPI();
        }
        return remoteResourceAPI;
    }

    public Response getResponse(Request request) {
        requests.add(request);
        if (requestHandling.checkForLimit(requests, requests.size() - 1)) {
            Response response = getReal().getResponse(request);
            request.setResolved(response.getHTTPStatus());
            return response;
        }
        request.setResolved(429);
        return new Response("Too Many Requests", 429);
    }

}
