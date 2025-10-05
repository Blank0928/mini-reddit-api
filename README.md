# Mini Reddit API (Spring Boot)

This is a simple **Reddit-style REST API** built with **Spring Boot**.  
It allows users to create, read, update, and delete **posts** and **comments**, all stored **in memory** (no database used).

---

## Features
- Create, view, update, and delete posts  
- Add, update, and delete comments under posts  
- In-memory data storage (no database required)  
- Cross-Origin Resource Sharing (CORS) enabled for frontend  
- Simple JSON-based API responses

---

## Tech Stack
- **Java 17+**
- **Spring Boot**
- **Maven**

---

## How to Run Locally

### 1. Clone the repository
```bash
git clone https://github.com/Blank0928/mini-reddit-api.git
cd mini-reddit-api
```
```Run the Spring Boot app
mvn spring-boot:run
The backend server will start at:
http://localhost:8080/api
```

``` API Endpoints
Posts
Method	Endpoint	Description
GET	/api/posts	Get all posts
POST	/api/posts	Create new post
GET	/api/posts/{id}	Get a single post by ID
PUT	/api/posts/{id}	Update a post
DELETE	/api/posts/{id}	Delete a post
Comments
Method	Endpoint	Description
POST	/api/posts/{postId}/comments	Add comment to a post
PUT	/api/posts/{postId}/comments/{commentId}	Update a comment
DELETE	/api/posts/{postId}/comments/{commentId}	Delete a comment
```
Related Project

Frontend (React + Vite): Mini Reddit Frontend

Author
Jose Lorenzo Landicho

