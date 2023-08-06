<script setup>
import { useAuthorStore } from '@/stores/authorStore'
import AuthorListItem from './AuthorListItem.vue';
import Createnewitem from '../creationcomponents/Createnewitem.vue';
import { onBeforeMount } from 'vue';

const authorStore = useAuthorStore()

onBeforeMount(() => {
    authorStore.findAllAuthors()
})

const createNewAuthorEmitHandler = (event) => {
    console.log(event);
    const authorForCreation = parseValueForQuery(event)
    authorStore.createAuthor(authorForCreation)
}
const parseValueForQuery = (event) => {
    return {
        name: event.authorName,
        age: event.authorAge
    }
}
</script>
<template>
    <main>
        <h1>Authors List</h1>
        <div class="list-wrapper">
            <AuthorListItem v-for="author of authorStore.allAuthors" :author="author" />
        </div>
        <div>
            <Createnewitem @new-item-create="createNewAuthorEmitHandler" :type-of-element="'Author'" :title-section="'Create new Author'" />
        </div>
    </main>
</template>
<style lang="scss" scoped>
main {
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>