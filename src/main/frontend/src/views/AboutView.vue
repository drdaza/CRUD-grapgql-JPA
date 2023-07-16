<script setup>
import {useAuthorStore} from '../stores/authorStore'
import { ref, onBeforeMount } from 'vue';
const authorStore = useAuthorStore()

onBeforeMount(() => {
  authorStore.findAllAuthors()
})



</script>
<template>
  <ul>
    <li v-for="author of authorStore.allAuthors">{{author.name}}</li>
  </ul>
  <button @click="authorStore.createAuthor({name: 'albero', age: 24})">create</button>
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
