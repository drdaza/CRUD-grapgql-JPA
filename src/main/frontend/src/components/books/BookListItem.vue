<script setup>

const props = defineProps({
    book: {
        type:Object,
        required: true,
        default: {}
    }
})

const emits = defineEmits(['editBookEmit'])

const editBookEmit = ()=>{
    emits('editBookEmit', props.book.id)
}
</script>
<template>
    <div class="item-wrapper" @click="editBookEmit()">
        <img src="../../assets/img/pngwing.com.png" alt="book image">
        <h2>{{ book.title }}</h2>
        <p>{{ book.description }}</p>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/sass/variables' as *;
.item-wrapper {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 30vh;
    img{
        width: 20vh;
        height: 25vh;
    }
}
</style>