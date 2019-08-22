# simple-api

Basic CRUD API with atom data structure

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## Routes

```
POST /employers
PUT /employers/:id
DELETE /employers/:id
GET /employers
GET /employers/:id
```

### Employer JSON for POST/PUT:

```
{
    "name": "Your name"
    "job": "Your job"
}
```