<script setup>

const props = defineProps({
    author: {
        type:Object,
        required: true,
        default: {}
    }
})

</script>
<template>
    <div class="item-wrapper">
        <img src="" alt="">
        <h2>{{ author.name }}</h2>
        <p>{{ author.age }}</p>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/sass/variables' as *;
.item-wrapper {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
    width: 100%;
    height: 10vh;
}
</style>