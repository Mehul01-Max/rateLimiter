public class Request {

    private final UserDetail user_detail;
    private final String request;
    private final HTTPMethod requestMethod;
    private int ResolvedStatus;

    public Request(UserDetail user_detail, String request, HTTPMethod requestMethod) {
        this.user_detail = user_detail;
        this.request = request;
        this.requestMethod = requestMethod;
    }

    public UserDetail getUser_detail() {
        return user_detail;
    }

    public String getRequest() {
        return request;
    }

    public HTTPMethod getRequestMethod() {
        return requestMethod;
    }

    public int getResolvedStatus() {
        return ResolvedStatus;
    }

    public void setResolved(int resolved) {
        ResolvedStatus = resolved;
    }

    @Override
    public String toString() {
        return "Request [user_detail=" + user_detail + ", request=" + request + ", requestMethod=" + requestMethod
                + ", ResolvedStatus=" + ResolvedStatus + "]";
    }

}
