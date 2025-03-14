import Movielist from './_movielist/movielist';
import Movie from './_movie/movie';

const BACKEND_URL = "http://[::1]:8080";
const MOVIES_URL = "/api/movies";

export async function getServerSideProps() {
    try {
        const response = await fetch(BACKEND_URL+MOVIES_URL);
        if(!response.ok) {
            throw new Error(`Response status: ${response.status}`);
        }
        const json = await response.json();
        return { props: { movielist: json } }
    } catch (error) {
        console.log(error.message);
    }
    return { props: { } }
}

export default function Home({movielist}) {
    return (
        <main>
            <Movielist data={movielist} />
            <Movie />
        </main>
    )
}
