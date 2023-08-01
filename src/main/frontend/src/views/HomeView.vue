<script setup>
import { computed, ref } from 'vue';
import { useBookStore } from '../stores/bookStore'

import BookList from '../components/books/BookList.vue'
import CreateNewItem from '../components/creationComponents/CreateNewItem.vue';
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
    <div class="title-zone">
      <h1>Books</h1>
    </div>
    <div class="content-zone">
      <section class="list-books-section">
        <BookList @emit-book-info-for-edit="bookForEditActions" v-if="existBooks" />
        <h4 v-if="!existBooks">there is no book in this section yet, do you want to create a new item?</h4>
      </section>
      <section class="book-action-section">
        <CreateNewItem :type-of-element="'Book'" :title-section="'Create a new Book'" />
      </section>
    </div>
  </main>
</template>
<style lang="scss" scoped>
main {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2vh;

  .content-zone {
    width: 100%;
    display: flex;
    justify-content: space-evenly;

    .list-books-section {
      display: flex;
      flex-direction: column;
      align-items: center;
      width: 80%;
    }

    .book-action-section {
      display: flex;
      flex-direction: column;
      width: 20%;
      align-items: center;
    }
  }
}
</style>
