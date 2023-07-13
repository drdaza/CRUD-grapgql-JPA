import { useQuery, useMutation } from '@vue/apollo-composable'
import gql from 'graphql-tag'
import { computed, ref } from 'vue';

const ALL_AUTHORS_QUERY = gql`
      query {
        findAllAuthors{
          id
          name
          age
      }
      }
`
export function useFindAllAuthors() {
    const { result } = useQuery(ALL_AUTHORS_QUERY)
    const authors = computed(() =>
        result.value?.findAllAuthors ?? []
    )

    return authors
}