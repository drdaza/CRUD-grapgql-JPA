import { defineStore } from 'pinia'
import { ref } from 'vue'
import { useFindAllAuthors } from '../composables/callUtils'

export const useAuthorStore = defineStore('authors' ,() => {

    const allAuthors = ref([])

    function findAllAuthors () {
        allAuthors.value = useFindAllAuthors();
    }

    return {allAuthors, findAllAuthors}
})