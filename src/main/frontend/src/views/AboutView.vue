<script setup>
import {useAuthorStore} from '../stores/authorStore'
import { ref, onBeforeMount } from 'vue';
const authorStore = useAuthorStore()
const authorId = ref(0)
onBeforeMount(() => {
  authorStore.findAllAuthors()
})



</script>
<template>
  <ul>
    <li v-for="author of authorStore.allAuthors">{{author.name}} {{ author.age }}</li>
  </ul>
  <input type="number" v-model="authorId">
  <button @click="authorStore.createAuthor({name: 'albero', age: 24})">create</button>
  <button @click="authorStore.deleteAuthor(authorStore.allAuthors.length)">delete</button>
  <button @click="authorStore.updateAuthor({id: authorId, name: 'tulio', age: 28})">update</button>
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
