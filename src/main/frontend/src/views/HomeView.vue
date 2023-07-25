<script setup>
import { computed, ref } from 'vue';
import { useBookStore } from '../stores/bookStore'
import BookList from '../components/books/BookList.vue'
const bookStore = useBookStore()
const name = ref('')
const age = ref(0)

const existBooks = ()=>{
  return bookStore.allBooks.length > 0
}

const bookForEditActions = (event)=>{
  console.log(event);
}

</script>

<template>
  <main>
    <h1>Libros</h1>
    <BookList @emit-book-info-for-edit="bookForEditActions" v-if="existBooks"/>
    <h1 v-if="!existBooks">No existe ningun Libro</h1>
  </main>
</template>
