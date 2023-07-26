<script setup>
import { ref } from 'vue';

const props = defineProps({
    value: {
        type: String || Number,
        required: false,
        default: null
    },
    type: {
        type: String,
        required: true,
        default: 'text'
    }
})

const valueOfInput = ref(null)

const emits = defineEmits(['emitValueInput'])

const emitValueInput = () => {
    const emitMapOptions = {
        'text': ()=>{emits('emitValueInput', valueOfInput.value)},
        'number': ()=>{
            if (Number.isNaN(parseFloat(valueOfInput.value))) {return}
            emits('emitValueInput', !Number.isNaN(parseFloat(valueOfInput.value)) ? valueOfInput.value : '')
        }
    }
    emitMapOptions[props.type]()
}
</script>
<template>
    <div class="generic-input-wrapper">
        <label class="generic-input-label"><b>This is a normal Input</b></label>
        <input v-model="valueOfInput" type="text" class="generic-input-style" @input="emitValueInput">
    </div>
</template>
<style lang="scss" scoped>
.generic-input-wrapper {
    display: flex;
    flex-direction: column;
    gap: 1vh;
    width: 250px;
    .generic-input-style {
        transition: 0.2s;
        height: 4vh;
        font-size: medium;
        border-top: none;
        border-left: none;
        border-right: none;
        border-bottom: solid blanchedalmond 1.5px;
    }
    .generic-input-style:focus{
        transition: 0.2s;
        border-bottom: solid green 1px;
        outline: none; 
    }

}
</style>