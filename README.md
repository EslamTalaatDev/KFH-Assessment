Android Technical Assessment

This repository contains the solution to the Android Technical Assessment as requested. Below is an overview of the features, architecture, and technologies used in the project.

Features Implemented
1. Authentication
Integrated Basic Authentication for secure app access before entering the main app.

2. Home Tab
Lists repositories from the created Bitbucket workspace.

Allows users to navigate to the repository details page from the list.

3. Settings Tab
Displays the authenticated user details.

Provides a logout feature to clear the session and navigate back to the login screen.

4. SSL Pinning
Implemented SSL Pinning to ensure secure communication with the server.

5. UI
Developed using Jetpack Compose for a modern and responsive user interface.

6. Architecture
Applied MVVM architecture for a clean separation of concerns between the UI and business logic.

7. API Integration
Direct usage of Bitbucket APIs without Swagger or code generation.

Additional Features
Room Caching: Enabled offline support by caching user data, repository lists, and repository details using Room.

Logout Functionality: Clears all cached data and credentials when logging out, returning the user to the login screen.

Unit Testing: Created unit tests to verify the login logic in the app layer.

Error Handling: Implemented comprehensive error handling for network and HTTP errors, with clear UI messages.

UI/UX: Utilized Material 3 theming, swipe-to-refresh, and responsive layouts for a better user experience.

Architecture
The project follows Clean Architecture, separating the code into three layers:

App Layer: Contains UI-related code and communicates with the domain layer.

Domain Layer: Contains business logic, use cases, and model definitions.

Data Layer: Handles network operations, caching (Room), and repository management.

Technologies Used
Kotlin: The primary language used to develop the app.

Jetpack Compose: For building modern UIs.

Room: For offline caching of user data and repositories.

Retrofit: For network communication with the Bitbucket API.

Dagger Hilt: For dependency injection.

MVVM: For clean separation of concerns between UI and business logic.

<img width="1024" height="1536" alt="clean_architecture_flow" src="https://github.com/user-attachments/assets/a3eb17b9-33f0-480e-a222-78aad64865ee" />


