# README.md

````markdown
# App-Navigation-Compose

Ready-to-use **Navigation module** for Android Jetpack Compose.  
Just download or clone this repo and copy the `navigation` folder into your project.

## How to Use

1. **Download or Clone** this repository:

```bash
git clone https://github.com/iamacat02/App-Navigation-Compose.git
````

or download ZIP and extract.

2. **Copy the navigation folder** from the downloaded repo:

```
App-Navigation-Compose/navigation
```

3. **Paste into your Android Studio project**:

```
src/main/java/<your_package_name>/navigation
```

> After pasting, your project structure should look like this:

```
src
└── main
    └── java
        └── <your_package_name>
            └── navigation
                ├── composition/
                ├── host/
                ├── navigation/
                ├── route/
                └── transition/
```

4. **Start using it** in your Compose screens:

```kotlin
import <your_package_name>.navigation.*
```

No extra setup required—just copy, paste, and start navigating! 🚀

---

## Folder Structure

* `composition/` – Composable screen definitions
* `host/` – Navigation host setup
* `navigation/` – Core navigation components
* `route/` – Route definitions
* `transition/` – Animations / transitions

```
