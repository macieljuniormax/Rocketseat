import styles from './Empty.module.css'
import { ClipboardText } from '@phosphor-icons/react'

export function Empty() {
  return (
    <div className={styles.container}>
      <ClipboardText weight="thin" />
      <p>
        <span>
          <strong>Você ainda não tem tarefas cadastradas</strong>
        </span>
        <span>Crie tarefas e organize seus itens a fazer</span>
      </p>
    </div>
  )
}
