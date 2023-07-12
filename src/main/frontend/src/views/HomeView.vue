<script setup>
import { useQuery} from '@vue/apollo-composable'
import gql from 'graphql-tag'
import { computed, watchEffect } from 'vue';


const ALL_AUTHORS_QUERY = gql`
      query {
        findAllAuthors{
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

watchEffect(()=>{
console.log(result)
})

</script>

<template>
  <main>
    <ul>
    <li v-for="author in authors" :key="author.id">{{ author.name }}</li></ul>
  </main>
</template>
