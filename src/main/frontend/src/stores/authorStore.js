import { defineStore } from 'pinia'
import { ALL_AUTHORS_QUERY, CREATE_AUTHOR_MUTATION, DELETE_AUTHOR_MUTATION, UPDATE_AUTHOR_MUTATION } from '../utils/Queries-Mutations'
import apolloClient from '../pluggins/apollo'
import { computed, ref } from 'vue';


export const useAuthorStore = defineStore('authors', () => {

  const allAuthors = ref([])

  function findAllAuthors() {
    apolloClient.query({ query: ALL_AUTHORS_QUERY }).then(response => {
      allAuthors.value = response.data.findAllAuthors
    }
    )
  }

  function createAuthor(data) {
    apolloClient.mutate({
      mutation: CREATE_AUTHOR_MUTATION, variables: {
        name: data.name,
        age: data.age
      }, 
      update: (cache, {data: {createAuthor}}) =>{
        let data = cache.readQuery({query: ALL_AUTHORS_QUERY})
        data = {
          ...data,
          findAllAuthors: [
            ...data.findAllAuthors,
            createAuthor,
          ],
        }
        cache.writeQuery({query: ALL_AUTHORS_QUERY, data})
      }
    }
    ).then(response => {
      findAllAuthors()
    })

  }

  function deleteAuthor(authorId) {
    apolloClient.mutate({
      mutation: DELETE_AUTHOR_MUTATION, variables:{
        id: authorId
      }
    }).then(response => allAuthors.value = response.data.deleteAuthor)
  }

  function updateAuthor(data) {
    apolloClient.mutate({
      mutation: UPDATE_AUTHOR_MUTATION, variables: {
        id: data.id,
        name: data.name,
        age: data.age
      }, 
      update: (cache, {data: {updateAuthor}}) =>{
        let data = cache.readQuery({query: ALL_AUTHORS_QUERY})
        data = {
          ...data,
          findAllAuthors: [
            ...data.findAllAuthors.filter(author => author.id !== updateAuthor.id),
            updateAuthor,
          ],
        }

        cache.writeQuery({query: ALL_AUTHORS_QUERY, data})
      }
    }).then(response => findAllAuthors())
  }

  return { allAuthors, findAllAuthors, createAuthor, deleteAuthor, updateAuthor }
})