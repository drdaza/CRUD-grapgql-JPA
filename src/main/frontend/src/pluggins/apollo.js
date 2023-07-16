import {
    ApolloClient,
    createHttpLink,
    InMemoryCache
} from '@apollo/client/core'
import {onError} from '@apollo/client/link/error'
import { useErrorsStore } from '../stores/errorStore'
import {setContext} from '@apollo/client/link/context'

const httpLink = createHttpLink({
    uri: 'http://localhost:8080/graphql'
})
const errorHandler = onError(({graphQLErrors}) => {
    if(graphQLErrors) 
        useErrorsStore().$state = {
            message: graphQLErrors[0].message,
            category: graphQLErrors.extensions.category,
            fields: graphQLErrors.extensions.validation ?? {input: {}},
        };
})

const cache = new InMemoryCache();

const apolloClient = new ApolloClient({
    link: httpLink, cache
})

export default apolloClient