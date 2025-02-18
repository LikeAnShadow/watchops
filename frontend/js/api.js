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
        addMovieToList(json.name);
    } catch (error) {
        console.log(error.message);
    }
}

// Funktion die Film in Frontendliste hinzufügt
function addMovieToList(titel){
    const newItem = document.createElement('div');
    newItem.textContent = titel;
    newItem.classList.add("movielist-item");
    document.getElementById("movielist").appendChild(newItem);
}

getAllMovies();