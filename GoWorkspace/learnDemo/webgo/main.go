package main

import (
	"fmt"
	"github.com/gorilla/mux"
	"html/template"
	"net/http"
)
var templates  *template.Template
func handleHome(w http.ResponseWriter,r *http.Request)  {
	fmt.Fprint(w,"home")
}

func handleDetail(w http.ResponseWriter,r *http.Request)  {
	fmt.Fprint(w,"detail")
}

func handleIndex(w http.ResponseWriter,r *http.Request)  {
	data:= struct {
		title string
		item []string
	}{
		title:"cwp",
		item:[]string{
			"111",
			"222",
		},
	}
	templates.ExecuteTemplate(w,"index.html",data)
}
func main()  {
	templates=template.Must(template.ParseGlob("templates/*.html"))
	r:=mux.NewRouter()
	r.HandleFunc("/",handleIndex)
	r.HandleFunc("/detail",handleDetail)
	r.HandleFunc("/home",handleHome)
	http.Handle("/",r)
	http.ListenAndServe(":8888",nil)
}