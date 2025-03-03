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

// Funktion die Film in Frontendliste hinzufügt
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
