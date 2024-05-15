import { PlusCircle } from '@phosphor-icons/react'
import styles from './CreateButton.module.css'

export function CreateButton() {
  return (
    <button type="submit" className={styles.createButton}>
      <span>Criar</span>
      <PlusCircle weight="bold" />
    </button>
  )
}
