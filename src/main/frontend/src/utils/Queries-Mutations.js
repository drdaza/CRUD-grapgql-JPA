import { useQuery, useMutation } from '@vue/apollo-composable'
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

