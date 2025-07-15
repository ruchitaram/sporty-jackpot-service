Sporty Jackpot Service
This is a Spring Boot backend service for managing jackpots, contributions, and rewards in a betting-style system.

It supports creating jackpots, publishing bets, evaluating rewards, and listing all jackpots — built in a clean, test-driven way.

🚀 Features
Create and manage dynamic jackpots.

Publish bets that contribute to jackpot pools.

Evaluate bets to potentially reward users.

Configurable contribution and reward logic (fixed and variable).

In-memory repository for simplicity (no external DB needed).

Extensive unit and integration tests included.

💻 Tech Stack
Java 17

Spring Boot 3.x

Maven

JUnit 5

MockMvc

⚡ Lombok
⚠️ Note: Lombok is intentionally not used in this project.

Many developers on Apple Silicon (M1/M2) Macs face setup friction with Lombok due to annotation processing and IDE plugin configuration.

To keep onboarding simple and explicit, all getters/setters and constructors are written manually.

🤖 AI Usage
This project leveraged AI tools (including ChatGPT) to generate:

Initial boilerplate Spring Boot code.

Example service, repository, and controller structure.

Unit and integration test scaffolding and implementation.

This README file.

AI was used as a productivity accelerator, but final logic, correctness, and structure were fully reviewed and refined manually.


🌐 API Endpoints
💰 Jackpot APIs
POST /jackpots/create — Create a new jackpot.

GET /jackpots/all — List all jackpots.

Example Jackpot JSON

{
"jackpotId": "j1",
"poolAmount": 1000.0,
"initialPoolAmount": 1000.0,
"contributionType": "FIXED",
"rewardType": "FIXED",
"contributionRate": 0.1,
"rewardChance": 0.4,
"poolLimit": 5000.0
}

🤑 Bet APIs
POST /bets/publish — Publish a bet and contribute to jackpot pool.

POST /bets/evaluate — Evaluate if a bet wins a reward.

Example Bet JSON

{
"betId": "b1",
"userId": "u1",
"jackpotId": "j1",
"amount": 500.0
}


💡 Design Notes
A separate JackpotController is included to allow creating and listing jackpots easily via API.

This was designed intentionally to populate initial data for testing and local setup, so you don't need to pre-populate in-memory jackpots manually.

Enables smooth development and integration testing workflows.

📬 Postman Collection
A full Postman collection with all endpoints and example requests is included under the folder : 
src/main/resources/jackpot_postman_collection_final.json
Import this into Postman to test APIs quickly.

🧪 Testing
✅ Unit Tests
Cover core service logic.

Located under src/test/java/org/example/service.

✅ Integration Tests
Validate full HTTP API flows using MockMvc.

Located under src/test/java/org/example/controller.

💡 Run tests

mvn test
Or in IntelliJ: right-click the test directory → Run All Tests.

⚙️ How to Run
✅ Prerequisites
Java 17+

Maven

✅ Build & Start

mvn clean install
mvn spring-boot:run
App runs at: http://localhost:8080

💡 Future Improvements
Add user authentication and authorization.

Migrate from in-memory to a real database (PostgreSQL/MySQL).

Add OpenAPI (Swagger) documentation.

Improve error handling and logging.

🤝 Contributing
Feel free to fork, open issues, or submit PRs!

🧑‍💻 Author
Ruchita
