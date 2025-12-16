#!/bin/bash
# Beer API - Ejemplos de peticiones HTTP
# ======================================

# ============================================================================
# BEERS (CRUD)
# ============================================================================

# --- GET: Listar todas las cervezas ---
# curl
curl -X GET http://localhost:8080/beers

# httpie
http GET http://localhost:8080/beers


# --- GET: Obtener cerveza por ID ---
# curl
curl -X GET http://localhost:8080/beer/1

# httpie
http GET http://localhost:8080/beer/1


# --- POST: Crear cerveza ---
# curl
curl -X POST http://localhost:8080/beer \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mi Cerveza Artesanal",
    "breweryId": 1,
    "catId": 3,
    "styleId": 26,
    "abv": 5.5,
    "ibu": 35,
    "srm": 8,
    "descript": "Una cerveza de prueba"
  }'

# httpie
http POST http://localhost:8080/beer \
  name="Mi Cerveza Artesanal" \
  breweryId:=1 \
  catId:=3 \
  styleId:=26 \
  abv:=5.5 \
  ibu:=35 \
  srm:=8 \
  descript="Una cerveza de prueba"


# --- PUT: Actualizar cerveza (completa) ---
# curl
curl -X PUT http://localhost:8080/beer/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Cerveza Actualizada",
    "breweryId": 1,
    "catId": 3,
    "styleId": 26,
    "abv": 6.0,
    "ibu": 40,
    "srm": 10,
    "descript": "Descripción actualizada"
  }'

# httpie
http PUT http://localhost:8080/beer/1 \
  name="Cerveza Actualizada" \
  breweryId:=1 \
  catId:=3 \
  styleId:=26 \
  abv:=6.0 \
  ibu:=40 \
  srm:=10 \
  descript="Descripción actualizada"


# --- PUT: Actualizar cerveza (parcial) ---
# curl
curl -X PUT http://localhost:8080/beer/1 \
  -H "Content-Type: application/json" \
  -d '{
    "abv": 5.8
  }'

# httpie
http PUT http://localhost:8080/beer/1 abv:=5.8


# --- DELETE: Eliminar cerveza ---
# curl
curl -X DELETE http://localhost:8080/beer/5915

# httpie
http DELETE http://localhost:8080/beer/5915


# ============================================================================
# BREWERIES (Solo lectura)
# ============================================================================

# --- GET: Listar cerveceras ---
# curl
curl -X GET http://localhost:8080/breweries

# httpie
http GET http://localhost:8080/breweries


# --- GET: Obtener cervecera por ID ---
# curl
curl -X GET http://localhost:8080/brewerie/1

# httpie
http GET http://localhost:8080/brewerie/1


# ============================================================================
# CATEGORIES (Solo lectura)
# ============================================================================

# --- GET: Listar categorías ---
# curl
curl -X GET http://localhost:8080/categories

# httpie
http GET http://localhost:8080/categories


# --- GET: Obtener categoría por ID ---
# curl
curl -X GET http://localhost:8080/categorie/1

# httpie
http GET http://localhost:8080/categorie/1


# ============================================================================
# STYLES (Solo lectura)
# ============================================================================

# --- GET: Listar estilos ---
# curl
curl -X GET http://localhost:8080/styles

# httpie
http GET http://localhost:8080/styles


# --- GET: Obtener estilo por ID ---
# curl
curl -X GET http://localhost:8080/style/1

# httpie
http GET http://localhost:8080/style/1
