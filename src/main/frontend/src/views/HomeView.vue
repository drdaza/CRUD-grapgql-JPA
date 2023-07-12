<script setup>
import { useQuery, useMutation} from '@vue/apollo-composable'
import gql from 'graphql-tag'
import { computed, ref } from 'vue';

const name = ref('')
const age = ref(0)

const ALL_AUTHORS_QUERY = gql`
      query {
        findAllAuthors{
          id
          name
          age
      }
      }
`

const CREATE_AUTHOR_MUTATION = gql`
      mutation createAuthor($name: String! $age: Int){
        createAuthor (name: $name age: $age) {
          id
          name
          age
        }
      }
`
const {result} = useQuery(ALL_AUTHORS_QUERY)
const authors = computed(()=>
  result.value?.findAllAuthors ?? []
)

const {mutate: createAuthor} = useMutation(CREATE_AUTHOR_MUTATION, () => ({
  variables: {
    name: name.value,
    age: age.value
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
}))

</script>

<template>
  <main>
    <input type="text" v-model="name">
    <input type="number" v-model="age">
    <button @click="createAuthor()">test</button>
    <ul>
    <li v-for="author in authors" :key="author.id">{{ author.name }}</li></ul>
  </main>
</template>
