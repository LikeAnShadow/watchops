import styles from './movie.module.css'
import Form from 'next/form'

export default function Movie({ data }){
    return (
        <Form action="" className={styles.movie_container}>
            <label className={styles.movie_label}>Titel</label>
            <input className={styles.movie_input} type='text'></input>
            <label className={styles.movie_label}>Jahr</label>
            <input className={styles.movie_input}type='date'></input>
            <label className={styles.movie_label}>Beschreibung</label>
            <textarea className={styles.movie_textarea} ></textarea>
            <button className={styles.movie_button} type='submit'>Speichern</button>
        </Form>
    );
}