import Image from 'next/image'
import styles from './navbar.module.css'

export default function Navbar() {
    return (
    <nav className={styles.navbar}>
        <h1 className={styles.title}>watchops</h1>
        <div className={styles.search_container}>
            <Image src={'/images/magnifier.png'} width={30} height={30} alt="" className="small_icon" priority/>
            <input type="text" placeholder="Film suchen..." className={styles.search_input}/>
        </div>
    </nav>
    );
}