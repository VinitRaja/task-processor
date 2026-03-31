# Git Version Control Guide for Task Processor

This guide provides the basic git commands to initialize, manage, and use version control for my project.

## 1. Initialize Git Repository
```
git init
```

## 2. Add All Files
```
git add .
```

## 3. Commit Changes
```
git commit -m "Initial commit"
```

## 4. Add Remote Repository (GitHub example)
```
git remote add origin https://github.com/VinitRaja/task-processor.git
```

## 5. Push to Remote
```
git push -u origin main
```

## 6. Check Status
```
git status
```

## 7. View Commit Log
```
git log --oneline --graph --all
```

## 8. Create and Switch Branch
```
git checkout -b feature/your-feature
```

## 9. Pull Latest Changes
```
git pull origin main
```

## 10. .gitignore Example
Create a `.gitignore` file to exclude build and IDE files:
```
target/
*.iml
.idea/
*.log
*.class
.DS_Store
```

---
