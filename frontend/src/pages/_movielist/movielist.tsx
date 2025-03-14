import Image from 'next/image'
import styles from './movielist.module.css'

export default function Movielist({ data }) {
    return (
        <div className={styles.movielist_container}>
            <div className={styles.movielist_add_container}>
                <Image src={'/images/plus.png'} width={30} height={30} alt="" className="small_icon" />
            </div>
            {
                data.map(item => {
                    return <div className={styles.movielist_item} key={item.id}>{item.title}</div>
                })
            }
        </div>
    );
}

