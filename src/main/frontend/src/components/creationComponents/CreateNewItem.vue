<script setup>
import { reactive } from 'vue';
import GenericInput from '../shared/GenericInput.vue'
const props = defineProps({
    typeOfElement: {
        type: String,
        required: true,
        default: null
    },
    titleSection: {
        type: String,
        required: false,
        default: 'Section'
    }
})

const newItemCreate = reactive({})
const emits = defineEmits(['newItemCreate'])
const creationOptions = {
    'Author': (event) => {
        newItemCreate[event.identifier] = event.value
     },
    'Book': (event) => { 
        newItemCreate[event.identifier] = event.value
     }
}

const emitHandler = (event) => {
    creationOptions[props.typeOfElement](event)
}

const emitItemCreate = () => {
    emits('newItemCreate', newItemCreate)
}
// incluir la posibilidad de que si no se escoge un author cuando creemos un libro se cree con un author de nombre desconocido
</script>
<template>
    <div class="create-new-item-wrapper">
        <div class="title-zone">
            <h2>{{ titleSection }}</h2>
        </div>
        <div class="create-new-item-container" v-show="typeOfElement === 'Author'">
            <GenericInput :input-identifier="'authorName'" :type="'text'" :label="'Author name:'" @emit-value-input="emitHandler" />
            <GenericInput :input-identifier="'authorAge'" :type="'number'" :label="'Author age:'" @emit-value-input="emitHandler" />
        </div>
        <div class="create-new-item-container" v-show="typeOfElement === 'Book'">
            <GenericInput :input-identifier="'bookTitle'" :type="'text'" :label="'Book title:'" @emit-value-input="emitHandler" />
            <GenericInput :input-identifier="'bookDescription'" :type="'text'" :label="'Book description:'" @emit-value-input="emitHandler" />
            <GenericInput :input-identifier="'bookAuthorId'" :type="'number'" :label="'Author id:'" @emit-value-input="emitHandler" />
        </div>
        <div class="create-new-item-container">
            <button @click="emitItemCreate">Create new {{ typeOfElement }}</button>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/sass/mixins' as *;
.create-new-item-wrapper {
    @include flexDisplay(column, center, normal, 100%);
    gap: 2vh;
    .create-new-item-container {
        @include flexDisplay(column, center, normal, 80%);
        gap: 0.5vh;
    }
}
</style>
