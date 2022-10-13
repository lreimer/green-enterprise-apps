package main

import (
	"fmt"
	"net/http"
	"os"
)

func main() {
	http.HandleFunc("/api/green", hello)
	http.ListenAndServe(port(), nil)
}

func port() string {
	port := os.Getenv("PORT")
	if len(port) == 0 {
		port = "8080"
	}
	return ":" + port
}

func hello(w http.ResponseWriter, r *http.Request) {
	w.WriteHeader(http.StatusOK)
	fmt.Fprintf(w, "Green Enterprise Apps with Go.")
}
