# Rate Limiter System

## Problem Statement

Design an extensible and scalable Rate Limiting System. The system attempts to limit the number of requests a user or client can make to a remote resource within a given context (e.g., sliding window of requests).

## Requirements

- **Intercept Requests:** Wrap the actual resource processing so we can intercept and limit incoming requests.
- **Configurable Rate Limiting:** Should support different rate-limiting algorithms.
- **Client Identification:** Rate limiting logic can eventually enforce limits grouped by IP address, User ID, or Location.
- **Graceful Rejection:** Return appropriate HTTP 429 status codes when the limit is breached.

## Low-Level Design (LLD)

### Design Patterns Used

- **Proxy Pattern:** `RemoteResourceAPIProxy` acts as a proxy to `RemoteResourceAPI`. It intercepts the `getResponse` calls, applies rate-limiting logic, and either forwards the request or halts it.
- **Strategy Pattern:** `RequestHandling` interface abstracts the rate-limiting algorithm. This allows the system to switch between algorithms dynamically (e.g., Token Bucket vs. Moving Sliding Window) without modifying the Proxy logic.

### Core Components

1. **`RequestHandling` (Interface):** Defines the contract for rate-limiting algorithms (`checkForLimit`).
2. **`MovingSlidingWindow`:** A concrete strategy that implements `RequestHandling`. Parses the list of recent attempts and ensures only a configurable number of valid requests occur in a specified window of attempts.
3. **`RemoteResourceAPIProxy`:** Intercepts traffic, keeps track of request history, and delegates decision-making to the `RequestHandling` instance.
4. **`RemoteResourceAPI`:** The actual resource that serves valid requests.
5. **Models (`Request`, `Response`, `UserDetail`, `HTTPMethod`):** Strongly typed domain models representing the HTTP request payloads.

### UML Class Diagram

![UML Class Diagram](UML%20Diagram.png)
# rateLimiter
