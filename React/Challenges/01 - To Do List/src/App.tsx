import { Header } from './components/Header'
import { Header as HeaderList } from './components/List/Header'
import { Input } from './components/Input'
import styles from './App.module.css'
import { CreateButton } from './components/CreateButton'
import { Empty } from './components/List/Empty'
import { Item } from './components/List/Item'

function App() {
  return (
    <div>
      <Header />
      <main className={styles.wrapper}>
        <section className={styles.taskCreator}>
          <Input />
          <CreateButton />
        </section>

        <section>
          <HeaderList />
          <Empty />
          <Item />
        </section>
      </main>
    </div>
  )
}

export default App
