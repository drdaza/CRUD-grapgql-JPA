<script setup>

const props = defineProps({
    book: {
        type:Object,
        required: true,
        default: {}
    }
})

</script>
<template>
    <div class="item-wrapper">
        <img src="" alt="">
        <h2>{{ book.title }}</h2>
        <p>{{ book.description }}</p>
    </div>
</template>
<style lang="scss">
@use '../../assets/sass/variables' as *;
.item-wrapper {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 33%;
    height: 30vh;
}
</style>