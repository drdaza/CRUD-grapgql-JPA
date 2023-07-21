<script setup>
import { useAuthorStore } from '@/stores/authorStore'
import AuthorListItem from './AuthorListItem.vue';
import { onBeforeMount } from 'vue';

const authorStore = useAuthorStore()

onBeforeMount(() => {
    authorStore.findAllAuthors()
})

</script>
<template>
    <main>
        <h1>Authors List</h1>
        <div class="list-wrapper">
            <AuthorListItem v-for="author of authorStore.allAuthors" :author="author" />
        </div>
    </main>
</template>
<style lang="scss" scoped>
main{
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>