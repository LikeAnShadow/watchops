import './global.css'
import Navbar from './navbar';
import Movielist from './movielist';
import Movie from './movie';

export default function RootLayout() {
    return (
      <html lang="de">
        <head>
          <title>watchops</title>
          <link rel="icon" href="images/icon.png" type="image/png" />
        </head>
        <body>
          <header>
            <Navbar />
          </header>
          <main>
            <Movielist />
            <Movie />
          </main>
        </body>
      </html>
    )
}