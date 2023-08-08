<script setup>
import { onBeforeMount } from 'vue'
import { useBookStore } from '@/stores/bookStore'

import BookListItem from './BookListItem.vue'

const bookStore = useBookStore()

onBeforeMount(() => {
  bookStore.findAllBooks()
})

const emits = defineEmits(['emitBookInfoForEdit'])

const emitBookInfo = (event) => {
  const bookForEdit = bookStore.allBooks.find(book => book.id && book.id === event)
  emits('emitBookInfoForEdit', bookForEdit)
}
// Hacer un script para rellenar tanto authors como books de forma automatica, probablemente con python o con una libreria de js, si es que existe alguna y lo hace de buena manera
</script>
<template>
  <div class="list-wrapper">
    <div class="list-item-wrapper" v-for="book of bookStore.allBooks">
      <BookListItem  :book="book" @edit-book-emit="emitBookInfo" />
    </div>
  </div>
</template>
<style lang="scss" scoped>
@use '../../assets/sass/mixins' as *;

.list-wrapper {
  @include flexDisplay(row, center, space-evenly, 100%);
  flex-wrap: wrap;
  gap: 2vh;
  transition: 0.5s;
  .list-item-wrapper {
    width: 30%;
  }
}
</style>