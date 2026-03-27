public class Main {
    public static void main(String[] args) {
        System.out.println("--- Rate Limiter System Demo ---");

        RequestHandling slidingWindow = new MovingSlidingWindow(5, 3);

        RemoteResourceAPIProxy apiProxy = new RemoteResourceAPIProxy(slidingWindow);

        UserDetail user = new UserDetail(1, "192.168.1.1", "New York");

        System.out.println("Simulating burst of 10 requests...");
        for (int i = 1; i <= 10; i++) {
            Request request = new Request(user, "GET /data?info=" + i, HTTPMethod.GET);
            Response response = apiProxy.getResponse(request);

            if (response.getHTTPStatus() == 200) {
                System.out.println("Request " + i + ": SUCCESS - " + response);
            } else if (response.getHTTPStatus() == 429) {
                System.out.println("Request " + i + ": RATE LIMITED (" + response.getHTTPStatus() + ") - "
                        + response);
            }
        }
    }
}
