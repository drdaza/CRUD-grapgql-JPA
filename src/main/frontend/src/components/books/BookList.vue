<script setup>
import { onBeforeMount } from 'vue'
import { useBookStore } from '@/stores/bookStore'

import BookListItem from './BookListItem.vue'

const bookStore = useBookStore()

onBeforeMount(() => {
  bookStore.findAllBooks()  
})

</script>
<template>
    <div class="list-wrapper">
        <BookListItem v-for="book of bookStore.allBooks" :book="book"/>
    </div>
</template>
<style lang="scss" scoped>
    
</style>