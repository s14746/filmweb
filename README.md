### Pobranie listy wszystkich filmów

`GET http://localhost:8080/rest/movies`

### Pobranie filmu o podanym ID

`GET http://localhost:8080/rest/movies/{movieId}`

### Dodanie nowego filmu

`POST http://localhost:8080/rest/movies`

```javascript
Header:
Content-Type: application/json

Body:
{
    "name": "The Godfather 3"
}
```


### Aktualizacja filmu

`PUT http://localhost:8080/rest/movies/{movieId}`

```javascript
{
    "name": "The Godfather 3"
}
```

### Pobranie komentarzy danego filmu

`GET http://localhost:8080/rest/movies/{movieId}/comments`

### Dodanie komentarza pod konkretny film

`POST http://localhost:8080/rest/movies/{movieId}/comments`

```javascript
{
    "comment": "Very good movie"
}
```

### Usunięcie komentarza

`DELETE http://localhost:8080/rest/movies/{movieId}/comments/{commentId}`

### Wystawienie oceny

`POST http://localhost:8080/rest/movies/{movieId}/rates`

```javascript
{
    "rate": 5
}
```