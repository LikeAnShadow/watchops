// URL für den Nginx
//const BACKEND_URL = window.location.protocol + "//" + window.location.host;
//const MOVIES_URL = "/api/movies";
const BACKEND_URL = window.location.protocol + "//[::1]";
const MOVIES_URL = "/api/movie.json";

// Funktion die alle verfügbaren Filme vom Backend abfragt
async function getAllMovies() {
    try {
        const response = await fetch(BACKEND_URL+MOVIES_URL);
        if(!response.ok) {
            throw new Error(`Response status: ${response.status}`);
        }
        const json = await response.json();
        return json;
    } catch (error) {
        console.log(error.message);
    }
    return null;
}

// Funktion die Film in Filmliste hinzufügt
async function addMoviesToList(){
    try {
        const data = await getAllMovies();
        if(!data) return;
        
        for(let i = 0; i<data.length; i++) {
            const newItem = document.createElement('div');
            newItem.textContent = data[i].title;
            newItem.classList.add("movielist-item");
            document.getElementById("movielist").appendChild(newItem);
        }
    } catch(error) {
        return;
    }
}

addMoviesToList();

// Aktuell ausgewählten Film in Filmliste markieren

// Daten zu einem bestimmten Film abrufen
async function getMovie(id) {
    try {
        const response = await fetch(BACKEND_URL+MOVIES_URL+"/"+id);
        if(!response.ok) {
            throw new Error(`Response status: ${response.status}`);
        }
        const json = await response.json();
        return json;
    } catch (error) {
        console.log(error.message);
    }
    return null;
}

// Daten zum aktuell ausgewählten Film anzeigen lassen
async function showMovieData(id) {
    try {
        const movie_data = await getMovie(id);
        if(!movie_data) return;
        // Film Titel-Feld erstellen
        const newMovieTitle = document.createElement('input');
        newMovieTitle.placeholder = movie_data[0];
        // Film Titel-Feld dem passenden Container im Frontend anhängen 
        document.getElementById("main-content").appendChild(newMovieTitle);
        
    } catch(error) {
        return;
    }
}

// Film-Suchfunktion
const magnifier = document.getElementById("nav-search-img");
magnifier.addEventListener("click", async function (e) {
    const searchInput = document.getElementById("search-input");
    searchInput.focus();
});

