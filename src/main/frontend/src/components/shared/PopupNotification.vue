<script setup>
const props = defineProps({
    message: {
        type: String,
        default: 'this is a notification'
    },
    notificationType: {
        type: String,
        default: 'warning'
    }
})
</script>
<template>
    <div :class="['popup-notification-wrapper', notificationType]">
        <h4>{{ props.message }}</h4>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/sass/main' as *;
.popup-notification-wrapper {
    @include flexDisplay(row, center, center, 200px);
    background-color: map-get($map: $colors, $key: 'warning');
    height: 30px;
    border-radius: 5px;
    z-index: 2;
    margin-top: 2vh;
    h4 {
        color: black;
        text-align: center;
        background: none;
        width: 100%;
    }
}
</style>