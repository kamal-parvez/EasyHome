# EasyHome

An Android application that connects landlords and tenants. Landlords can list their rental properties with details and photos, while tenants can browse available houses, view listing information, and contact landlords directly to arrange visits or finalize rental agreements.

## Features

### For Landlords
- Create and manage property listings
- Add property details (location, rent, description, photos)
- Receive inquiries from interested tenants

### For Tenants
- Browse available rental properties
- View detailed listing information
- Search and filter properties
- Contact landlords for the visit

## Tech Stack

| Component      | Technology                  |
|----------------|-----------------------------|
| Language       | Java                        |
| Platform       | Android                     |
| Backend        | Firebase (Google Services)   |
| Build System   | Gradle                      |
| IDE            | Android Studio              |

## Project Structure

```
├── app/                    # Application module
│   ├── src/                # Java source code, layouts, and resources
│   └── build.gradle        # App-level dependencies
├── gradle/wrapper/         # Gradle wrapper
├── build.gradle            # Project-level build configuration
├── settings.gradle         # Gradle settings
├── gradlew                 # Gradle wrapper script (Linux/macOS)
└── gradlew.bat             # Gradle wrapper script (Windows)
```

## Getting Started

### Prerequisites

- Android Studio
- Android SDK
- A Firebase project with a `google-services.json` file

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/kamal-parvez/EasyHome.git
   cd EasyHome
   ```

2. **Open in Android Studio**

   Open the project in Android Studio and let Gradle sync the dependencies.

3. **Configure Firebase**

   Place your `google-services.json` file in the `app/` directory. This file is required for Firebase authentication, database, and other services used by the app.

4. **Build and Run**

   Connect an Android device or start an emulator, then click **Run** in Android Studio.

## Author

**Md. Kamal Parvez**
