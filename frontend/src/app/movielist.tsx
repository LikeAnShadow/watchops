import Image from 'next/image'
import Plus from './plus.png'
import styles from './movielist.module.css'

export default function Movielist() {
    return (
        <div className={styles.movielist_container}>
            <div className={styles.movielist_add_container}>
                <Image src={Plus} alt="" className="small_icon" />
            </div>
        </div>
    );
}