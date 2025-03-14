import type { AppProps } from "next/app";
import RootLayout from "../app/layout"; // Importiere das globale Layout
import Head from "next/head";

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <>
        <Head>
            <title>watchops</title>
            <link rel="icon" href="images/icon.png" type="image/png" />
        </Head>
        <RootLayout>
            <Component {...pageProps} />
        </RootLayout>
    </>
    
  );
}

export default MyApp;