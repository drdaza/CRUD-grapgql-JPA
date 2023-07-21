<script setup>
import {useAuthorStore} from '../stores/authorStore'
import {useBookStore} from '../stores/bookStore'
import { ref, onBeforeMount } from 'vue'

import BookList from '../components/books/BookList.vue'
const authorStore = useAuthorStore()
const bookStore = useBookStore()
const authorIdToUpdate = ref(0)
const authorIdToDelete = ref(0)
const age = ref(0)
const name = ref('')
onBeforeMount(() => {
  authorStore.findAllAuthors()
  bookStore.findAllBooks()
})
</script>
<template>
  <main>
  <ul>
    <li v-for="author of authorStore.allAuthors">{{author.name}} {{ author.age }}</li>
  </ul>
  <BookList/>
  <span>uptade</span>
  <input type="number" v-model="authorIdToUpdate">
  <span>delete</span>
  <input type="number" v-model="authorIdToDelete">
  <input type="text" v-model="name">
  <input type="number" v-model="age">
  <button @click="bookStore.createBook({title: 'el titulo', description: 'desc', authorId: 86})">Book</button>
  <button @click="authorStore.createAuthor({name, age})">create</button>
  <button @click="authorStore.deleteAuthor(authorIdToDelete)">delete</button>
  <button @click="authorStore.updateAuthor({id: authorIdToUpdate , name: 'tulio', age: 28})">update</button>
  </main>
</template>

<style lang="scss" scoped>
@media (min-width: 1024px) {
  main {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
}
</style>
