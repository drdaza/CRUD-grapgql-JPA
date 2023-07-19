<script setup>
import {useAuthorStore} from '../stores/authorStore'
import { ref, onBeforeMount } from 'vue';
const authorStore = useAuthorStore()
const authorIdToUpdate = ref(0)
const authorIdToDelete = ref(0)
const age = ref(0)
const name = ref('')
onBeforeMount(() => {
  authorStore.findAllAuthors()
})
</script>
<template>
  <ul>
    <li v-for="author of authorStore.allAuthors">{{author.name}} {{ author.age }}</li>
  </ul>
  <span>uptade</span>
  <input type="number" v-model="authorIdToUpdate">
  <span>delete</span>
  <input type="number" v-model="authorIdToDelete">
  <input type="text" v-model="name">
  <input type="number" v-model="age">
  <button @click="authorStore.createAuthor({name, age})">create</button>
  <button @click="authorStore.deleteAuthor(authorIdToDelete)">delete</button>
  <button @click="authorStore.updateAuthor({id: authorIdToUpdate , name: 'tulio', age: 28})">update</button>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
