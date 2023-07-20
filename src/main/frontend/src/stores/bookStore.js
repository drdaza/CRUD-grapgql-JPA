import { defineStore } from "pinia"
import  apolloClient  from '../pluggins/apollo'
import { CREATE_BOOK_MUTATION, ALL_BOOKS_QUERY } from '../utils/Queries-Mutations'
import { ref } from "vue"

export const useBookStore = defineStore('books', () => {

    const allBooks = ref([])

    function findAllBooks() {
        apolloClient.query({ query: ALL_BOOKS_QUERY }).then(response => {
          allBooks.value = response.data.findAllBooks
        }
        )
    }

    function createBook(data) {
        apolloClient.mutate({mutation: CREATE_BOOK_MUTATION, variables: {
            title: data.title,
            description: data.description,
            authorId: data.authorId
        }, 
        update: (cache, {data: {createBook}}) =>{
          let data = cache.readQuery({query: ALL_BOOKS_QUERY})
          data = {
            ...data,
            findAllBooks: [
              ...data.findAllBooks,
              createBook,
            ],
          }
          cache.writeQuery({query: ALL_BOOKS_QUERY, data})
        }
    }).then(() => {
        findAllBooks()
      })
    }
    return { allBooks, createBook, findAllBooks}
})