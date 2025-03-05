import './global.css'
import Navbar from './navbar';
import Movielist from './movielist';
import Movie from './movie';

export default function RootLayout() {
    return (
      <html lang="de">
        <head>
          <title>watchops</title>
          <link rel="icon" href="/icon?<generated>" type="image/<generated>" sizes="<generated>"/>
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