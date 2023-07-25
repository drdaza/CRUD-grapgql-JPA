<script setup>
import { onBeforeMount } from 'vue'
import { useBookStore } from '@/stores/bookStore'

import BookListItem from './BookListItem.vue'

const bookStore = useBookStore()

onBeforeMount(() => {
  bookStore.findAllBooks()  
})

const emits = defineEmits(['emitBookInfoForEdit'])

const emitBookInfo = (event)=>{
  const bookForEdit = bookStore.allBooks.find(book => book.id && book.id === event)
  emits('emitBookInfoForEdit', bookForEdit)
}
// Hacer un script para rellenar tanto authors como books de forma automatica, probablemente con python o con una libreria de js, si es que existe alguna y lo hace de buena manera
</script>
<template>
    <div class="list-wrapper">
        <BookListItem v-for="book of bookStore.allBooks" :book="book" @edit-book-emit="emitBookInfo"/>
    </div>
</template>
<style lang="scss" scoped>
    
</style>