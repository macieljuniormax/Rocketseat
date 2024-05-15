import ToDoLogo from '../assets/to-do-rocket.svg'
import styles from './Header.module.css'

export function Header() {
  return (
    <header className={styles.header}>
      <img className={styles.logo} src={ToDoLogo} alt="Logo ToDo Rocket" />
      <h1>
        <span>to</span>
        <span>do</span>
      </h1>
    </header>
  )
}
