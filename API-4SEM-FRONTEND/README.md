# How to run the project

## Linux

1. Install node and npm

```
sudo apt update
```

```
sudo apt install nodejs npm
```

2. (Optional) Install NVM

```
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.5/install.sh | bash
```

3. Run the command

```
nvm use
```

to use the project's node version (and therefore npm), set in the `.nvmrc` file

## Windows

1. Download node v22 from the website and install it

```
https://nodejs.org/en/download
```

## Next steps (for both Linux and Windows)

1. Run the command

```
npm install
```

2. (Optional) Lint / Formatter

   2.1. If you are using VS Code, install the `Prettier` and `ESLint` plugins

   2.2. Press `Ctrl + Shift + P`, type `settings` and open the VS Code one (Workspace Settings)

   2.2.1. Add to the file:

   ```
      {
         "editor.codeActionsOnSave": {
            "source.fixAll.eslint": "explicit"
         },
         "editor.formatOnSave": true,
         "eslint.validate": ["javascript", "vue"],
         "prettier.requireConfig": true
      }
   ```

3. Once the dependencies are installed, create a `.env` file in the root folder and copy the contents of `.env.example` into it

4. To run the frontend

   4.1. (With backend) Run the command

   ```
   npm run dev
   ```

   to start the project locally on port `5173`, talking to the backend on port `8080`

   4.2. (Without backend) Run the command

   ```
   npm run mock
   ```

   to start the project locally on port `5173` with mock data

# How to build the project for production

Compiles and minifies the project for production:

```
npm run build
```

# Project structure

The project follows a **modular** folder structure, where files are organized by their role or feature in the system. This approach makes maintenance easier and helps locate files related to the same layer or feature.

```
src/
├── assets/ # Static files (images, fonts, etc.)
├── components/ # Components reused across modules
├── modules/ # Modules split by responsibility
├── router/ # Route configuration
├── stores/ # State management
├── styles/ # Global styles
├── utils/ # Utilities reused across modules (helper functions, constants, etc.)
└── main.js # Application entry point
```

Here is an overview of the structure inside each module:
- `views`: Main screens or pages of the module.
- `components`: Reusable components of the module.
- `router`: Route definitions of the module.
- `services`: Services for HTTP requests or business logic.
- `mock`: Mock data for development without a backend.
- `store`: State management, if needed.
- `utils`: Utility functions specific to the module.

## Benefits of this structure

- **Code reuse**: Components and utilities can easily be reused in different parts of the system, reducing duplication.
- **Teamwork**: Teams can work on different modules independently, minimizing conflicts.
- **Separation of concerns**: Each module handles a specific part of the system, making the code cleaner and easier to understand

## Project conventions

- Code in English
- Every endpoint must have a matching mock

# Commit/branch conventions

We follow Conventional Commits, with a few changes. To make day-to-day development easier, VS Code has an extension called `Conventional Commits` that helps with this.

## Commits

`<type> (<Jira task ID>): <short description in English>`

Example: docs: updates the readme with commits pattern

## Branch

`SCRUM-<Jira task ID>/<short description in English>`

Example: RAD-47/update-readme
