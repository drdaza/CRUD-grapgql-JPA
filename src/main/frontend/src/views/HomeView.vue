<script setup>
import { computed, ref } from 'vue';
import { useBookStore } from '../stores/bookStore'
import BookList from '../components/books/BookList.vue'
const bookStore = useBookStore()
const name = ref('')
const age = ref(0)

const existBooks = computed(() => {
  return bookStore.allBooks.length > 0
})

const bookForEditActions = (event) => {
  console.log(event);
}

</script>

<template>
  <main>
    <section class="list-books-section">
      <h1>Books</h1>
      <BookList @emit-book-info-for-edit="bookForEditActions" v-if="existBooks" />
      <h4 v-if="!existBooks">there is no book in this section yet, do you want to create a new item?</h4>
    </section>
    <section class="book-action-section">

    </section>
  </main>
</template>
<style lang="scss" scoped>
.list-books-section{
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
