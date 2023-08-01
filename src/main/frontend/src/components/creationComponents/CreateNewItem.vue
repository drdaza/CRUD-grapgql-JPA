<script setup>
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
const creationOptions = {
    'author': () => { console.log('try create a new author') },
    'book': () => { console.log('tye create a new book'); }
}

const emitHandler = (event) => {

}
// incluir la posibilidad de que si no se escoge un author cuando creemos un libro se cree con un author de nombre desconocido
</script>
<template>
    <div class="create-new-item-wrapper">
        <div class="title-zone">
            <h2>{{ titleSection }}</h2>
        </div>
        <div class="create-new-item-container" v-show="typeOfElement === 'Author'">
            <GenericInput :type="'text'" :label="'Author name:'" @emit-value-input="emitHandler" />
            <GenericInput :type="'number'" :label="'Author age:'" @emit-value-input="emitHandler" />
        </div>
        <div class="create-new-item-container" v-show="typeOfElement === 'Book'">
            <GenericInput :type="'text'" :label="'Book title:'" @emit-value-input="emitHandler" />
            <GenericInput :type="'text'" :label="'Book description:'" @emit-value-input="emitHandler" />
            <GenericInput :type="'number'" :label="'Author id:'" @emit-value-input="emitHandler" />
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
