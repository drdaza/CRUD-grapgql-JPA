<script setup>
import { computed, ref, onBeforeMount } from 'vue';
import { useBookStore } from '../stores/bookStore'
import { useAuthorStore } from '../stores/authorStore'
import BookList from '../components/books/BookList.vue'
import CreateNewItem from '../components/creationComponents/CreateNewItem.vue';
import PopupNotification from '../components/shared/PopupNotification.vue';
const authorStore = useAuthorStore()
const bookStore = useBookStore()
const name = ref('')
const age = ref(0)
const showPopUp = ref(false)

onBeforeMount(() => {
  bookStore.findAllBooks()
  authorStore.findAllAuthors()
})

const existBooks = computed(() => {
  return bookStore.allBooks.length > 0
})

const bookForEditActions = (event) => {
  console.log(event);
}

const createNewBookEmitHandler = (event) => {
  const newBookForCreate = parseValueForCreateNewBook(event)
  if (authorExist(event.bookAuthorId)) {
    bookStore.createBook(newBookForCreate)
    return
  }

  showPopUp.value = true


  setTimeout(() => {
    showPopUp.value = false
  }, 3000)
}

const parseValueForCreateNewBook = (event) => {
  return {
    title: event.bookTitle,
    description: event.bookDescription ? event.bookDescription : '',
    authorId: event.bookAuthorId
  }
}

const authorExist = (authorId) => {
  return authorStore.allAuthors.find(author => parseInt(author.id) === authorId) || null
}
</script>
<template>
  <main>
    <transition>
      <PopupNotification v-show="showPopUp" :message="'author does not exist'" :notification-type="'warning'" />
    </transition>
    <div class="title-zone">
      <h1>Books</h1>
    </div>
    <div class="content-zone">
      <section class="list-books-section">
        <BookList @emit-book-info-for-edit="bookForEditActions" v-if="existBooks" />
        <h4 v-if="!existBooks">there is no book in this section yet, do you want to create a new item?</h4>
      </section>
      <section class="book-action-section">
        <CreateNewItem @new-item-create="createNewBookEmitHandler" :type-of-element="'Book'"
          :title-section="'Create a new Book'" />
      </section>
    </div>
  </main>
</template>
<style lang="scss" scoped>
main {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2vh;

  .content-zone {
    width: 100%;
    display: flex;
    justify-content: space-evenly;

    .list-books-section {
      display: flex;
      flex-direction: column;
      align-items: center;
      width: 80%;
    }

    .book-action-section {
      display: flex;
      flex-direction: column;
      width: 20%;
      align-items: center;
    }
  }
}

.v-enter-active,
.v-leave-active {
  transition: opacity 0.5s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
}
</style>
