import styles from './Item.module.css'
import { Trash } from '@phosphor-icons/react'

export function Item() {
  return (
    <div className={styles.container}>
      <label htmlFor="taskCompletionCheckbox">
        <input id="taskCompletionCheckbox" type="checkbox" />
        <span className={styles.taskCompletionCheckbox}></span>

        <p>
          Integer urna interdum massa libero auctor neque turpis turpis semper.
          Duis vel sed fames integer.
        </p>
      </label>

      <button>
        <Trash />
      </button>
    </div>
  )
}
