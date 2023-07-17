import gql from 'graphql-tag'
import { computed, ref } from 'vue';


export const ALL_AUTHORS_QUERY = gql`
      query {
        findAllAuthors{
          id
          name
          age
      }
      }
`
export const CREATE_AUTHOR_MUTATION = gql`
      mutation createAuthor($name: String! $age: Int){
        createAuthor (name: $name age: $age) {
          id
          name
          age
        }
      }
`
export const DELETE_AUTHOR_MUTATION = gql`
      mutation deleteAuthor($id: ID!){
        deleteAuthor (id: $id) {
          id
          name
          age
        }
      }
`
export const UPDATE_AUTHOR_MUTATION = gql`
      mutation updateAuthor($id:ID! $name: String! $age:Int){
        updateAuthor (id: $id name: $name age: $age ){
          id
          name
          age
        }
      }
`

